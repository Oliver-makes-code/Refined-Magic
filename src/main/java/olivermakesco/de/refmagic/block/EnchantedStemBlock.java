package olivermakesco.de.refmagic.block;

import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;

public class EnchantedStemBlock extends PillarBlock {
    public EnchantedStemBlock() {
        super(QuiltBlockSettings.copyOf(Blocks.CRIMSON_STEM));
    }
}
