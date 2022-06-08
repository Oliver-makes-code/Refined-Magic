package olivermakesco.de.refmagic.augment

import com.google.gson.Gson
import net.minecraft.resource.ResourceManager
import net.minecraft.resource.ResourceType
import net.minecraft.server.MinecraftServer
import net.minecraft.server.network.ServerPlayNetworkHandler
import olivermakesco.de.refmagic.Mod
import org.quiltmc.qsl.networking.api.PacketByteBufs
import org.quiltmc.qsl.networking.api.PacketSender
import org.quiltmc.qsl.networking.api.ServerPlayConnectionEvents
import org.quiltmc.qsl.networking.api.ServerPlayNetworking
import org.quiltmc.qsl.resource.loader.api.ResourceLoader
import org.quiltmc.qsl.resource.loader.api.ResourceLoaderEvents

object AugmentEvents {
    val id = Mod.id("augments")
    fun register() {
        ResourceLoader.get(ResourceType.SERVER_DATA).registerReloader(AugmentLoader(Gson(), "augments"))
        ResourceLoaderEvents.END_DATA_PACK_RELOAD.register(ResourceLoaderEvents.EndDataPackReload { server: MinecraftServer?, _: ResourceManager?, _: Throwable? ->
            if (server == null) return@EndDataPackReload
            var start = true
            for ((_, augment) in AugmentLoader.augments) {
                val buffer = PacketByteBufs.create()
                buffer.writeBoolean(start)
                if (start) start = false
                buffer.writeIdentifier(id)
                buffer.writeInt(augment.color)
                buffer.writeInt(augment.potion.size)
                for (potion in augment.potion) buffer.writeIdentifier(potion)
                val players = server.playerManager.playerList
                for (player in players) ServerPlayNetworking.send(player, id, buffer)
            }
        })
        ServerPlayConnectionEvents.JOIN.register(ServerPlayConnectionEvents.Join { handler: ServerPlayNetworkHandler, _: PacketSender?, _: MinecraftServer? ->
            var start = true
            for ((_, augment) in AugmentLoader.augments) {
                val buffer = PacketByteBufs.create()
                buffer.writeBoolean(start)
                if (start) start = false
                buffer.writeIdentifier(id)
                buffer.writeInt(augment.color)
                buffer.writeInt(augment.potion.size)
                for (potion in augment.potion) buffer.writeIdentifier(potion)
                ServerPlayNetworking.send(handler.player, id, buffer)
            }
        })
    }
}