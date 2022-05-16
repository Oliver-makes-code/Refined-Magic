package olivermakesco.de.refmagic.registry;

import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
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

    public static Block enchantedStem = new EnchantedStemBlock();

    public static Block enchantedWart = new Block(QuiltBlockSettings.copyOf(Blocks.NETHER_WART_BLOCK));

    public static Block enchantedShroomlight = new Block(QuiltBlockSettings.copyOf(Blocks.SHROOMLIGHT));

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

        register(enchantedStem, Mod.id("enchanted_stem"));

        register(enchantedShroomlight, Mod.id("enchanted_shroomlight"));

        register(enchantedWart, Mod.id("enchanted_wart"));
    }

    public static void register(Block block, Identifier id) {
        Registry.register(Registry.BLOCK, id, block);
    }
}
