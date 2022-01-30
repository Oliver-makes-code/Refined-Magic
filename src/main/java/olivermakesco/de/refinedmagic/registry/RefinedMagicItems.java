package olivermakesco.de.refinedmagic.registry;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import olivermakesco.de.refinedmagic.item.KyriteShardItem;
import olivermakesco.de.refinedmagic.Mod;

public class RefinedMagicItems {
    static Item kyriteShard = new KyriteShardItem(new Item.Settings().group(ItemGroup.MATERIALS));
    static Item kyriteOre = new BlockItem(RefinedMagicBlocks.kyriteOre, new Item.Settings().group(ItemGroup.MATERIALS));
    static Item evaporationTable = new BlockItem(RefinedMagicBlocks.evaporationTable, new Item.Settings().group(ItemGroup.BREWING));
    public static void register() {
        register(kyriteShard, Mod.id("kyrite_shard"));
        register(kyriteOre, Mod.id("kyrite_ore"));
        register(evaporationTable, Mod.id("evaporation_table"));
    }

    public static void register(Item item, Identifier id) {
        Registry.register(Registry.ITEM,id,item);
    }
}
