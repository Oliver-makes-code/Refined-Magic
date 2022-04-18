package olivermakesco.de.refmagic.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = {"net/minecraft/screen/BrewingStandScreenHandler$PotionSlot"})
public class PotionSlotMixin {
    @Inject(at = @At("RETURN"), method = "getMaxItemCount", cancellable = true)
    private void maxItems(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(64);
    }
}
