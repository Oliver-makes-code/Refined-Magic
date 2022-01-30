package olivermakesco.de.refinedmagic.registry;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import olivermakesco.de.refinedmagic.Mod;
import olivermakesco.de.refinedmagic.block.EvaporationTableBlock;
import olivermakesco.de.refinedmagic.block.KyriteOreBlock;

public class RefinedMagicBlocks {
    static Block kyriteOre = new KyriteOreBlock(AbstractBlock.Settings.copy(Blocks.END_STONE));
    static Block evaporationTable = new EvaporationTableBlock();
    public static void register() {
        register(kyriteOre, Mod.id("kyrite_ore"));
        register(evaporationTable, Mod.id("evaporation_table"));
    }

    public static void register(Block block, Identifier id) {
        Registry.register(Registry.BLOCK, id, block);
    }
}
