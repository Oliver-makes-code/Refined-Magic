package olivermakesco.de.potiontweaks.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtil;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import olivermakesco.de.potiontweaks.registry.Potions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Mixin(Block.class)
public class BlockMixin {
    @Inject(at = @At("RETURN"), method = "getDroppedStacks(Lnet/minecraft/block/BlockState;Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/entity/Entity;Lnet/minecraft/item/ItemStack;)Ljava/util/List;", cancellable = true)
    private static void smeltIfEffect(BlockState state, ServerWorld world, BlockPos pos, BlockEntity blockEntity, Entity entity, ItemStack stack, CallbackInfoReturnable<List<ItemStack>> cir) {
        if (!(entity instanceof LivingEntity livingEntity)) return;
        if (!livingEntity.hasStatusEffect(Potions.smeltingAura)) return;

        var inputStack = cir.getReturnValue();
        var outputStack = new ArrayList<ItemStack>();
        for (var newStack : inputStack) {
            Optional<SmeltingRecipe> recipe = world.getRecipeManager().listAllOfType(RecipeType.SMELTING).stream().filter((smeltingRecipe -> smeltingRecipe.getIngredients().get(0).test(newStack))).findFirst();
            if (recipe.isPresent()) {
                ItemStack out = recipe.get().getOutput();
                out.setCount(newStack.getCount());
                outputStack.add(out);
            } else
                outputStack.add(newStack);
        }
        cir.setReturnValue(outputStack);
    }
}
