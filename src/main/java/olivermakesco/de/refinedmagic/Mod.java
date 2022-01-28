package olivermakesco.de.refinedmagic;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import olivermakesco.de.refinedmagic.registry.RefinedMagicRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mod implements ModInitializer {
	public static final String modid = "refmagic";
	public static final Logger logger = LoggerFactory.getLogger(modid);

	@Override
	public void onInitialize() {
		info("Initializing Refined Magic!");
		RefinedMagicRegistry.register();
		info("Refined Magic initialized!");
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
