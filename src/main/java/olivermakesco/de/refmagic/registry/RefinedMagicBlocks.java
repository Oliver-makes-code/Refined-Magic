package olivermakesco.de.refmagic.registry;

import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import olivermakesco.de.refmagic.Mod;
import olivermakesco.de.refmagic.block.*;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;

public class RefinedMagicBlocks {
    public static Block kyriteOre = new KyriteOreBlock(
            QuiltBlockSettings
                    .copyOf(Blocks.END_STONE)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
    );
    public static Block topazOre = new TopazOreBlock(
            QuiltBlockSettings
                    .copyOf(Blocks.GRANITE)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
    );
    public static Block bismuthOre = new BismuthOreBlock(
            QuiltBlockSettings
                    .copyOf(Blocks.BASALT)
                    .sounds(BlockSoundGroup.BASALT)
                    .requiresTool()
    );
    public static Block citrineOre = new CitrineOreBlock(
            QuiltBlockSettings
                    .copyOf(Blocks.BLACKSTONE)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
    );
    public static Block opalOre = new OpalOreBlock(
            QuiltBlockSettings
                    .copyOf(Blocks.END_STONE)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
    );
    public static Block roseQuartzOre = new RoseQuartzOreBlock(
            QuiltBlockSettings
                    .copyOf(Blocks.END_STONE)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
    );

    public static void register() {
        register(kyriteOre, Mod.id("kyrite_ore"));
        register(topazOre, Mod.id("topaz_ore"));
        register(bismuthOre, Mod.id("bismuth_ore"));
        register(citrineOre, Mod.id("citrine_ore"));
        register(opalOre, Mod.id("opal_ore"));
        register(roseQuartzOre, Mod.id("rose_quartz_ore"));
    }

    public static void register(Block block, Identifier id) {
        Registry.register(Registry.BLOCK, id, block);
    }
}
