package olivermakesco.de.refmagic.registry

import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.SignItem
import net.minecraft.util.registry.Registry
import olivermakesco.de.refmagic.Mod
import olivermakesco.de.refmagic.item.DimensionalTotemItem
import olivermakesco.de.refmagic.item.NecklaceItem
import olivermakesco.de.refmagic.item.WitheriteArmorItem
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings
import org.quiltmc.qkl.wrapper.minecraft.registry.*

object RefinedMagicItems {
    val baseItemSettings = QuiltItemSettings().group(RefinedMagicRegistry.items)

    @JvmField
    var kyriteShard = Item(baseItemSettings)
    @JvmField
    var kyritePowder = Item(baseItemSettings)
    var kyriteOreEnd: Item = BlockItem(
        RefinedMagicBlocks.kyriteOreEnd,
        baseItemSettings
    )
    var kyriteOreOverworld: Item = BlockItem(
        RefinedMagicBlocks.kyriteOreOverworld,
        baseItemSettings
    )
    var kyriteOreNether: Item = BlockItem(
        RefinedMagicBlocks.kyriteOreNether,
        baseItemSettings
    )
    var kyriteBlock: Item = BlockItem(
        RefinedMagicBlocks.kyriteBlock,
        baseItemSettings
    )
    var topaz = Item(
        baseItemSettings
    )
    var topazOre: Item = BlockItem(
        RefinedMagicBlocks.topazOre,
        baseItemSettings
    )
    var topazBlock: Item = BlockItem(
        RefinedMagicBlocks.topazBlock,
        baseItemSettings
    )
    var bismuth = Item(
        baseItemSettings
    )
    var bismuthOreNether: Item = BlockItem(
        RefinedMagicBlocks.bismuthOreNether,
        baseItemSettings
    )
    var bismuthOreOverworld: Item = BlockItem(
        RefinedMagicBlocks.bismuthOreOverworld,
        baseItemSettings
    )
    var bismuthBlock: Item = BlockItem(
        RefinedMagicBlocks.bismuthBlock,
        baseItemSettings
    )
    var citrine = Item(
        baseItemSettings
    )
    var citrineOre: Item = BlockItem(
        RefinedMagicBlocks.citrineOre,
        baseItemSettings
    )
    var citrineBlock: Item = BlockItem(
        RefinedMagicBlocks.citrineBlock,
        baseItemSettings
    )
    var opal = Item(
        baseItemSettings
    )
    var opalOre: Item = BlockItem(
        RefinedMagicBlocks.opalOre,
        baseItemSettings
    )
    var opalBlock: Item = BlockItem(
        RefinedMagicBlocks.opalBlock,
        baseItemSettings
    )
    var roseQuartz = Item(
        baseItemSettings
    )
    var roseQuartzOre: Item = BlockItem(
        RefinedMagicBlocks.roseQuartzOre,
        baseItemSettings
    )
    var roseQuartzBlock: Item = BlockItem(
        RefinedMagicBlocks.roseQuartzBlock,
        baseItemSettings
    )
    var altarBlock: Item = BlockItem(
        RefinedMagicBlocks.altarBlock,
        baseItemSettings
    )
    var dimensionalTotem: Item = DimensionalTotemItem(
        QuiltItemSettings()
            .group(RefinedMagicRegistry.items)
            .maxCount(1)
    )
    var baseNecklace: Item = NecklaceItem(
        QuiltItemSettings()
            .maxCount(1)
    )
    var enchantedStem: Item = BlockItem(
        RefinedMagicBlocks.enchantedStem,
        baseItemSettings
    )
    var strippedEnchantedStem: Item = BlockItem(
        RefinedMagicBlocks.strippedEnchantedStem,
        baseItemSettings
    )
    var enchantedHyphae: Item = BlockItem(
        RefinedMagicBlocks.enchantedHyphae,
        baseItemSettings
    )
    var strippedEnchantedHyphae: Item = BlockItem(
        RefinedMagicBlocks.strippedEnchantedHyphae,
        baseItemSettings
    )
    var enchantedPlanks: Item = BlockItem(
        RefinedMagicBlocks.enchantedPlanks,
        baseItemSettings
    )
    var enchantedSlab: Item = BlockItem(
        RefinedMagicBlocks.enchantedSlab,
        baseItemSettings
    )
    var enchantedStairs: Item = BlockItem(
        RefinedMagicBlocks.enchantedStairs,
        baseItemSettings
    )
    var enchantedButton: Item = BlockItem(
        RefinedMagicBlocks.enchantedButton,
        baseItemSettings
    )
    var enchantedPressurePlate: Item = BlockItem(
        RefinedMagicBlocks.enchantedPressurePlate,
        baseItemSettings
    )
    var enchantedTrapdoor: Item = BlockItem(
        RefinedMagicBlocks.enchantedTrapdoor,
        baseItemSettings
    )
    var enchantedDoor: Item = BlockItem(
        RefinedMagicBlocks.enchantedDoor,
        baseItemSettings
    )
    var enchantedFence: Item = BlockItem(
        RefinedMagicBlocks.enchantedFence,
        baseItemSettings
    )
    var enchantedFenceGate: Item = BlockItem(
        RefinedMagicBlocks.enchantedFenceGate,
        baseItemSettings
    )
    var enchantedSign: Item = SignItem(
        baseItemSettings,
        RefinedMagicBlocks.enchantedSign,
        RefinedMagicBlocks.enchantedWallSign
    )
    var enchantedWart: Item = BlockItem(RefinedMagicBlocks.enchantedWart,
        baseItemSettings
    )
    var enchantedShroomlight: Item = BlockItem(
        RefinedMagicBlocks.enchantedShroomlight,
        baseItemSettings
    )
    var enlium: Item = BlockItem(
        RefinedMagicBlocks.enlium,
        baseItemSettings
    )
    var enliumGrowth: Item = BlockItem(
        RefinedMagicBlocks.enliumGrowth,
        baseItemSettings
    )
    var enchantedFungus: Item = BlockItem(
        RefinedMagicBlocks.enchantedFungus,
        baseItemSettings
    )
    var hoopvine: Item = BlockItem(
        RefinedMagicBlocks.hoopvine,
        baseItemSettings
    )
    var witheredHeart = Item(
        QuiltItemSettings().
        group(RefinedMagicRegistry.items)
    )
    var witheriteBlob = Item(
        baseItemSettings
    )
    var infestedNetherrackBlock: Item = BlockItem(
        RefinedMagicBlocks.infestedNetherrack,
        baseItemSettings
    )
    var witheriteHelmet: Item = WitheriteArmorItem(
            EquipmentSlot.HEAD,
            baseItemSettings
        )
    var witheriteChestplate: Item = WitheriteArmorItem(
        EquipmentSlot.CHEST,
        baseItemSettings
    )
    var witheriteLeggings: Item = WitheriteArmorItem(
        EquipmentSlot.LEGS,
        baseItemSettings
    )
    var witheriteBoots: Item = WitheriteArmorItem(
        EquipmentSlot.FEET,
        baseItemSettings
    )
    fun register() {
        Registry.ITEM(Mod.modid) {
            kyriteShard             withName "kyrite_shard"
            topaz                   withName "topaz"
            bismuth                 withName "bismuth"
            citrine                 withName "citrine"
            opal                    withName "opal"
            roseQuartz              withName "rose_quartz"
            kyritePowder            withName "kyrite_powder"
            kyriteOreOverworld      withName "kyrite_ore_overworld"
            kyriteOreNether         withName "kyrite_ore_nether"
            kyriteOreEnd            withName "kyrite_ore_end"
            topazOre                withName "topaz_ore"
            bismuthOreOverworld     withName "bismuth_ore_overworld"
            bismuthOreNether        withName "bismuth_ore_nether"
            citrineOre              withName "citrine_ore"
            opalOre                 withName "opal_ore"
            roseQuartzOre           withName "rose_quartz_ore"
            kyriteBlock             withName "kyrite_block"
            topazBlock              withName "topaz_block"
            bismuthBlock            withName "bismuth_block"
            citrineBlock            withName "citrine_block"
            opalBlock               withName "opal_block"
            roseQuartzBlock         withName "rose_quartz_block"
            altarBlock              withName "altar"
            dimensionalTotem        withName "dimensional_totem"
            witheredHeart           withName "withered_heart"
            witheriteBlob           withName "witherite_blob"
            infestedNetherrackBlock withName "infested_netherrack"
            witheriteHelmet         withName "witherite_helmet"
            witheriteChestplate     withName "witherite_chestplate"
            witheriteLeggings       withName "witherite_leggings"
            witheriteBoots          withName "witherite_boots"
            baseNecklace            withName "necklace"
            enchantedStem           withName "enchanted_stem"
            strippedEnchantedStem   withName "stripped_enchanted_stem"
            enchantedHyphae         withName "enchanted_hyphae"
            strippedEnchantedHyphae withName "stripped_enchanted_hyphae"
            enchantedPlanks         withName "enchanted_planks"
            enchantedSlab           withName "enchanted_slab"
            enchantedStairs         withName "enchanted_stairs"
            enchantedButton         withName "enchanted_button"
            enchantedPressurePlate  withName "enchanted_pressure_plate"
            enchantedTrapdoor       withName "enchanted_trapdoor"
            enchantedDoor           withName "enchanted_door"
            enchantedFence          withName "enchanted_fence"
            enchantedFenceGate      withName "enchanted_fence_gate"
            enchantedSign           withName "enchanted_sign"
            enchantedShroomlight    withName "enchanted_shroomlight"
            enchantedWart           withName "enchanted_wart"
            enlium                  withName "enlium"
            enliumGrowth            withName "enlium_growth"
            enchantedFungus         withName "enchanted_fungus"
            hoopvine                withName "hoopvine"
        }
    }
}