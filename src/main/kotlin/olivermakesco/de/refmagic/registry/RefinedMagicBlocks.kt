package olivermakesco.de.refmagic.registry

import com.terraformersmc.terraform.sign.block.TerraformSignBlock
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock
import com.terraformersmc.terraform.wood.block.StrippableLogBlock
import net.minecraft.block.*
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import olivermakesco.de.refmagic.Mod
import olivermakesco.de.refmagic.block.*
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings

object RefinedMagicBlocks {
    @JvmField
    var kyriteOreEnd: Block = RefinedMagicOreBlock(
        QuiltBlockSettings
            .copyOf(Blocks.END_STONE)
            .sounds(BlockSoundGroup.STONE)
            .requiresTool()
    )
    @JvmField
    var kyriteOreOverworld: Block = RefinedMagicOreBlock(
        QuiltBlockSettings
            .copyOf(Blocks.STONE)
            .sounds(BlockSoundGroup.STONE)
            .requiresTool()
    )
    @JvmField
    var kyriteOreNether: Block = RefinedMagicOreBlock(
        QuiltBlockSettings
            .copyOf(Blocks.NETHERRACK)
            .sounds(BlockSoundGroup.NETHERRACK)
            .requiresTool()
    )
    @JvmField
    var kyriteBlock = Block(
        QuiltBlockSettings
            .copyOf(Blocks.AMETHYST_BLOCK)
            .requiresTool()
    )
    @JvmField
    var topazOre: Block = RefinedMagicOreBlock(
        QuiltBlockSettings
            .copyOf(Blocks.GRANITE)
            .sounds(BlockSoundGroup.STONE)
            .requiresTool()
    )
    @JvmField
    var topazBlock = Block(
        QuiltBlockSettings
            .copyOf(Blocks.AMETHYST_BLOCK)
            .requiresTool()
    )
    @JvmField
    var bismuthOreNether: Block = RefinedMagicOreBlock(
        QuiltBlockSettings
            .copyOf(Blocks.BASALT)
            .sounds(BlockSoundGroup.BASALT)
            .requiresTool()
    )
    @JvmField
    var bismuthOreOverworld: Block = RefinedMagicOreBlock(
        QuiltBlockSettings
            .copyOf(Blocks.DEEPSLATE)
            .sounds(BlockSoundGroup.DEEPSLATE)
            .requiresTool()
    )
    @JvmField
    var bismuthBlock: Block = RefinedMagicOreBlock(
        QuiltBlockSettings
            .copyOf(Blocks.IRON_BLOCK)
            .sounds(BlockSoundGroup.METAL)
            .requiresTool()
    )
    @JvmField
    var citrineOre: Block = RefinedMagicOreBlock(
        QuiltBlockSettings
            .copyOf(Blocks.BLACKSTONE)
            .sounds(BlockSoundGroup.STONE)
            .requiresTool()
    )
    @JvmField
    var citrineBlock = Block(
        QuiltBlockSettings
            .copyOf(Blocks.AMETHYST_BLOCK)
            .sounds(BlockSoundGroup.AMETHYST_BLOCK)
            .requiresTool()
    )
    @JvmField
    var opalOre: Block = RefinedMagicOreBlock(
        QuiltBlockSettings
            .copyOf(Blocks.END_STONE)
            .sounds(BlockSoundGroup.STONE)
            .requiresTool()
    )
    @JvmField
    var opalBlock = Block(
        QuiltBlockSettings
            .copyOf(Blocks.AMETHYST_BLOCK)
            .requiresTool()
    )
    @JvmField
    var roseQuartzOre: Block = RefinedMagicOreBlock(
        QuiltBlockSettings
            .copyOf(Blocks.END_STONE)
            .sounds(BlockSoundGroup.STONE)
            .requiresTool()
    )
    @JvmField
    var roseQuartzBlock = Block(
        QuiltBlockSettings
            .copyOf(Blocks.QUARTZ_BLOCK)
            .sounds(BlockSoundGroup.AMETHYST_BLOCK)
            .requiresTool()
    )
    @JvmField
    var infestedNetherrack: Block = RefinedMagicOreBlock(
        QuiltBlockSettings
            .copyOf(Blocks.ANCIENT_DEBRIS)
            .sounds(BlockSoundGroup.NETHERRACK)
            .requiresTool()
    )
    @JvmField
    var altarBlock: Block = AltarTableBlock(
        QuiltBlockSettings
            .copyOf(Blocks.SPRUCE_PLANKS)
    )
    @JvmField
    var strippedEnchantedStem: Block = PillarBlock(
        QuiltBlockSettings
            .copyOf(Blocks.CRIMSON_STEM)
    )
    @JvmField
    var enchantedStem: Block = StrippableLogBlock(
        { strippedEnchantedStem },
        MapColor.PALE_PURPLE,
        QuiltBlockSettings.copyOf(Blocks.CRIMSON_STEM)
    )
    @JvmField
    var strippedEnchantedHyphae: Block = PillarBlock(
        QuiltBlockSettings
            .copyOf(Blocks.CRIMSON_STEM)
    )
    @JvmField
    var enchantedHyphae: Block = StrippableLogBlock(
        { strippedEnchantedHyphae },
        MapColor.PALE_PURPLE,
        QuiltBlockSettings.copyOf(Blocks.CRIMSON_STEM)
    )
    @JvmField
    var enchantedPlanks = Block(
        QuiltBlockSettings
            .copyOf(Blocks.WARPED_PLANKS)
    )
    @JvmField
    var enchantedSlab: Block = SlabBlock(
        QuiltBlockSettings
            .copyOf(Blocks.WARPED_SLAB)
    )
    @JvmField
    var enchantedStairs: Block = StairsBlock(
        enchantedPlanks.defaultState,
        QuiltBlockSettings
            .copyOf(Blocks.WARPED_STAIRS)
    )
    @JvmField
    var enchantedButton: Block = WoodenButtonBlock(
        QuiltBlockSettings
            .copyOf(Blocks.WARPED_BUTTON)
    )
    @JvmField
    var enchantedPressurePlate: Block = PressurePlateBlock(
        PressurePlateBlock.ActivationRule.EVERYTHING,
        QuiltBlockSettings
            .copyOf(Blocks.WARPED_PRESSURE_PLATE)
    )
    @JvmField
    var enchantedTrapdoor: Block = TrapdoorBlock(
        QuiltBlockSettings
            .copyOf(Blocks.WARPED_TRAPDOOR)
    )
    @JvmField
    var enchantedDoor: Block = DoorBlock(
        QuiltBlockSettings
            .copyOf(Blocks.WARPED_DOOR)
    )
    @JvmField
    var enchantedFence: Block = FenceBlock(
        QuiltBlockSettings
            .copyOf(Blocks.WARPED_FENCE)
    )
    @JvmField
    var enchantedFenceGate: Block = FenceGateBlock(
        QuiltBlockSettings
            .copyOf(Blocks.WARPED_FENCE_GATE)
    )
    @JvmField
    var enchantedSign =
        TerraformSignBlock(
            Mod.id("entity/sign/enchanted"),
            QuiltBlockSettings
                .copyOf(Blocks.WARPED_SIGN)
        )
    @JvmField
    var enchantedWallSign: Block = TerraformWallSignBlock(
        Mod.id("entity/sign/enchanted"),
        QuiltBlockSettings
            .copyOf(Blocks.WARPED_WALL_SIGN)
            .dropsLike(enchantedSign)
    )
    @JvmField
    var enchantedWart = Block(
        QuiltBlockSettings
            .copyOf(Blocks.NETHER_WART_BLOCK)
    )
    @JvmField
    var enchantedShroomlight = Block(
        QuiltBlockSettings
            .copyOf(Blocks.SHROOMLIGHT)
    )
    @JvmField
    var enlium: Block = EnliumBlock(
        QuiltBlockSettings
            .copyOf(Blocks.END_STONE)
    )
    @JvmField
    var enliumGrowth: Block = EnliumGrowthBlock()
    @JvmField
    var enchantedFungus: Block = MushroomPlantBlock(
        QuiltBlockSettings
            .copyOf(Blocks.CRIMSON_FUNGUS)
    ) {
        RefinedMagicWorldgen.enchantedFungusPlanted
    }
    @JvmField
    var hoopvine: Block = HoopvineBlock()

