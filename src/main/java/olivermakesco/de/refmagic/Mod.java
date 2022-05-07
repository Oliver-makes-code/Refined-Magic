package olivermakesco.de.refmagic;

import com.google.gson.Gson;
import net.minecraft.resource.ResourceType;
import olivermakesco.de.refmagic.augment.AugmentLoader;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import net.minecraft.util.Identifier;
import olivermakesco.de.refmagic.registry.RefinedMagicRegistry;
import org.quiltmc.qsl.resource.loader.api.ResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mod implements ModInitializer {
	public static final String modid = "refmagic";
	public static final Logger logger = LoggerFactory.getLogger(modid);

	@Override
	public void onInitialize(ModContainer mod) {
		RefinedMagicRegistry.register();
		ResourceLoader.get(ResourceType.SERVER_DATA).registerReloader(new AugmentLoader(new Gson(), "augments"));
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
