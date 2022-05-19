package olivermakesco.de.refmagic.mixin;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.BrewingRecipeRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BrewingRecipeRegistry.class)
public class Mixin_BrewingRecipeRegistry {
    @Inject(at = @At("RETURN"), method = "craft", cancellable = true)
    private static void getStackSize(ItemStack input, ItemStack ingredient, CallbackInfoReturnable<ItemStack> cir) {
        var stack = cir.getReturnValue();
        stack.setCount(ingredient.getCount());
        cir.setReturnValue(stack);
    }
}
