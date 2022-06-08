package olivermakesco.de.refmagic.mixin;

import net.minecraft.block.AnvilBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import olivermakesco.de.refmagic.registry.RefinedMagicItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(AnvilBlock.class)
public class Mixin_AnvilBlock {
    @Inject(at = @At("RETURN"), method = "onLanding")
    private void checkIfItem(World world, BlockPos pos, BlockState fallingBlockState, BlockState currentStateInPos, FallingBlockEntity fallingBlockEntity, CallbackInfo ci) {
        List<Entity> entities = world.getOtherEntities(fallingBlockEntity, fallingBlockEntity.getBoundingBox());
        for (Entity entity : entities) {
            if (entity instanceof ItemEntity itemEntity) {
                ItemStack item = itemEntity.getStack();
                if (item.getItem() == RefinedMagicItems.kyriteShard) {
                    ItemStack newStack = RefinedMagicItems.kyritePowder.getDefaultStack();
                    newStack.setCount(item.getCount());
                    itemEntity.setStack(newStack);
                }
            }
        }
    }
}
