package olivermakesco.de.refmagic.compat.rei

import me.shedaniel.rei.api.common.category.CategoryIdentifier
import me.shedaniel.rei.api.common.display.Display
import me.shedaniel.rei.api.common.entry.EntryIngredient
import me.shedaniel.rei.api.common.util.EntryIngredients
import olivermakesco.de.refmagic.Mod
import olivermakesco.de.refmagic.recipe.AltarRecipe

class AltarRecipeDisplay(recipe: AltarRecipe) : Display {
    val inputs: List<EntryIngredient>
    val outputs: List<EntryIngredient>
    val catalyst: EntryIngredient

    init {
        val inp = EntryIngredients.ofIngredients(recipe.ingredients)
        val out = EntryIngredients.of(recipe.output)
        catalyst = EntryIngredients.ofIngredient(recipe.catalyst)
        inputs = inp
        outputs = java.util.List.of(out)
    }

    override fun getInputEntries(): List<EntryIngredient> {
        return inputs
    }

    override fun getOutputEntries(): List<EntryIngredient> {
        return outputs
    }

    override fun getCategoryIdentifier(): CategoryIdentifier<*> {
        return id
    }

    companion object {
        val id = CategoryIdentifier.of<AltarRecipeDisplay>(Mod.id("altar"))
    }
}