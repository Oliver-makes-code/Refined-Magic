package olivermakesco.de.refmagic.compat.rei;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import olivermakesco.de.refmagic.recipe.AltarRecipe;

public class AltarRecipeReiPlugin implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new AltarRecipeDisplayCategory());
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerFiller(AltarRecipe.class, AltarRecipeDisplay::new);
    }
}
