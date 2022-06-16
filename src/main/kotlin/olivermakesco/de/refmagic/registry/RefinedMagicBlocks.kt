package olivermakesco.de.refmagic.registry

import com.terraformersmc.terraform.sign.block.TerraformSignBlock
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock
import com.terraformersmc.terraform.wood.block.StrippableLogBlock
import net.minecraft.block.*
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.registry.Registry
import olivermakesco.de.refmagic.Mod
import olivermakesco.de.refmagic.block.*
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings
import org.quiltmc.qkl.wrapper.minecraft.registry.*

object RefinedMagicBlocks {
    var kyriteOreEnd: Block = RefinedMagicOreBlock(
        QuiltBlockSettings
            .copyOf(Blocks.END_STONE)
            .sounds(BlockSoundGroup.STONE)
            .requiresTool()
    )
    var kyriteOreOverworld: Block = RefinedMagicOreBlock(
        QuiltBlockSettings
            .copyOf(Blocks.STONE)
            .sounds(BlockSoundGroup.STONE)
            .requiresTool()
    )
    var kyriteOreNether: Block = RefinedMagicOreBlock(
        QuiltBlockSettings
            .copyOf(Blocks.NETHERRACK)
            .sounds(BlockSoundGroup.NETHERRACK)
            .requiresTool()
    )
    var kyriteBlock = Block(
        QuiltBlockSettings
            .copyOf(Blocks.AMETHYST_BLOCK)
            .requiresTool()
    )
    var topazOre: Block = RefinedMagicOreBlock(
        QuiltBlockSettings
            .copyOf(Blocks.GRANITE)
            .sounds(BlockSoundGroup.STONE)
            .requiresTool()
    )
    var topazBlock = Block(
        QuiltBlockSettings
            .copyOf(Blocks.AMETHYST_BLOCK)
            .requiresTool()
    )
    var bismuthOreNether: Block = RefinedMagicOreBlock(
        QuiltBlockSettings
            .copyOf(Blocks.BASALT)
            .sounds(BlockSoundGroup.BASALT)
            .requiresTool()
    )
    var bismuthOreOverworld: Block = RefinedMagicOreBlock(
        QuiltBlockSettings
            .copyOf(Blocks.DEEPSLATE)
            .sounds(BlockSoundGroup.DEEPSLATE)
            .requiresTool()
    )
    var bismuthBlock: Block = RefinedMagicOreBlock(
        QuiltBlockSettings
            .copyOf(Blocks.IRON_BLOCK)
            .sounds(BlockSoundGroup.METAL)
            .requiresTool()
    )
    var citrineOre: Block = RefinedMagicOreBlock(
        QuiltBlockSettings
            .copyOf(Blocks.BLACKSTONE)
            .sounds(BlockSoundGroup.STONE)
            .requiresTool()
    )
    var citrineBlock = Block(
        QuiltBlockSettings
            .copyOf(Blocks.AMETHYST_BLOCK)
            .sounds(BlockSoundGroup.AMETHYST_BLOCK)
            .requiresTool()
    )
    var opalOre: Block = RefinedMagicOreBlock(
        QuiltBlockSettings
            .copyOf(Blocks.END_STONE)
            .sounds(BlockSoundGroup.STONE)
            .requiresTool()
    )
    var opalBlock = Block(
        QuiltBlockSettings
            .copyOf(Blocks.AMETHYST_BLOCK)
            .requiresTool()
    )
    var roseQuartzOre: Block = RefinedMagicOreBlock(
        QuiltBlockSettings
            .copyOf(Blocks.END_STONE)
            .sounds(BlockSoundGroup.STONE)
            .requiresTool()
    )
    var roseQuartzBlock = Block(
        QuiltBlockSettings
            .copyOf(Blocks.QUARTZ_BLOCK)
            .sounds(BlockSoundGroup.AMETHYST_BLOCK)
            .requiresTool()
    )
    var infestedNetherrack: Block = RefinedMagicOreBlock(
        QuiltBlockSettings
            .copyOf(Blocks.ANCIENT_DEBRIS)
            .sounds(BlockSoundGroup.NETHERRACK)
            .requiresTool()
    )
    var altarBlock: Block = AltarTableBlock(
        QuiltBlockSettings
            .copyOf(Blocks.SPRUCE_PLANKS)
    )
    var strippedEnchantedStem: Block = PillarBlock(
        QuiltBlockSettings
            .copyOf(Blocks.CRIMSON_STEM)
    )
    var enchantedStem: Block = StrippableLogBlock(
        { strippedEnchantedStem },
        MapColor.PALE_PURPLE,
        QuiltBlockSettings.copyOf(Blocks.CRIMSON_STEM)
    )
    var strippedEnchantedHyphae: Block = PillarBlock(
        QuiltBlockSettings
            .copyOf(Blocks.CRIMSON_STEM)
    )
    var enchantedHyphae: Block = StrippableLogBlock(
        { strippedEnchantedHyphae },
        MapColor.PALE_PURPLE,
        QuiltBlockSettings.copyOf(Blocks.CRIMSON_STEM)
    )
    var enchantedPlanks = Block(
        QuiltBlockSettings
            .copyOf(Blocks.WARPED_PLANKS)
    )
    var enchantedSlab: Block = SlabBlock(
        QuiltBlockSettings
            .copyOf(Blocks.WARPED_SLAB)
    )
    var enchantedStairs: Block = StairsBlock(
        enchantedPlanks.defaultState,
        QuiltBlockSettings
            .copyOf(Blocks.WARPED_STAIRS)
    )
    var enchantedButton: Block = WoodenButtonBlock(
        QuiltBlockSettings
            .copyOf(Blocks.WARPED_BUTTON)
    )
    var enchantedPressurePlate: Block = PressurePlateBlock(
        PressurePlateBlock.ActivationRule.EVERYTHING,
        QuiltBlockSettings
            .copyOf(Blocks.WARPED_PRESSURE_PLATE)
    )
    var enchantedTrapdoor: Block = TrapdoorBlock(
        QuiltBlockSettings
            .copyOf(Blocks.WARPED_TRAPDOOR)
    )
    var enchantedDoor: Block = DoorBlock(
        QuiltBlockSettings
            .copyOf(Blocks.WARPED_DOOR)
    )
    var enchantedFence: Block = FenceBlock(
        QuiltBlockSettings
            .copyOf(Blocks.WARPED_FENCE)
    )
    var enchantedFenceGate: Block = FenceGateBlock(
        QuiltBlockSettings
            .copyOf(Blocks.WARPED_FENCE_GATE)
    )
    var enchantedSign = TerraformSignBlock(
        Mod.id("entity/sign/enchanted"),
        QuiltBlockSettings
            .copyOf(Blocks.WARPED_SIGN)
    )
    var enchantedWallSign: Block = TerraformWallSignBlock(
        Mod.id("entity/sign/enchanted"),
        QuiltBlockSettings
            .copyOf(Blocks.WARPED_WALL_SIGN)
            .dropsLike(enchantedSign)
    )
    var enchantedWart = Block(
        QuiltBlockSettings
            .copyOf(Blocks.NETHER_WART_BLOCK)
    )
    var enchantedShroomlight = Block(
        QuiltBlockSettings
            .copyOf(Blocks.SHROOMLIGHT)
    )
    @JvmField
    var enlium: Block = EnliumBlock(
        QuiltBlockSettings
            .copyOf(Blocks.END_STONE)
    )
    var enliumGrowth: Block = EnliumGrowthBlock()
    var enchantedFungus: Block = MushroomPlantBlock(
        QuiltBlockSettings
            .copyOf(Blocks.CRIMSON_FUNGUS)
    ) {
        RefinedMagicWorldgen.enchantedFungusPlanted
    }
    var hoopvine: Block = HoopvineBlock()

