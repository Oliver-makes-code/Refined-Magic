package olivermakesco.de.refmagic

import net.minecraft.util.Identifier
import olivermakesco.de.refmagic.augment.AugmentEvents
import olivermakesco.de.refmagic.registry.RefinedMagicRegistry
import org.quiltmc.loader.api.ModContainer
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer
import org.slf4j.LoggerFactory

class Mod : ModInitializer {
    override fun onInitialize(mod: ModContainer) {
        RefinedMagicRegistry.register()
        AugmentEvents.register()
    }

    companion object {
        const val modid = "refmagic"
        val logger = LoggerFactory.getLogger(modid)
        @JvmStatic
		fun id(name: String?): Identifier {
            return Identifier(modid, name)
        }
    }
}