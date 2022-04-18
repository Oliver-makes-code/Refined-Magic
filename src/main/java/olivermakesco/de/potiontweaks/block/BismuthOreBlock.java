package olivermakesco.de.potiontweaks.block;

import net.minecraft.block.OreBlock;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class BismuthOreBlock extends OreBlock {
    public BismuthOreBlock(Settings settings) {
        super(settings, UniformIntProvider.create(1, 3));
    }
}
