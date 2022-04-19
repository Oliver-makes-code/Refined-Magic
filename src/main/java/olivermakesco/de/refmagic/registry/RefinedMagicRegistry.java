package olivermakesco.de.refmagic.registry;

import org.quiltmc.qsl.item.group.api.QuiltItemGroup;

import static olivermakesco.de.refmagic.Mod.id;

public class RefinedMagicRegistry {
    public static QuiltItemGroup potionTweaksGroup = QuiltItemGroup.builder(id("items")).appendItems(RefinedMagicPotions::appendStacks).icon(() -> RefinedMagicItems.kyriteShard.getDefaultStack()).build();
    public static void register() {
        RefinedMagicPotions.register();
        RefinedMagicBlocks.register();
        RefinedMagicItems.register();
        RefinedMagicWorldgen.register();
    }
}
