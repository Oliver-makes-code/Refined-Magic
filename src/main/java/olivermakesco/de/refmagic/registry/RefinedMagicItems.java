package olivermakesco.de.refmagic.registry;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import olivermakesco.de.refmagic.item.*;
import olivermakesco.de.refmagic.Mod;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import java.sql.Ref;

public class RefinedMagicItems {
    public static Item kyriteShard = new KyriteShardItem(new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item kyritePowder = new KyritePowderItem(new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item kyriteOreEnd = new BlockItem(RefinedMagicBlocks.kyriteOreEnd, new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item kyriteOreOverworld = new BlockItem(RefinedMagicBlocks.kyriteOreOverworld, new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item kyriteOreNether = new BlockItem(RefinedMagicBlocks.kyriteOreNether, new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item kyriteBlock = new BlockItem(RefinedMagicBlocks.kyriteBlock, new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item topaz = new TopazItem(new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item topazOre = new BlockItem(RefinedMagicBlocks.topazOre, new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item topazBlock = new BlockItem(RefinedMagicBlocks.topazBlock, new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item bismuth = new BismuthItem(new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item bismuthOreNether = new BlockItem(RefinedMagicBlocks.bismuthOreNether, new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item bismuthOreOverworld = new BlockItem(RefinedMagicBlocks.bismuthOreOverworld, new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item bismuthBlock = new BlockItem(RefinedMagicBlocks.bismuthBlock, new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item citrine = new CitrineItem(new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item citrineOre = new BlockItem(RefinedMagicBlocks.citrineOre, new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item citrineBlock = new BlockItem(RefinedMagicBlocks.citrineBlock, new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item opal = new OpalItem(new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item opalOre = new BlockItem(RefinedMagicBlocks.opalOre, new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item opalBlock = new BlockItem(RefinedMagicBlocks.opalBlock, new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item roseQuartz = new RoseQuartzItem(new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item roseQuartzOre = new BlockItem(RefinedMagicBlocks.roseQuartzOre, new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item roseQuartzBlock = new BlockItem(RefinedMagicBlocks.roseQuartzBlock, new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item altarBlock = new BlockItem(RefinedMagicBlocks.altarBlock, new Item.Settings().group(RefinedMagicRegistry.group));

    public static Item dimensionalTotem = new DimensionalTotemItem(new Item.Settings().group(RefinedMagicRegistry.group).maxCount(1));
    public static Item baseNecklace = new NecklaceItem(new Item.Settings().maxCount(1));

    public static Item enchantedStem = new BlockItem(RefinedMagicBlocks.enchantedStem, new QuiltItemSettings().group(RefinedMagicRegistry.group));

    public static Item enchantedWart = new BlockItem(RefinedMagicBlocks.enchantedWart, new QuiltItemSettings().group(RefinedMagicRegistry.group));

    public static Item enchantedShroomlight = new BlockItem(RefinedMagicBlocks.enchantedShroomlight, new QuiltItemSettings().group(RefinedMagicRegistry.group));

    public static void register() {
        register(kyriteShard, Mod.id("kyrite_shard"));
        register(kyritePowder, Mod.id("kyrite_powder"));
        register(kyriteOreOverworld, Mod.id("kyrite_ore_overworld"));
        register(kyriteOreNether, Mod.id("kyrite_ore_nether"));
        register(kyriteOreEnd, Mod.id("kyrite_ore_end"));
        register(kyriteBlock, Mod.id("kyrite_block"));
        register(topaz, Mod.id("topaz"));
        register(topazOre, Mod.id("topaz_ore"));
        register(topazBlock, Mod.id("topaz_block"));
        register(bismuth, Mod.id("bismuth"));
        register(bismuthOreOverworld, Mod.id("bismuth_ore_overworld"));
        register(bismuthOreNether, Mod.id("bismuth_ore_nether"));
        register(bismuthBlock, Mod.id("bismuth_block"));
        register(citrine, Mod.id("citrine"));
        register(citrineOre, Mod.id("citrine_ore"));
        register(citrineBlock, Mod.id("citrine_block"));
        register(opal, Mod.id("opal"));
        register(opalOre, Mod.id("opal_ore"));
        register(opalBlock, Mod.id("opal_block"));
        register(roseQuartz, Mod.id("rose_quartz"));
        register(roseQuartzOre, Mod.id("rose_quartz_ore"));
        register(roseQuartzBlock, Mod.id("rose_quartz_block"));
        register(altarBlock, Mod.id("altar"));

        register(dimensionalTotem, Mod.id("dimensional_totem"));
        register(baseNecklace, Mod.id("necklace"));

        register(enchantedStem, Mod.id("enchanted_stem"));

        register(enchantedShroomlight, Mod.id("enchanted_shroomlight"));

        register(enchantedWart, Mod.id("enchanted_wart"));
    }

    public static void register(Item item, Identifier id) {
        Registry.register(Registry.ITEM,id,item);
    }
}