    fun register() {
        register(kyriteOreEnd, Mod.id("kyrite_ore_end"))
        register(kyriteOreOverworld, Mod.id("kyrite_ore_overworld"))
        register(kyriteOreNether, Mod.id("kyrite_ore_nether"))
        register(kyriteBlock, Mod.id("kyrite_block"))
        register(topazOre, Mod.id("topaz_ore"))
        register(topazBlock, Mod.id("topaz_block"))
        register(bismuthOreNether, Mod.id("bismuth_ore_nether"))
        register(bismuthOreOverworld, Mod.id("bismuth_ore_overworld"))
        register(bismuthBlock, Mod.id("bismuth_block"))
        register(citrineOre, Mod.id("citrine_ore"))
        register(citrineBlock, Mod.id("citrine_block"))
        register(opalOre, Mod.id("opal_ore"))
        register(opalBlock, Mod.id("opal_block"))
        register(roseQuartzOre, Mod.id("rose_quartz_ore"))
        register(roseQuartzBlock, Mod.id("rose_quartz_block"))
        register(infestedNetherrack, Mod.id("infested_netherrack"))
        register(altarBlock, Mod.id("altar"))
        register(enlium, Mod.id("enlium"))
        register(enliumGrowth, Mod.id("enlium_growth"))
        register(hoopvine, Mod.id("hoopvine"))
        register(enchantedFungus, Mod.id("enchanted_fungus"))
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
        register(enchantedWallSign, Mod.id("enchanted_wall_sign"))
        register(enchantedShroomlight, Mod.id("enchanted_shroomlight"))
        register(enchantedWart, Mod.id("enchanted_wart"))
    }

    fun register(block: Block, id: Identifier?) {
        Registry.register(Registry.BLOCK, id, block)
    }
}