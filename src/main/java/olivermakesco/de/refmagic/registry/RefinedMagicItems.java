package olivermakesco.de.refmagic.registry;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import olivermakesco.de.refmagic.item.*;
import olivermakesco.de.refmagic.Mod;

public class RefinedMagicItems {
    public static Item kyriteShard = new KyriteShardItem(new Item.Settings().group(RefinedMagicRegistry.potionTweaksGroup));
    public static Item kyritePowder = new KyritePowderItem(new Item.Settings().group(RefinedMagicRegistry.potionTweaksGroup));
    public static Item kyriteOre = new BlockItem(RefinedMagicBlocks.kyriteOre, new Item.Settings().group(RefinedMagicRegistry.potionTweaksGroup));
    public static Item kyriteBlock = new BlockItem(RefinedMagicBlocks.kyriteBlock, new Item.Settings().group(RefinedMagicRegistry.potionTweaksGroup));
    public static Item topaz = new TopazItem(new Item.Settings().group(RefinedMagicRegistry.potionTweaksGroup));
    public static Item topazOre = new BlockItem(RefinedMagicBlocks.topazOre, new Item.Settings().group(RefinedMagicRegistry.potionTweaksGroup));
    public static Item topazBlock = new BlockItem(RefinedMagicBlocks.topazBlock, new Item.Settings().group(RefinedMagicRegistry.potionTweaksGroup));
    public static Item bismuth = new BismuthItem(new Item.Settings().group(RefinedMagicRegistry.potionTweaksGroup));
    public static Item bismuthOre = new BlockItem(RefinedMagicBlocks.bismuthOre, new Item.Settings().group(RefinedMagicRegistry.potionTweaksGroup));
    public static Item citrine = new CitrineItem(new Item.Settings().group(RefinedMagicRegistry.potionTweaksGroup));
    public static Item citrineOre = new BlockItem(RefinedMagicBlocks.citrineOre, new Item.Settings().group(RefinedMagicRegistry.potionTweaksGroup));
    public static Item citrineBlock = new BlockItem(RefinedMagicBlocks.citrineBlock, new Item.Settings().group(RefinedMagicRegistry.potionTweaksGroup));
    public static Item opal = new OpalItem(new Item.Settings().group(RefinedMagicRegistry.potionTweaksGroup));
    public static Item opalOre = new BlockItem(RefinedMagicBlocks.opalOre, new Item.Settings().group(RefinedMagicRegistry.potionTweaksGroup));
    public static Item opalBlock = new BlockItem(RefinedMagicBlocks.opalBlock, new Item.Settings().group(RefinedMagicRegistry.potionTweaksGroup));
    public static Item roseQuartz = new RoseQuartzItem(new Item.Settings().group(RefinedMagicRegistry.potionTweaksGroup));
    public static Item roseQuartzOre = new BlockItem(RefinedMagicBlocks.roseQuartzOre, new Item.Settings().group(RefinedMagicRegistry.potionTweaksGroup));
    public static Item roseQuartzBlock = new BlockItem(RefinedMagicBlocks.roseQuartzBlock, new Item.Settings().group(RefinedMagicRegistry.potionTweaksGroup));

    public static Item dimensionalTotem = new DimensionalTotemItem(new Item.Settings().group(RefinedMagicRegistry.potionTweaksGroup).maxCount(1));

    public static void register() {
        register(kyriteShard, Mod.id("kyrite_shard"));
        register(kyritePowder, Mod.id("kyrite_powder"));
        register(kyriteOre, Mod.id("kyrite_ore"));
        register(kyriteBlock, Mod.id("kyrite_block"));
        register(topaz, Mod.id("topaz"));
        register(topazOre, Mod.id("topaz_ore"));
        register(topazBlock, Mod.id("topaz_block"));
        register(bismuth, Mod.id("bismuth"));
        register(bismuthOre, Mod.id("bismuth_ore"));
        register(citrine, Mod.id("citrine"));
        register(citrineOre, Mod.id("citrine_ore"));
        register(citrineBlock, Mod.id("citrine_block"));
        register(opal, Mod.id("opal"));
        register(opalOre, Mod.id("opal_ore"));
        register(opalBlock, Mod.id("opal_block"));
        register(roseQuartz, Mod.id("rose_quartz"));
        register(roseQuartzOre, Mod.id("rose_quartz_ore"));
        register(roseQuartzBlock, Mod.id("rose_quartz_block"));

        register(dimensionalTotem, Mod.id("dimensional_totem"));
    }

    public static void register(Item item, Identifier id) {
        Registry.register(Registry.ITEM,id,item);
    }
}
