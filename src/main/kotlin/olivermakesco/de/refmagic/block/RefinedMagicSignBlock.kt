package olivermakesco.de.refmagic.block

import net.minecraft.block.SignBlock
import net.minecraft.util.Identifier
import net.minecraft.util.SignType

class TerraformSignBlock(
    private val texture: Identifier,
    settings: Settings?
) : SignBlock(settings, SignType.OAK), RefinedMagicSign {
    override fun getTexture(): Identifier {
        return texture
    }
}