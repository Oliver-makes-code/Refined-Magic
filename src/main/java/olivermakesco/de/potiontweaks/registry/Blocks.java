package olivermakesco.de.potiontweaks.registry;

import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import olivermakesco.de.potiontweaks.Mod;
import olivermakesco.de.potiontweaks.block.KyriteOreBlock;

public class Blocks {
    public static Block kyriteOre = new KyriteOreBlock(
            AbstractBlock.Settings
                    .of(Material.STONE,MapColor.PALE_YELLOW)
                    .sounds(BlockSoundGroup.STONE)
    );

    public static void register() {
        register(kyriteOre, Mod.id("kyrite_ore"));
    }

    public static void register(Block block, Identifier id) {
        Registry.register(Registry.BLOCK, id, block);
    }
}
