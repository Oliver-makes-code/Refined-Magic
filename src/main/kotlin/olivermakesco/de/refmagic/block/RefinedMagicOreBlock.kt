package olivermakesco.de.refmagic.block

import net.minecraft.block.Blocks
import net.minecraft.block.ExperienceDroppingBlock
import net.minecraft.util.math.intprovider.UniformIntProvider

class RefinedMagicOreBlock(settings: Settings) : ExperienceDroppingBlock(settings, UniformIntProvider.create(1, 2))