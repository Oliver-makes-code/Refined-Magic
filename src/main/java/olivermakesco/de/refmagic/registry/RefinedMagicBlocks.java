package olivermakesco.de.refmagic.registry;

import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import olivermakesco.de.refmagic.Mod;
import olivermakesco.de.refmagic.block.BismuthOreBlock;
import olivermakesco.de.refmagic.block.KyriteOreBlock;
import olivermakesco.de.refmagic.block.TopazOreBlock;

public class RefinedMagicBlocks {
    public static Block kyriteOre = new KyriteOreBlock(
            AbstractBlock.Settings
                    .of(Material.STONE,MapColor.PALE_YELLOW)
                    .sounds(BlockSoundGroup.STONE)
    );
    public static Block topazOre = new TopazOreBlock(
            AbstractBlock.Settings
                    .of(Material.STONE,MapColor.DULL_RED)
                    .sounds(BlockSoundGroup.STONE)
    );
    public static Block bismuthOre = new BismuthOreBlock(
            AbstractBlock.Settings
                    .of(Material.STONE,MapColor.GRAY)
                    .sounds(BlockSoundGroup.STONE)
    );

    public static void register() {
        register(kyriteOre, Mod.id("kyrite_ore"));
        register(topazOre, Mod.id("topaz_ore"));
        register(bismuthOre, Mod.id("bismuth_ore"));
    }

    public static void register(Block block, Identifier id) {
        Registry.register(Registry.BLOCK, id, block);
    }
}
