package olivermakesco.de.refmagic.registry;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import olivermakesco.de.refmagic.item.*;
import olivermakesco.de.refmagic.Mod;

public class RefinedMagicItems {
    public static Item kyriteShard = new KyriteShardItem(new Item.Settings().group(RefinedMagicRegistry.potionTweaksGroup));
    public static Item kyriteOre = new BlockItem(RefinedMagicBlocks.kyriteOre, new Item.Settings().group(RefinedMagicRegistry.potionTweaksGroup));
    public static Item topaz = new TopazItem(new Item.Settings().group(RefinedMagicRegistry.potionTweaksGroup));
    public static Item topazOre = new BlockItem(RefinedMagicBlocks.topazOre, new Item.Settings().group(RefinedMagicRegistry.potionTweaksGroup));
    public static Item bismuth = new BismuthItem(new Item.Settings().group(RefinedMagicRegistry.potionTweaksGroup));
    public static Item bismuthOre = new BlockItem(RefinedMagicBlocks.bismuthOre, new Item.Settings().group(RefinedMagicRegistry.potionTweaksGroup));
    public static Item citrine = new CitrineItem(new Item.Settings().group(RefinedMagicRegistry.potionTweaksGroup));
    public static Item citrineOre = new BlockItem(RefinedMagicBlocks.citrineOre, new Item.Settings().group(RefinedMagicRegistry.potionTweaksGroup));

    public static Item dimensionalTotem = new DimensionalTotemItem(new Item.Settings().group(RefinedMagicRegistry.potionTweaksGroup));

    public static void register() {
        register(kyriteShard, Mod.id("kyrite_shard"));
        register(kyriteOre, Mod.id("kyrite_ore"));
        register(topaz, Mod.id("topaz"));
        register(topazOre, Mod.id("topaz_ore"));
        register(bismuth, Mod.id("bismuth"));
        register(bismuthOre, Mod.id("bismuth_ore"));
        register(citrine, Mod.id("citrine"));
        register(citrineOre, Mod.id("citrine_ore"));

        register(dimensionalTotem, Mod.id("dimensional_totem"));
    }

    public static void register(Item item, Identifier id) {
        Registry.register(Registry.ITEM,id,item);
    }
}
