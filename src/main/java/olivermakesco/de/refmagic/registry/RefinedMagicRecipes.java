package olivermakesco.de.refmagic.registry;

import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.registry.Registry;
import olivermakesco.de.refmagic.Mod;
import olivermakesco.de.refmagic.recipe.AltarRecipe;
import olivermakesco.de.refmagic.recipe.serializer.AltarRecipeSerializer;

public class RefinedMagicRecipes {

    public static void register() {
        AltarRecipe.register();
    }
}
