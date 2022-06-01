package olivermakesco.de.refmagic.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ChorusPlantBlock;
import olivermakesco.de.refmagic.registry.RefinedMagicBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ChorusPlantBlock.class)
public class Mixin_ChorusPlantBlock {
    @Redirect(method = "canPlaceAt", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"))
    private boolean isOfEnlium(BlockState instance, Block block) {
        if (block != Blocks.END_STONE) return instance.isOf(block);
        return instance.isOf(block) || instance.isOf(RefinedMagicBlocks.enlium);
    }
}
