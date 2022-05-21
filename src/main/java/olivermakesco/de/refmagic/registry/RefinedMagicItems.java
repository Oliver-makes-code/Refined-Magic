package olivermakesco.de.refmagic.registry;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import olivermakesco.de.refmagic.item.*;
import olivermakesco.de.refmagic.Mod;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import java.sql.Ref;

public class RefinedMagicItems {
    public static Item kyriteShard = new Item(new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item kyritePowder = new Item(new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item kyriteOreEnd = new BlockItem(RefinedMagicBlocks.kyriteOreEnd, new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item kyriteOreOverworld = new BlockItem(RefinedMagicBlocks.kyriteOreOverworld, new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item kyriteOreNether = new BlockItem(RefinedMagicBlocks.kyriteOreNether, new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item kyriteBlock = new BlockItem(RefinedMagicBlocks.kyriteBlock, new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item topaz = new Item(new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item topazOre = new BlockItem(RefinedMagicBlocks.topazOre, new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item topazBlock = new BlockItem(RefinedMagicBlocks.topazBlock, new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item bismuth = new Item(new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item bismuthOreNether = new BlockItem(RefinedMagicBlocks.bismuthOreNether, new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item bismuthOreOverworld = new BlockItem(RefinedMagicBlocks.bismuthOreOverworld, new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item bismuthBlock = new BlockItem(RefinedMagicBlocks.bismuthBlock, new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item citrine = new Item(new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item citrineOre = new BlockItem(RefinedMagicBlocks.citrineOre, new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item citrineBlock = new BlockItem(RefinedMagicBlocks.citrineBlock, new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item opal = new Item(new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item opalOre = new BlockItem(RefinedMagicBlocks.opalOre, new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item opalBlock = new BlockItem(RefinedMagicBlocks.opalBlock, new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item roseQuartz = new Item(new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item roseQuartzOre = new BlockItem(RefinedMagicBlocks.roseQuartzOre, new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item roseQuartzBlock = new BlockItem(RefinedMagicBlocks.roseQuartzBlock, new Item.Settings().group(RefinedMagicRegistry.group));
    public static Item altarBlock = new BlockItem(RefinedMagicBlocks.altarBlock, new Item.Settings().group(RefinedMagicRegistry.group));

    public static Item dimensionalTotem = new DimensionalTotemItem(new Item.Settings().group(RefinedMagicRegistry.group).maxCount(1));
    public static Item baseNecklace = new NecklaceItem(new Item.Settings().maxCount(1));

    public static Item enchantedStem = new BlockItem(RefinedMagicBlocks.enchantedStem, new QuiltItemSettings().group(RefinedMagicRegistry.group));
    public static Item strippedEnchantedStem = new BlockItem(RefinedMagicBlocks.strippedEnchantedStem, new QuiltItemSettings().group(RefinedMagicRegistry.group));
    public static Item enchantedHyphae = new BlockItem(RefinedMagicBlocks.enchantedHyphae, new QuiltItemSettings().group(RefinedMagicRegistry.group));
    public static Item strippedEnchantedHyphae = new BlockItem(RefinedMagicBlocks.strippedEnchantedHyphae, new QuiltItemSettings().group(RefinedMagicRegistry.group));
    public static Item enchantedPlanks = new BlockItem(RefinedMagicBlocks.enchantedPlanks, new QuiltItemSettings().group(RefinedMagicRegistry.group));
    public static Item enchantedSlab = new BlockItem(RefinedMagicBlocks.enchantedSlab, new QuiltItemSettings().group(RefinedMagicRegistry.group));
    public static Item enchantedStairs = new BlockItem(RefinedMagicBlocks.enchantedStairs, new QuiltItemSettings().group(RefinedMagicRegistry.group));
    public static Item enchantedButton = new BlockItem(RefinedMagicBlocks.enchantedButton, new QuiltItemSettings().group(RefinedMagicRegistry.group));
    public static Item enchantedPressurePlate = new BlockItem(RefinedMagicBlocks.enchantedPressurePlate, new QuiltItemSettings().group(RefinedMagicRegistry.group));
    public static Item enchantedTrapdoor = new BlockItem(RefinedMagicBlocks.enchantedTrapdoor, new QuiltItemSettings().group(RefinedMagicRegistry.group));
    public static Item enchantedDoor = new BlockItem(RefinedMagicBlocks.enchantedDoor, new QuiltItemSettings().group(RefinedMagicRegistry.group));
    public static Item enchantedFence = new BlockItem(RefinedMagicBlocks.enchantedFence, new QuiltItemSettings().group(RefinedMagicRegistry.group));
    public static Item enchantedFenceGate = new BlockItem(RefinedMagicBlocks.enchantedFenceGate, new QuiltItemSettings().group(RefinedMagicRegistry.group));
    public static Item enchantedSign = new SignItem(new QuiltItemSettings().group(RefinedMagicRegistry.group), RefinedMagicBlocks.enchantedSign, RefinedMagicBlocks.enchantedWallSign);

    public static Item enchantedWart = new BlockItem(RefinedMagicBlocks.enchantedWart, new QuiltItemSettings().group(RefinedMagicRegistry.group));

    public static Item enchantedShroomlight = new BlockItem(RefinedMagicBlocks.enchantedShroomlight, new QuiltItemSettings().group(RefinedMagicRegistry.group));

    public static Item enlium = new BlockItem(RefinedMagicBlocks.enlium, new QuiltItemSettings().group(RefinedMagicRegistry.group));
    public static Item enliumGrowth = new BlockItem(RefinedMagicBlocks.enliumGrowth, new QuiltItemSettings().group(RefinedMagicRegistry.group));
    public static Item enchantedFungus = new BlockItem(RefinedMagicBlocks.enchantedFungus, new QuiltItemSettings().group(RefinedMagicRegistry.group));
    public static Item hoopvine = new BlockItem(RefinedMagicBlocks.hoopvine, new QuiltItemSettings().group(RefinedMagicRegistry.group));

    public static Item powerableCopper = new BlockItem(RefinedMagicBlocks.powerableCopper, new QuiltItemSettings().group(RefinedMagicRegistry.group));

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
        register(strippedEnchantedStem, Mod.id("stripped_enchanted_stem"));
        register(enchantedHyphae, Mod.id("enchanted_hyphae"));
        register(strippedEnchantedHyphae, Mod.id("stripped_enchanted_hyphae"));
        register(enchantedPlanks, Mod.id("enchanted_planks"));
        register(enchantedSlab, Mod.id("enchanted_slab"));
        register(enchantedStairs, Mod.id("enchanted_stairs"));
        register(enchantedButton, Mod.id("enchanted_button"));
        register(enchantedPressurePlate, Mod.id("enchanted_pressure_plate"));
        register(enchantedTrapdoor, Mod.id("enchanted_trapdoor"));
        register(enchantedDoor, Mod.id("enchanted_door"));
        register(enchantedFence, Mod.id("enchanted_fence"));
        register(enchantedFenceGate, Mod.id("enchanted_fence_gate"));
        register(enchantedSign, Mod.id("enchanted_sign"));

        register(enchantedShroomlight, Mod.id("enchanted_shroomlight"));

        register(enchantedWart, Mod.id("enchanted_wart"));

        register(enlium, Mod.id("enlium"));
        register(enliumGrowth, Mod.id("enlium_growth"));
        register(enchantedFungus, Mod.id("enchanted_fungus"));
        register(hoopvine, Mod.id("hoopvine"));

        register(powerableCopper, Mod.id("powerable_copper"));
    }

    public static void register(Item item, Identifier id) {
        Registry.register(Registry.ITEM,id,item);
    }
}
