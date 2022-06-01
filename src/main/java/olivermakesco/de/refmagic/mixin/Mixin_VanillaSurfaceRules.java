package olivermakesco.de.refmagic.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.surfacebuilder.SurfaceRules;
import net.minecraft.world.gen.surfacebuilder.VanillaSurfaceRules;
import olivermakesco.de.refmagic.registry.RefinedMagicBlocks;
import olivermakesco.de.refmagic.world.BiomeInit;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(VanillaSurfaceRules.class)
public abstract class Mixin_VanillaSurfaceRules {
    @Shadow
    private static SurfaceRules.MaterialRule block(Block block) {
        return null;
    }

    @Inject(method = "getEndRules", at = @At("RETURN"), cancellable = true)
    private static void changeEndRules(CallbackInfoReturnable<SurfaceRules.MaterialRule> cir) {
        var ret = cir.getReturnValue();
        cir.setReturnValue(SurfaceRules.sequence(SurfaceRules.condition(
                SurfaceRules.biome(BiomeInit.mushroomIsles),
                SurfaceRules.condition(
                        SurfaceRules.ON_FLOOR,
                        block(RefinedMagicBlocks.enlium)
                )
        ), ret));
    }
}
