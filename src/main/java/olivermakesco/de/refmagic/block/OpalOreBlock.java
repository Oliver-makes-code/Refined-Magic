package olivermakesco.de.refmagic.block;

import net.minecraft.block.OreBlock;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class OpalOreBlock extends OreBlock {
    public OpalOreBlock(Settings settings) {
        super(settings, UniformIntProvider.create(1, 2));
    }
}
