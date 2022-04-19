package olivermakesco.de.refmagic.block;

import net.minecraft.block.OreBlock;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class RoseQuartzOreBlock extends OreBlock {
    public RoseQuartzOreBlock(Settings settings) {
        super(settings, UniformIntProvider.create(1, 3));
    }
}