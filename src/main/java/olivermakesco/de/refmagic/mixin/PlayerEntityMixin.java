package olivermakesco.de.refmagic.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import olivermakesco.de.refmagic.item.DimensionalTotemItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
    @Shadow protected abstract void vanishCursedItems();

    @Shadow public abstract PlayerInventory getInventory();

    @Inject(at = @At("HEAD"), method = "dropInventory", cancellable = true)
    private void dropInjection(CallbackInfo ci) {
        var inv = getInventory();
        if (inv.getStack(inv.selectedSlot).getItem() instanceof DimensionalTotemItem) {
            inv.removeStack(inv.selectedSlot);
            vanishCursedItems();
            ci.cancel();
        } else if (inv.getStack(45).getItem() instanceof DimensionalTotemItem) {
            inv.removeStack(45);
            vanishCursedItems();
            ci.cancel();
        }
    }
}
