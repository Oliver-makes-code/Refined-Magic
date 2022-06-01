package olivermakesco.de.refmagic;

import net.minecraft.block.Blocks;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.registry.Registry;
import olivermakesco.de.refmagic.augment.AugmentEvents;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import net.minecraft.util.Identifier;
import olivermakesco.de.refmagic.registry.RefinedMagicRegistry;
import org.quiltmc.qsl.lifecycle.api.event.ServerWorldTickEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mod implements ModInitializer {
	public static final String modid = "refmagic";
	public static final Logger logger = LoggerFactory.getLogger(modid);
	public static final BooleanProperty copperPoweredProperty = BooleanProperty.of("rm_powered");
	public static final BooleanProperty copperPowerSource = BooleanProperty.of("rm_source");

	@Override
	public void onInitialize(ModContainer mod) {
		RefinedMagicRegistry.register();
		AugmentEvents.register();
	}

	public static Identifier id(String name) {
		return new Identifier(modid,name);
	}
}
