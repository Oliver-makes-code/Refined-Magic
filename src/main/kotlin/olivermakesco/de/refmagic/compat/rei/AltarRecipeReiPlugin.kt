package olivermakesco.de.refmagic.compat.rei

import me.shedaniel.rei.api.client.plugins.REIClientPlugin
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry
import olivermakesco.de.refmagic.recipe.AltarRecipe

class AltarRecipeReiPlugin : REIClientPlugin {
    override fun registerCategories(registry: CategoryRegistry) {
        registry.add(AltarRecipeDisplayCategory())
    }

    override fun registerDisplays(registry: DisplayRegistry) {
        registry.registerFiller(AltarRecipe::class.java) { recipe: AltarRecipe? ->
            AltarRecipeDisplay(
                recipe!!
            )
        }
    }
}