    fun register() {
        Registry.BLOCK(Mod.modid) {
            kyriteOreEnd            withName "kyrite_ore_end"
            kyriteOreOverworld      withName "kyrite_ore_overworld"
            kyriteOreNether         withName "kyrite_ore_nether"
            kyriteBlock             withName "kyrite_block"
            topazOre                withName "topaz_ore"
            topazBlock              withName "topaz_block"
            bismuthOreNether        withName "bismuth_ore_nether"
            bismuthOreOverworld     withName "bismuth_ore_overworld"
            bismuthBlock            withName "bismuth_block"
            citrineOre              withName "citrine_ore"
            citrineBlock            withName "citrine_block"
            opalOre                 withName "opal_ore"
            opalBlock               withName "opal_block"
            roseQuartzOre           withName "rose_quartz_ore"
            roseQuartzBlock         withName "rose_quartz_block"
            infestedNetherrack      withName "infested_netherrack"
            altarBlock              withName "altar"
            enlium                  withName "enlium"
            enliumGrowth            withName "enlium_growth"
            hoopvine                withName "hoopvine"
            enchantedFungus         withName "enchanted_fungus"
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
            enchantedWallSign       withName "enchanted_wall_sign"
            enchantedShroomlight    withName "enchanted_shroomlight"
            enchantedWart           withName "enchanted_wart"
        }
    }
}