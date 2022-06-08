package olivermakesco.de.refmagic.compat.rei

import com.google.common.collect.Lists
import me.shedaniel.math.Point
import me.shedaniel.math.Rectangle
import me.shedaniel.rei.api.client.gui.Renderer
import me.shedaniel.rei.api.client.gui.widgets.Widget
import me.shedaniel.rei.api.client.gui.widgets.Widgets
import me.shedaniel.rei.api.client.registry.display.DisplayCategory
import me.shedaniel.rei.api.common.category.CategoryIdentifier
import me.shedaniel.rei.api.common.util.EntryStacks
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText
import olivermakesco.de.refmagic.registry.RefinedMagicBlocks

class AltarRecipeDisplayCategory : DisplayCategory<AltarRecipeDisplay> {
    override fun getIcon(): Renderer {
        return Companion.icon
    }

    override fun getTitle(): Text {
        return Companion.title
    }

    override fun getCategoryIdentifier(): CategoryIdentifier<out AltarRecipeDisplay> {
        return AltarRecipeDisplay.id
    }

    override fun setupDisplay(display: AltarRecipeDisplay, bounds: Rectangle): List<Widget> {
        val startPoint = Point(bounds.centerX - 58, bounds.centerY - 27)
        val widgets: MutableList<Widget> = Lists.newArrayList()
        widgets.add(Widgets.createRecipeBase(bounds))
        widgets.add(Widgets.createArrow(Point(startPoint.x + 54, startPoint.y + 18)))
        widgets.add(Widgets.createResultSlotBackground(Point(startPoint.x + 95, startPoint.y + 19)))
        for (i in 0..1) for (j in 0..1) widgets.add(
            Widgets.createSlot(Point(startPoint.x + 9 + j * 18, startPoint.y + 9 + i * 18)).entries(
                display.inputEntries[i + j * 2]
            ).markInput()
        )
        widgets.add(
            Widgets.createSlot(Point(startPoint.x + 54, startPoint.y + 9)).entries(display.catalyst).markInput()
                .disableBackground()
        )
        widgets.add(
            Widgets.createSlot(Point(startPoint.x + 95, startPoint.y + 19)).entries(display.outputEntries[0])
                .disableBackground().markOutput()
        )
        return widgets
    }

    companion object {
        val icon: Renderer = EntryStacks.of(RefinedMagicBlocks.altarBlock)
        val title: Text = TranslatableText("refmagic.rei.altar")
    }
}