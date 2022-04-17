package olivermakesco.de.potiontweaks.registry;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import olivermakesco.de.potiontweaks.item.KyriteShardItem;
import olivermakesco.de.potiontweaks.Mod;
import olivermakesco.de.potiontweaks.item.TopazItem;
import org.lwjgl.system.CallbackI;

public class Items {
    public static Item kyriteShard = new KyriteShardItem(new Item.Settings().group(PotionTweaksRegistry.potionTweaksGroup));
    public static Item kyriteOre = new BlockItem(Blocks.kyriteOre, new Item.Settings().group(PotionTweaksRegistry.potionTweaksGroup));
    public static Item topaz = new TopazItem(new Item.Settings().group(PotionTweaksRegistry.potionTweaksGroup));
    public static Item topazOre = new BlockItem(Blocks.topazOre, new Item.Settings().group(PotionTweaksRegistry.potionTweaksGroup));

    public static void register() {
        register(kyriteShard, Mod.id("kyrite_shard"));
        register(kyriteOre, Mod.id("kyrite_ore"));
        register(topaz, Mod.id("topaz"));
        register(topazOre, Mod.id("topaz_ore"));
    }

    public static void register(Item item, Identifier id) {
        Registry.register(Registry.ITEM,id,item);
    }
}
