package olivermakesco.de.refmagic.compat.rei;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.minecraft.util.Identifier;
import olivermakesco.de.refmagic.Mod;
import olivermakesco.de.refmagic.recipe.AltarRecipe;

import java.util.Collections;
import java.util.List;

public class AltarRecipeDisplay implements Display {
    public static final CategoryIdentifier<AltarRecipeDisplay> id = CategoryIdentifier.of(Mod.id("altar"));

    public final List<EntryIngredient> inputs;
    public final List<EntryIngredient> outputs;

    public AltarRecipeDisplay(AltarRecipe recipe) {
        var inp = EntryIngredients.ofIngredients(recipe.getIngredients());
        inp.add(EntryIngredients.ofIngredient(recipe.catalyst()));
        var out = EntryIngredients.of(recipe.getOutput());
        inputs = inp;
        outputs = List.of(out);
    }

    @Override
    public List<EntryIngredient> getInputEntries() {
        return inputs;
    }

    @Override
    public List<EntryIngredient> getOutputEntries() {
        return outputs;
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return id;
    }
}
