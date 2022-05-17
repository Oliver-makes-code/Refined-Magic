package olivermakesco.de.refmagic.augment;

import com.google.gson.Gson;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import olivermakesco.de.refmagic.Mod;
import org.quiltmc.qsl.networking.api.PacketByteBufs;
import org.quiltmc.qsl.networking.api.ServerPlayConnectionEvents;
import org.quiltmc.qsl.networking.api.ServerPlayNetworking;
import org.quiltmc.qsl.networking.api.client.ClientPlayNetworking;
import org.quiltmc.qsl.resource.loader.api.ResourceLoader;
import org.quiltmc.qsl.resource.loader.api.ResourceLoaderEvents;

import java.util.ArrayList;
import java.util.HashMap;

public class AugmentEvents {
    public static final Identifier id = Mod.id("augments");

    public static void register() {
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
                    ServerPlayNetworking.send(player, id, buffer);
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
                ServerPlayNetworking.send(handler.player, id, buffer);
            }
        });
    }

    @Environment(EnvType.CLIENT)
    public static void registerClient() {
        ClientPlayNetworking.registerGlobalReceiver(id, (client, handler, buf, responseSender) -> {
            if (client.isInSingleplayer()) return;
            if (buf.readBoolean())
                AugmentLoader.augments = new HashMap<>();
            var id = buf.readIdentifier();
            var color = buf.readInt();
            var potionLength = buf.readInt();
            var potions = new ArrayList<Identifier>();
            for (int i = 0; i < potionLength; i++)
                potions.add(buf.readIdentifier());
            AugmentLoader.augments.put(id, new Augment(color, potions));
        });
    }
}
