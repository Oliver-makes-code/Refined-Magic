package olivermakesco.de.refinedmagic;

import net.fabricmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import net.minecraft.util.Identifier;
import olivermakesco.de.refinedmagic.registry.RefinedMagicRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mod implements ModInitializer {
	public static final String modid = "refmagic";
	public static final Logger logger = LoggerFactory.getLogger(modid);

	@Override
	public void onInitialize(ModContainer mod) {
		RefinedMagicRegistry.register();
	}

	public static Identifier id(String name) {
		return new Identifier(modid,name);
	}

	public static void info(String s) {
		logger.info(s);
	}
	public static void error(String s) {
		logger.error(s);
	}
	public static void debug(String s) {
		logger.debug(s);
	}
}
