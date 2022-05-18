package olivermakesco.de.refmagic.registry;

import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import net.minecraft.block.*;
import net.minecraft.client.gui.screen.ingame.SignEditScreen;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.SignType;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;
import olivermakesco.de.refmagic.Mod;
import olivermakesco.de.refmagic.block.*;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;

public class RefinedMagicBlocks {
    public static Block kyriteOreEnd = new KyriteOreBlock(
            QuiltBlockSettings
                    .copyOf(Blocks.END_STONE)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
    );
    public static Block kyriteOreOverworld = new KyriteOreBlock(
            QuiltBlockSettings
                    .copyOf(Blocks.STONE)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
    );
    public static Block kyriteOreNether = new KyriteOreBlock(
            QuiltBlockSettings
                    .copyOf(Blocks.NETHERRACK)
                    .sounds(BlockSoundGroup.NETHERRACK)
                    .requiresTool()
    );
    public static Block kyriteBlock = new Block(
            QuiltBlockSettings
                    .copyOf(Blocks.AMETHYST_BLOCK)
                    .requiresTool()
    );
    public static Block topazOre = new TopazOreBlock(
            QuiltBlockSettings
                    .copyOf(Blocks.GRANITE)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
    );
    public static Block topazBlock = new Block(
            QuiltBlockSettings
                    .copyOf(Blocks.AMETHYST_BLOCK)
                    .requiresTool()
    );
    public static Block bismuthOreNether = new BismuthOreBlock(
            QuiltBlockSettings
                    .copyOf(Blocks.BASALT)
                    .sounds(BlockSoundGroup.BASALT)
                    .requiresTool()
    );
    public static Block bismuthOreOverworld = new BismuthOreBlock(
            QuiltBlockSettings
                    .copyOf(Blocks.DEEPSLATE)
                    .sounds(BlockSoundGroup.DEEPSLATE)
                    .requiresTool()
    );
    public static Block bismuthBlock = new BismuthOreBlock(
            QuiltBlockSettings
                    .copyOf(Blocks.IRON_BLOCK)
                    .sounds(BlockSoundGroup.METAL)
                    .requiresTool()
    );
    public static Block citrineOre = new CitrineOreBlock(
            QuiltBlockSettings
                    .copyOf(Blocks.BLACKSTONE)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
    );
    public static Block citrineBlock = new Block(
            QuiltBlockSettings
                    .copyOf(Blocks.AMETHYST_BLOCK)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .requiresTool()
    );
    public static Block opalOre = new OpalOreBlock(
            QuiltBlockSettings
                    .copyOf(Blocks.END_STONE)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
    );
    public static Block opalBlock = new Block(
            QuiltBlockSettings
                    .copyOf(Blocks.AMETHYST_BLOCK)
                    .requiresTool()
    );
    public static Block roseQuartzOre = new RoseQuartzOreBlock(
            QuiltBlockSettings
                    .copyOf(Blocks.END_STONE)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
    );
    public static Block roseQuartzBlock = new Block(
            QuiltBlockSettings
                    .copyOf(Blocks.QUARTZ_BLOCK)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .requiresTool()
    );
    public static Block altarBlock = new AltarTableBlock(
            QuiltBlockSettings
                    .copyOf(Blocks.SPRUCE_PLANKS)
    );

    public static Block enchantedStem = new EnchantedStemBlock(false);
    public static Block strippedEnchantedStem = new EnchantedStemBlock(true);
    public static Block enchantedHyphae = new EnchantedHyphaeBlock(false);
    public static Block strippedEnchantedHyphae = new EnchantedHyphaeBlock(true);
    public static Block enchantedPlanks = new Block(QuiltBlockSettings.copyOf(Blocks.WARPED_PLANKS));
    public static Block enchantedSlab = new SlabBlock(QuiltBlockSettings.copyOf(Blocks.WARPED_SLAB));
    public static Block enchantedStairs = new StairsBlock(enchantedPlanks.getDefaultState(), QuiltBlockSettings.copyOf(Blocks.WARPED_STAIRS));
    public static Block enchantedButton = new WoodenButtonBlock(QuiltBlockSettings.copyOf(Blocks.WARPED_BUTTON));
    public static Block enchantedPressurePlate = new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, QuiltBlockSettings.copyOf(Blocks.WARPED_PRESSURE_PLATE));
    public static Block enchantedTrapdoor = new TrapdoorBlock(QuiltBlockSettings.copyOf(Blocks.WARPED_TRAPDOOR));
    public static Block enchantedDoor = new DoorBlock(QuiltBlockSettings.copyOf(Blocks.WARPED_DOOR));
    public static Block enchantedFence = new FenceBlock(QuiltBlockSettings.copyOf(Blocks.WARPED_FENCE));
    public static Block enchantedFenceGate = new FenceGateBlock(QuiltBlockSettings.copyOf(Blocks.WARPED_FENCE_GATE));
    public static Block enchantedSign = new TerraformSignBlock(Mod.id("entity/sign/enchanted"), QuiltBlockSettings.copyOf(Blocks.WARPED_SIGN));
    public static Block enchantedWallSign = new TerraformWallSignBlock(Mod.id("entity/sign/enchanted"), QuiltBlockSettings.copyOf(Blocks.WARPED_WALL_SIGN));

    public static Block enchantedWart = new Block(QuiltBlockSettings.copyOf(Blocks.NETHER_WART_BLOCK));

    public static Block enchantedShroomlight = new Block(QuiltBlockSettings.copyOf(Blocks.SHROOMLIGHT));

    public static Block enlium = new EnliumBlock(QuiltBlockSettings.copyOf(Blocks.END_STONE));

    public static Block enliumGrowth = new EnliumGrowthBlock();

    public static Block enchantedFungus = new MushroomPlantBlock(QuiltBlockSettings.copyOf(Blocks.CRIMSON_FUNGUS), () -> TreeConfiguredFeatures.CRIMSON_FUNGUS_PLANTED);

    public static Block hoopvine = new HoopvineBlock();

    public static void register() {
        register(kyriteOreEnd, Mod.id("kyrite_ore_end"));
        register(kyriteOreOverworld, Mod.id("kyrite_ore_overworld"));
        register(kyriteOreNether, Mod.id("kyrite_ore_nether"));
        register(kyriteBlock, Mod.id("kyrite_block"));
        register(topazOre, Mod.id("topaz_ore"));
        register(topazBlock, Mod.id("topaz_block"));
        register(bismuthOreNether, Mod.id("bismuth_ore_nether"));
        register(bismuthOreOverworld, Mod.id("bismuth_ore_overworld"));
        register(bismuthBlock, Mod.id("bismuth_block"));
        register(citrineOre, Mod.id("citrine_ore"));
        register(citrineBlock, Mod.id("citrine_block"));
        register(opalOre, Mod.id("opal_ore"));
        register(opalBlock, Mod.id("opal_block"));
        register(roseQuartzOre, Mod.id("rose_quartz_ore"));
        register(roseQuartzBlock, Mod.id("rose_quartz_block"));
        register(altarBlock, Mod.id("altar"));


        register(enlium, Mod.id("enlium"));
        register(enliumGrowth, Mod.id("enlium_growth"));
        register(hoopvine, Mod.id("hoopvine"));
        register(enchantedFungus, Mod.id("enchanted_fungus"));

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
        register(enchantedWallSign, Mod.id("enchanted_wall_sign"));

        register(enchantedShroomlight, Mod.id("enchanted_shroomlight"));
        register(enchantedWart, Mod.id("enchanted_wart"));
    }

    public static void register(Block block, Identifier id) {
        Registry.register(Registry.BLOCK, id, block);
    }
}
