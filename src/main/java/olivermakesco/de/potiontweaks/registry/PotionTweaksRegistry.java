package olivermakesco.de.potiontweaks.registry;

import org.quiltmc.qsl.item.group.api.QuiltItemGroup;

import static olivermakesco.de.potiontweaks.Mod.id;

public class PotionTweaksRegistry {
    public static QuiltItemGroup potionTweaksGroup = QuiltItemGroup.builder(id("items")).appendItems(Potions::appendStacks).icon(() -> Items.kyriteShard.getDefaultStack()).build();
    public static void register() {
        Potions.register();
        Blocks.register();
        Items.register();
    }
}
