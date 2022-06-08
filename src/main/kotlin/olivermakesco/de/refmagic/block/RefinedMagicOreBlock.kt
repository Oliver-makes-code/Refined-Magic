package olivermakesco.de.refmagic.block

import net.minecraft.block.OreBlock
import net.minecraft.util.math.intprovider.UniformIntProvider

class RefinedMagicOreBlock(settings: Settings?) : OreBlock(settings, UniformIntProvider.create(1, 2))