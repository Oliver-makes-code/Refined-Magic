package olivermakesco.de.refmagic.registry

import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.SignItem
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import olivermakesco.de.refmagic.Mod
import olivermakesco.de.refmagic.item.DimensionalTotemItem
import olivermakesco.de.refmagic.item.NecklaceItem
import olivermakesco.de.refmagic.item.WitheriteArmorItem
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings

object RefinedMagicItems {
    @JvmField
    var kyriteShard = Item(Item.Settings().group(RefinedMagicRegistry.items))
    @JvmField
    var kyritePowder = Item(Item.Settings().group(RefinedMagicRegistry.items))
    var kyriteOreEnd: Item =
        BlockItem(RefinedMagicBlocks.kyriteOreEnd, Item.Settings().group(RefinedMagicRegistry.items))
    var kyriteOreOverworld: Item =
        BlockItem(RefinedMagicBlocks.kyriteOreOverworld, Item.Settings().group(RefinedMagicRegistry.items))
    var kyriteOreNether: Item =
        BlockItem(RefinedMagicBlocks.kyriteOreNether, Item.Settings().group(RefinedMagicRegistry.items))
    var kyriteBlock: Item = BlockItem(RefinedMagicBlocks.kyriteBlock, Item.Settings().group(RefinedMagicRegistry.items))
    var topaz = Item(Item.Settings().group(RefinedMagicRegistry.items))
    var topazOre: Item = BlockItem(RefinedMagicBlocks.topazOre, Item.Settings().group(RefinedMagicRegistry.items))
    var topazBlock: Item = BlockItem(RefinedMagicBlocks.topazBlock, Item.Settings().group(RefinedMagicRegistry.items))
    var bismuth = Item(Item.Settings().group(RefinedMagicRegistry.items))
    var bismuthOreNether: Item =
        BlockItem(RefinedMagicBlocks.bismuthOreNether, Item.Settings().group(RefinedMagicRegistry.items))
    var bismuthOreOverworld: Item =
        BlockItem(RefinedMagicBlocks.bismuthOreOverworld, Item.Settings().group(RefinedMagicRegistry.items))
    var bismuthBlock: Item =
        BlockItem(RefinedMagicBlocks.bismuthBlock, Item.Settings().group(RefinedMagicRegistry.items))
    var citrine = Item(Item.Settings().group(RefinedMagicRegistry.items))
    var citrineOre: Item = BlockItem(RefinedMagicBlocks.citrineOre, Item.Settings().group(RefinedMagicRegistry.items))
    var citrineBlock: Item =
        BlockItem(RefinedMagicBlocks.citrineBlock, Item.Settings().group(RefinedMagicRegistry.items))
    var opal = Item(Item.Settings().group(RefinedMagicRegistry.items))
    var opalOre: Item = BlockItem(RefinedMagicBlocks.opalOre, Item.Settings().group(RefinedMagicRegistry.items))
    var opalBlock: Item = BlockItem(RefinedMagicBlocks.opalBlock, Item.Settings().group(RefinedMagicRegistry.items))
    var roseQuartz = Item(Item.Settings().group(RefinedMagicRegistry.items))
    var roseQuartzOre: Item =
        BlockItem(RefinedMagicBlocks.roseQuartzOre, Item.Settings().group(RefinedMagicRegistry.items))
    var roseQuartzBlock: Item =
        BlockItem(RefinedMagicBlocks.roseQuartzBlock, Item.Settings().group(RefinedMagicRegistry.items))
    var altarBlock: Item = BlockItem(RefinedMagicBlocks.altarBlock, Item.Settings().group(RefinedMagicRegistry.items))
    var dimensionalTotem: Item = DimensionalTotemItem(
        Item.Settings().group(RefinedMagicRegistry.items).maxCount(1)
    )
    var baseNecklace: Item = NecklaceItem(Item.Settings().maxCount(1))
    var enchantedStem: Item =
        BlockItem(RefinedMagicBlocks.enchantedStem, QuiltItemSettings().group(RefinedMagicRegistry.items))
    var strippedEnchantedStem: Item =
        BlockItem(RefinedMagicBlocks.strippedEnchantedStem, QuiltItemSettings().group(RefinedMagicRegistry.items))
    var enchantedHyphae: Item =
        BlockItem(RefinedMagicBlocks.enchantedHyphae, QuiltItemSettings().group(RefinedMagicRegistry.items))
    var strippedEnchantedHyphae: Item =
        BlockItem(RefinedMagicBlocks.strippedEnchantedHyphae, QuiltItemSettings().group(RefinedMagicRegistry.items))
    var enchantedPlanks: Item =
        BlockItem(RefinedMagicBlocks.enchantedPlanks, QuiltItemSettings().group(RefinedMagicRegistry.items))
    var enchantedSlab: Item =
        BlockItem(RefinedMagicBlocks.enchantedSlab, QuiltItemSettings().group(RefinedMagicRegistry.items))
    var enchantedStairs: Item =
        BlockItem(RefinedMagicBlocks.enchantedStairs, QuiltItemSettings().group(RefinedMagicRegistry.items))
    var enchantedButton: Item =
        BlockItem(RefinedMagicBlocks.enchantedButton, QuiltItemSettings().group(RefinedMagicRegistry.items))
    var enchantedPressurePlate: Item =
        BlockItem(RefinedMagicBlocks.enchantedPressurePlate, QuiltItemSettings().group(RefinedMagicRegistry.items))
    var enchantedTrapdoor: Item =
        BlockItem(RefinedMagicBlocks.enchantedTrapdoor, QuiltItemSettings().group(RefinedMagicRegistry.items))
    var enchantedDoor: Item =
        BlockItem(RefinedMagicBlocks.enchantedDoor, QuiltItemSettings().group(RefinedMagicRegistry.items))
    var enchantedFence: Item =
        BlockItem(RefinedMagicBlocks.enchantedFence, QuiltItemSettings().group(RefinedMagicRegistry.items))
    var enchantedFenceGate: Item =
        BlockItem(RefinedMagicBlocks.enchantedFenceGate, QuiltItemSettings().group(RefinedMagicRegistry.items))
    var enchantedSign: Item = SignItem(
        QuiltItemSettings().group(RefinedMagicRegistry.items),
        RefinedMagicBlocks.enchantedSign,
        RefinedMagicBlocks.enchantedWallSign
    )
    var enchantedWart: Item =
        BlockItem(RefinedMagicBlocks.enchantedWart, QuiltItemSettings().group(RefinedMagicRegistry.items))
    var enchantedShroomlight: Item =
        BlockItem(RefinedMagicBlocks.enchantedShroomlight, QuiltItemSettings().group(RefinedMagicRegistry.items))
    var enlium: Item = BlockItem(RefinedMagicBlocks.enlium, QuiltItemSettings().group(RefinedMagicRegistry.items))
    var enliumGrowth: Item =
        BlockItem(RefinedMagicBlocks.enliumGrowth, QuiltItemSettings().group(RefinedMagicRegistry.items))
    var enchantedFungus: Item =
        BlockItem(RefinedMagicBlocks.enchantedFungus, QuiltItemSettings().group(RefinedMagicRegistry.items))
    var hoopvine: Item = BlockItem(RefinedMagicBlocks.hoopvine, QuiltItemSettings().group(RefinedMagicRegistry.items))
    var witheredHeart = Item(QuiltItemSettings().group(RefinedMagicRegistry.items))
    var witheriteBlob = Item(QuiltItemSettings().group(RefinedMagicRegistry.items))
    var infestedNetherrackBlock: Item =
        BlockItem(RefinedMagicBlocks.infestedNetherrack, QuiltItemSettings().group(RefinedMagicRegistry.items))
    var witheriteHelmet: Item =
        WitheriteArmorItem(
            EquipmentSlot.HEAD,
            QuiltItemSettings().group(RefinedMagicRegistry.items)
        )
    var witheriteChestplate: Item =
        WitheriteArmorItem(
            EquipmentSlot.CHEST,
            QuiltItemSettings().group(RefinedMagicRegistry.items)
        )
    var witheriteLeggings: Item =
        WitheriteArmorItem(
            EquipmentSlot.LEGS,
            QuiltItemSettings().group(RefinedMagicRegistry.items)
        )
    var witheriteBoots: Item =
        WitheriteArmorItem(
            EquipmentSlot.FEET,
            QuiltItemSettings().group(RefinedMagicRegistry.items)
        )

