package olivermakesco.de.refmagic.registry

import olivermakesco.de.refmagic.Mod
import org.quiltmc.qsl.item.group.api.QuiltItemGroup

object RefinedMagicRegistry {
    var items: QuiltItemGroup = QuiltItemGroup.builder(Mod.id("items"))
        .appendItems(RefinedMagicPotions::appendStacks)
        .icon { RefinedMagicItems.kyriteShard.defaultStack }
        .build()

    fun register() {
        RefinedMagicPotions.register()
        RefinedMagicBlocks.register()
        RefinedMagicBlockEntities.register()
        RefinedMagicItems.register()
        RefinedMagicWorldgen.register()
        RefinedMagicRecipes.register()
    }
}