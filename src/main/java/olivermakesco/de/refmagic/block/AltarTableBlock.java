package olivermakesco.de.refmagic.block;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.command.ParticleCommand;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import olivermakesco.de.refmagic.Mod;
import olivermakesco.de.refmagic.block.entity.AltarTableBlockEntity;
import olivermakesco.de.refmagic.registry.RefinedMagicItems;
import olivermakesco.de.refmagic.registry.RefinedMagicRecipes;
import org.jetbrains.annotations.Nullable;

public class AltarTableBlock extends BlockWithEntity implements Waterloggable {
    public AltarTableBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new AltarTableBlockEntity(pos,state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public boolean isTranslucent(BlockState state, BlockView world, BlockPos pos) {
        return false;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.union(
                VoxelShapes.cuboid(0f,0.5625f,0f,1f, 0.75f,1f),
                VoxelShapes.cuboid(0.125f,0f,0.125f,0.3125f, 0.5625f,0.3125f),
                VoxelShapes.cuboid(0.125f,0f,0.6875f,0.3125f,0.5625f,0.875f),
                VoxelShapes.cuboid(0.6875f,0f,0.125f,0.875f,0.5625f,0.3125f),
                VoxelShapes.cuboid(0.6875f,0f,0.6875f,0.875f,0.5625f,0.875f)
        );
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return getOutlineShape(state, world, pos, context);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) return ActionResult.SUCCESS;
        var serverWorld = (ServerWorld)world;
        if (player.isSneaking()) return ActionResult.PASS;
        var entity = (AltarTableBlockEntity) world.getBlockEntity(pos);
        assert entity != null;


        if (player.getStackInHand(hand).getItem() == RefinedMagicItems.kyritePowder) {
            for (var recipe : RefinedMagicRecipes.altarRecipes.entrySet()) {
                Mod.info(String.valueOf(entity.test(recipe.getValue().a, recipe.getValue().b, recipe.getValue().c, recipe.getValue().d)));
                if (entity.test(recipe.getValue().a, recipe.getValue().b, recipe.getValue().c, recipe.getValue().d)) {
                    var result = recipe.getValue().craft(entity);
                    player.getInventory().insertStack(result);
                    entity.clear();
                    player.getStackInHand(hand).decrement(1);
                    update(pos, serverWorld);
                    world.playSound(null,pos,SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE,SoundCategory.BLOCKS,10,0);
                    serverWorld.spawnParticles(ParticleTypes.EXPLOSION_EMITTER, pos.getX(), pos.getY()+0.5, pos.getZ(), 15, 1, 1, 1, 1);
                    return ActionResult.SUCCESS;
                }
            }

            return ActionResult.PASS;
        }

        var x = hit.getPos().x % 1;
        x += 1;
        x %= 1;
        var z = hit.getPos().z % 1;
        z += 1;
        z %= 1;
        int a = x < 0.5? 0b00: 0b01;
        int b = z < 0.5? 0b00: 0b10;
        int c = a+b;
        if (entity.getSlot(c) == ItemStack.EMPTY) {
            if (player.getStackInHand(hand).isEmpty())
                return ActionResult.PASS;

            var next = player.getStackInHand(hand).getItem().getDefaultStack();
            player.getStackInHand(hand).decrement(1);
            entity.setSlot(c,next);
            update(pos, serverWorld);
            world.playSound(null,pos,SoundEvents.BLOCK_END_PORTAL_FRAME_FILL,SoundCategory.BLOCKS,10,0);
            return ActionResult.SUCCESS;
        }
        var stackToSet = ItemStack.EMPTY;
        if (!player.getStackInHand(hand).isEmpty() && player.getStackInHand(hand).getItem() != entity.getSlot(c).getItem()) {
            stackToSet = player.getStackInHand(hand).getItem().getDefaultStack();
            player.getStackInHand(hand).decrement(1);
        }
        var next = entity.getSlot(c);
        player.getInventory().insertStack(next);
        entity.setSlot(c, stackToSet);
        update(pos, serverWorld);
        world.playSound(null,pos,SoundEvents.BLOCK_END_PORTAL_FRAME_FILL,SoundCategory.BLOCKS,10,0);
        return ActionResult.SUCCESS;
    }

    public void update(BlockPos pos, ServerWorld world) {
        world.getChunkManager().markForUpdate(pos);
    }

}
