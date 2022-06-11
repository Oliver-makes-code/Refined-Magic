package olivermakesco.de.refmagic.block

import net.minecraft.block.SignBlock
import net.minecraft.block.WallSignBlock
import net.minecraft.util.Identifier
import net.minecraft.util.SignType

class TerraformWallSignBlock(
    private val texture: Identifier,
    settings: Settings?
) : WallSignBlock(settings, SignType.OAK), RefinedMagicSign {
    override fun getTexture(): Identifier {
        return texture
    }
}