package olivermakesco.de.refmagic.block;

import net.minecraft.block.OreBlock;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class KyriteOreBlock extends OreBlock {
    public KyriteOreBlock(Settings settings) {
        super(settings, UniformIntProvider.create(1, 5));
    }
}
