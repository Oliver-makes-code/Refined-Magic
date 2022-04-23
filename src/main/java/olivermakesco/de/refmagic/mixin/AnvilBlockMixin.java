package olivermakesco.de.refmagic.mixin;

import net.minecraft.block.AnvilBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import olivermakesco.de.refmagic.registry.RefinedMagicItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AnvilBlock.class)
public class AnvilBlockMixin {
    @Inject(at = @At("RETURN"), method = "onLanding")
    private void checkIfItem(World world, BlockPos pos, BlockState fallingBlockState, BlockState currentStateInPos, FallingBlockEntity fallingBlockEntity, CallbackInfo ci) {
        var entities = world.getOtherEntities(fallingBlockEntity, fallingBlockEntity.getBoundingBox());
        for (var entity : entities) {
            if (entity instanceof ItemEntity itemEntity) {
                var item = itemEntity.getStack();
                if (item.getItem() == RefinedMagicItems.kyriteShard) {
                    var newStack = RefinedMagicItems.kyritePowder.getDefaultStack();
                    newStack.setCount(item.getCount());
                    itemEntity.setStack(newStack);
                }
            }
        }
    }
}
