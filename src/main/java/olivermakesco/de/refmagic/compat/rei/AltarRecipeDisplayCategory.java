package olivermakesco.de.refmagic.compat.rei;

import com.google.common.collect.Lists;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import olivermakesco.de.refmagic.registry.RefinedMagicBlocks;

import java.util.List;

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

    @Override
    public List<Widget> setupDisplay(AltarRecipeDisplay display, Rectangle bounds) {
        Point startPoint = new Point(bounds.getCenterX() - 58, bounds.getCenterY() - 27);
        List<Widget> widgets = Lists.newArrayList();
        widgets.add(Widgets.createRecipeBase(bounds));
        widgets.add(Widgets.createArrow(new Point(startPoint.x + 54, startPoint.y + 18)));
        widgets.add(Widgets.createResultSlotBackground(new Point(startPoint.x + 95, startPoint.y + 19)));
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                widgets.add(Widgets.createSlot(new Point(startPoint.x + 9 + j * 18, startPoint.y + 9 + i * 18)).entries(display.getInputEntries().get(i+j*2)).markInput());
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 54, startPoint.y+9)).entries(display.catalyst).markInput().disableBackground());
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 95, startPoint.y + 19)).entries(display.getOutputEntries().get(0)).disableBackground().markOutput());
        return widgets;
    }
}
