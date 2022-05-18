package olivermakesco.de.refmagic;

import net.minecraft.client.network.ClientPlayerEntity;
import olivermakesco.de.refmagic.augment.AugmentEvents;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import net.minecraft.util.Identifier;
import olivermakesco.de.refmagic.registry.RefinedMagicRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mod implements ModInitializer {
	public static final String modid = "refmagic";
	public static final Logger logger = LoggerFactory.getLogger(modid);

	@Override
	public void onInitialize(ModContainer mod) {
		RefinedMagicRegistry.register();
		AugmentEvents.register();
	}

	public static Identifier id(String name) {
		return new Identifier(modid,name);
	}
}
