package olivermakesco.de.refmagic.compat.rei;

import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import olivermakesco.de.refmagic.registry.RefinedMagicBlocks;

public class AltarRecipeDisplayCategory implements DisplayCategory<AltarRecipeDisplay> {
    public static final Renderer icon = EntryStacks.of(RefinedMagicBlocks.altarBlock);
    public static final Text title = new TranslatableText("refmagic.rei.altar");

    @Override
    public Renderer getIcon() {
        return icon;
    }

    @Override
    public Text getTitle() {
        return title;
    }

    @Override
    public CategoryIdentifier<? extends AltarRecipeDisplay> getCategoryIdentifier() {
        return AltarRecipeDisplay.id;
    }
}
