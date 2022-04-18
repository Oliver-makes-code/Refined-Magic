package olivermakesco.de.refmagic.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PotionItem;
import net.minecraft.world.World;
import olivermakesco.de.refmagic.RefinedMagicPotionUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PotionItem.class)
public class PotionItemMixin {
    @ModifyVariable(method = "<init>", at = @At("HEAD"), ordinal = 0, argsOnly = true)
    private static Item.Settings changeStackSize(Item.Settings old) {
        return old.maxCount(16);
    }

    @Inject(at=@At("RETURN"), method="finishUsing")
    private void setCooldown(ItemStack stack, World world, LivingEntity user, CallbackInfoReturnable<ItemStack> cir) {
        if (!(user instanceof PlayerEntity player)) return;
        RefinedMagicPotionUtil.setCooldown(player);
    }

    @Inject(at = @At("RETURN"), method = "getMaxUseTime(Lnet/minecraft/item/ItemStack;)I", cancellable = true)
    private void setUseTime(ItemStack stack, CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(16);
    }
}
