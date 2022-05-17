package olivermakesco.de.refmagic;

import com.google.gson.Gson;
import net.minecraft.resource.ResourceType;
import olivermakesco.de.refmagic.augment.AugmentLoader;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import net.minecraft.util.Identifier;
import olivermakesco.de.refmagic.registry.RefinedMagicRegistry;
import org.quiltmc.qsl.networking.api.PacketByteBufs;
import org.quiltmc.qsl.networking.api.ServerPlayConnectionEvents;
import org.quiltmc.qsl.networking.api.ServerPlayNetworking;
import org.quiltmc.qsl.resource.loader.api.ResourceLoader;
import org.quiltmc.qsl.resource.loader.api.ResourceLoaderEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mod implements ModInitializer {
	public static final String modid = "refmagic";
	public static final Logger logger = LoggerFactory.getLogger(modid);

	@Override
	public void onInitialize(ModContainer mod) {

		RefinedMagicRegistry.register();
		ResourceLoader.get(ResourceType.SERVER_DATA).registerReloader(new AugmentLoader(new Gson(), "augments"));
		ResourceLoaderEvents.END_DATA_PACK_RELOAD.register((server, resourceManager, error) -> {
			if (server == null) return;
			var start = true;
			for (var entry : AugmentLoader.augments.entrySet()) {
				var id = entry.getKey();
				var augment = entry.getValue();
				var buffer = PacketByteBufs.create();
				buffer.writeBoolean(start);
				if (start) start = false;
				buffer.writeIdentifier(id);
				buffer.writeInt(augment.color());
				buffer.writeInt(augment.potion().size());
				for (Identifier potion : augment.potion())
					buffer.writeIdentifier(potion);
				var players = server.getPlayerManager().getPlayerList();
				for (var player : players)
					ServerPlayNetworking.send(player, id("augments"), buffer);
			}
		});
		ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
			var start = true;
			for (var entry : AugmentLoader.augments.entrySet()) {
				var id = entry.getKey();
				var augment = entry.getValue();
				var buffer = PacketByteBufs.create();
				buffer.writeBoolean(start);
				if (start) start = false;
				buffer.writeIdentifier(id);
				buffer.writeInt(augment.color());
				buffer.writeInt(augment.potion().size());
				for (Identifier potion : augment.potion())
					buffer.writeIdentifier(potion);
				ServerPlayNetworking.send(handler.player, id("augments"), buffer);
			}
		});
	}

	public static Identifier id(String name) {
		return new Identifier(modid,name);
	}
}
