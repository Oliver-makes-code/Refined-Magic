package olivermakesco.de.refmagic.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import olivermakesco.de.refmagic.Mod;
import olivermakesco.de.refmagic.block.entity.AltarTableBlockEntity;
import olivermakesco.de.refmagic.recipe.serializer.AltarRecipeSerializer;
import olivermakesco.de.refmagic.registry.RefinedMagicRecipes;

import java.util.Arrays;

public record AltarRecipe(Identifier id, Ingredient catalyst, Ingredient[] inputs,
                          ItemStack result) implements Recipe<AltarTableBlockEntity> {

    public static Identifier ID = Mod.id("altar");

    @Override
    public boolean matches(AltarTableBlockEntity inventory, World world) {
        if (!catalyst.test(inventory.catalyst)) {
            return false;
        }
        boolean[] met = new boolean[4];
        for (int i = 0; i < inventory.size(); i++) {
            ItemStack stack = inventory.getStack(i);
            for (int j = 0; j < inputs.length; j++) {
                if (!met[j]) {
                    if (inputs[j].test(stack)) {
                        met[j] = true;
                    }
                }
            }
        }
        for (boolean b : met) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack craft(AltarTableBlockEntity inventory) {
        return result.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return width < 4 && height == 1;
    }

    @Override
    public ItemStack getOutput() {
        return result;
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return AltarRecipeSerializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<AltarRecipe> {
        public static final Type INSTANCE = new Type();
    }

    public static void register() {
        Registry.register(Registry.RECIPE_SERIALIZER, ID, AltarRecipeSerializer.INSTANCE);
    }
}
