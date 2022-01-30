package olivermakesco.de.refinedmagic.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SplashPotionItem;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import olivermakesco.de.refinedmagic.PotionUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SplashPotionItem.class)
public class SplashPotionItemMixin {
    @ModifyVariable(method = "<init>", at = @At("HEAD"), ordinal = 0, argsOnly = true)
    private static Item.Settings changeStackSize(Item.Settings old) {
        return old.maxCount(16);
    }

    @Inject(at=@At("RETURN"), method="use")
    private void setCooldown(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> cir) {
        PotionUtil.setCooldown(user);
    }
}