    fun register() {
        register(kyriteShard, Mod.id("kyrite_shard"))
        register(topaz, Mod.id("topaz"))
        register(bismuth, Mod.id("bismuth"))
        register(citrine, Mod.id("citrine"))
        register(opal, Mod.id("opal"))
        register(roseQuartz, Mod.id("rose_quartz"))
        register(kyritePowder, Mod.id("kyrite_powder"))
        register(kyriteOreOverworld, Mod.id("kyrite_ore_overworld"))
        register(kyriteOreNether, Mod.id("kyrite_ore_nether"))
        register(kyriteOreEnd, Mod.id("kyrite_ore_end"))
        register(topazOre, Mod.id("topaz_ore"))
        register(bismuthOreOverworld, Mod.id("bismuth_ore_overworld"))
        register(bismuthOreNether, Mod.id("bismuth_ore_nether"))
        register(citrineOre, Mod.id("citrine_ore"))
        register(opalOre, Mod.id("opal_ore"))
        register(roseQuartzOre, Mod.id("rose_quartz_ore"))
        register(kyriteBlock, Mod.id("kyrite_block"))
        register(topazBlock, Mod.id("topaz_block"))
        register(bismuthBlock, Mod.id("bismuth_block"))
        register(citrineBlock, Mod.id("citrine_block"))
        register(opalBlock, Mod.id("opal_block"))
        register(roseQuartzBlock, Mod.id("rose_quartz_block"))
        register(altarBlock, Mod.id("altar"))
        register(dimensionalTotem, Mod.id("dimensional_totem"))
        register(witheredHeart, Mod.id("withered_heart"))
        register(witheriteBlob, Mod.id("witherite_blob"))
        register(infestedNetherrackBlock, Mod.id("infested_netherrack"))
        register(witheriteHelmet, Mod.id("witherite_helmet"))
        register(witheriteChestplate, Mod.id("witherite_chestplate"))
        register(witheriteLeggings, Mod.id("witherite_leggings"))
        register(witheriteBoots, Mod.id("witherite_boots"))
        register(baseNecklace, Mod.id("necklace"))
        register(enchantedStem, Mod.id("enchanted_stem"))
        register(strippedEnchantedStem, Mod.id("stripped_enchanted_stem"))
        register(enchantedHyphae, Mod.id("enchanted_hyphae"))
        register(strippedEnchantedHyphae, Mod.id("stripped_enchanted_hyphae"))
        register(enchantedPlanks, Mod.id("enchanted_planks"))
        register(enchantedSlab, Mod.id("enchanted_slab"))
        register(enchantedStairs, Mod.id("enchanted_stairs"))
        register(enchantedButton, Mod.id("enchanted_button"))
        register(enchantedPressurePlate, Mod.id("enchanted_pressure_plate"))
        register(enchantedTrapdoor, Mod.id("enchanted_trapdoor"))
        register(enchantedDoor, Mod.id("enchanted_door"))
        register(enchantedFence, Mod.id("enchanted_fence"))
        register(enchantedFenceGate, Mod.id("enchanted_fence_gate"))
        register(enchantedSign, Mod.id("enchanted_sign"))
        register(enchantedShroomlight, Mod.id("enchanted_shroomlight"))
        register(enchantedWart, Mod.id("enchanted_wart"))
        register(enlium, Mod.id("enlium"))
        register(enliumGrowth, Mod.id("enlium_growth"))
        register(enchantedFungus, Mod.id("enchanted_fungus"))
        register(hoopvine, Mod.id("hoopvine"))
    }

    fun register(item: Item, id: Identifier?) {
        Registry.register(Registry.ITEM, id, item)
    }
}