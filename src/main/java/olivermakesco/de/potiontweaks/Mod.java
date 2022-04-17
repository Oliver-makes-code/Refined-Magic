package olivermakesco.de.potiontweaks;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import net.minecraft.util.Identifier;
import olivermakesco.de.potiontweaks.registry.PotionTweaksRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mod implements ModInitializer {
	public static final String modid = "potiontweaks";
	public static final Logger logger = LoggerFactory.getLogger(modid);

	@Override
	public void onInitialize(ModContainer mod) {
		PotionTweaksRegistry.register();
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
