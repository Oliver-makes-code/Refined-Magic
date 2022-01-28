package olivermakesco.de.refinedmagic.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import olivermakesco.de.refinedmagic.block.GlassTankBlock;
import olivermakesco.de.refinedmagic.registry.RefinedMagicBlockEntities;

import java.util.ArrayList;
import java.util.List;

public class GlassTankBlockEntity extends BlockEntity {
    public int potionStrength = 0;
    public int fluidLevel = 0;
    public List<StatusEffectInstance> effects = new ArrayList<>();

    public GlassTankBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(RefinedMagicBlockEntities.glassTank, blockPos, blockState);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putInt("strength",potionStrength);
        nbt.putInt("level",fluidLevel);
        NbtList list = new NbtList();
        for (var effect : effects)
            list.add(effect.writeNbt(new NbtCompound()));
        nbt.put("effects", list);
    }
    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        potionStrength = nbt.getInt("strength");
        fluidLevel = nbt.getInt("level");
        NbtList list = nbt.getList("effects", 10);
        effects = new ArrayList<>();
        for (var element : list) {
            if (!(element instanceof  NbtCompound compound)) continue;
            effects.add(StatusEffectInstance.fromNbt(compound));
        }
    }

    public boolean addPotion(Potion potion) {
        if (potionStrength > 4) return false;
        if (fluidLevel >= 2) return false;
        var potionEffects = potion.getEffects();
        if (potionStrength == 4) potionEffects.add(Potions.STRONG_POISON.getEffects().get(0));
        for (var potionEffect : potionEffects) {
            var applied = false;
            for (var effect : effects) {
                if (effect.getEffectType() == potionEffect.getEffectType()) {
                    effect.upgrade(potionEffect);
                    applied = true;
                    break;
                }
            }
            if (!applied) {
                effects.add(potionEffect);
            }
        }
        potionStrength++;
        fluidLevel += 40;
        return true;
    }

    public static class Ticker implements BlockEntityTicker<GlassTankBlockEntity> {
        @Override
        public void tick(World world, BlockPos blockPos, BlockState blockState, GlassTankBlockEntity blockEntity) {
            if (blockEntity.fluidLevel > 0 && checkFire(world, blockPos)) blockEntity.fluidLevel--;
        }
        public boolean checkFire(World world, BlockPos pos) {
            var block = world.getBlockState(pos.down()).getBlock();
            return block.equals(Blocks.CAMPFIRE) || block.equals(Blocks.SOUL_CAMPFIRE) || block.equals(Blocks.FIRE) || block.equals(Blocks.SOUL_FIRE);
        }
    }
}
