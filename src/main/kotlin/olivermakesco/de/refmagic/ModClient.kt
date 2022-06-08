package olivermakesco.de.refmagic

import com.terraformersmc.terraform.sign.SpriteIdentifierRegistry
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry
import net.minecraft.client.MinecraftClient
import net.minecraft.client.color.item.ItemColorProvider
import net.minecraft.client.network.ClientPlayNetworkHandler
import net.minecraft.client.render.RenderLayer
import net.minecraft.client.render.TexturedRenderLayers
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory
import net.minecraft.client.util.SpriteIdentifier
import net.minecraft.client.world.ClientWorld
import net.minecraft.item.ItemStack
import net.minecraft.network.PacketByteBuf
import net.minecraft.util.Identifier
import olivermakesco.de.refmagic.augment.Augment
import olivermakesco.de.refmagic.augment.AugmentEvents
import olivermakesco.de.refmagic.augment.AugmentLoader
import olivermakesco.de.refmagic.client.AltarTableBlockEntityRenderer
import olivermakesco.de.refmagic.item.NecklaceItem.Companion.getAugment
import olivermakesco.de.refmagic.registry.RefinedMagicBlockEntities
import olivermakesco.de.refmagic.registry.RefinedMagicBlocks
import olivermakesco.de.refmagic.registry.RefinedMagicItems
import org.quiltmc.loader.api.ModContainer
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer
import org.quiltmc.qsl.block.extensions.api.client.BlockRenderLayerMap
import org.quiltmc.qsl.lifecycle.api.client.event.ClientWorldTickEvents
import org.quiltmc.qsl.networking.api.PacketSender
import org.quiltmc.qsl.networking.api.client.ClientPlayNetworking

class ModClient : ClientModInitializer {
    override fun onInitializeClient(mod: ModContainer) {
        ClientWorldTickEvents.END.register(ClientWorldTickEvents.End { client: MinecraftClient?, world: ClientWorld? -> AltarTableBlockEntityRenderer.rotation += 0.5.toFloat() })
        BlockEntityRendererRegistry.register(RefinedMagicBlockEntities.altarTableBlockEntity) { ctx: BlockEntityRendererFactory.Context? ->
            AltarTableBlockEntityRenderer(
                ctx
            )
        }
        ColorProviderRegistry.ITEM.register(Provider(), RefinedMagicItems.baseNecklace)
        BlockRenderLayerMap.put(RenderLayer.getCutout(), RefinedMagicBlocks.enliumGrowth)
        BlockRenderLayerMap.put(RenderLayer.getCutout(), RefinedMagicBlocks.enchantedFungus)
        BlockRenderLayerMap.put(RenderLayer.getCutout(), RefinedMagicBlocks.hoopvine)
        BlockRenderLayerMap.put(RenderLayer.getCutout(), RefinedMagicBlocks.enchantedTrapdoor)
        BlockRenderLayerMap.put(RenderLayer.getCutout(), RefinedMagicBlocks.enchantedDoor)
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(
            SpriteIdentifier(
                TexturedRenderLayers.SIGNS_ATLAS_TEXTURE,
                RefinedMagicBlocks.enchantedSign.texture
            )
        )
        ClientPlayNetworking.registerGlobalReceiver(AugmentEvents.id) { client: MinecraftClient, handler: ClientPlayNetworkHandler?, buf: PacketByteBuf, responseSender: PacketSender? ->
            if (client.isInSingleplayer) return@registerGlobalReceiver
            if (buf.readBoolean()) AugmentLoader.augments = HashMap()
            val id = buf.readIdentifier()
            val color = buf.readInt()
            val potionLength = buf.readInt()
            val potions = ArrayList<Identifier>()
            for (i in 0 until potionLength) potions.add(buf.readIdentifier())
            AugmentLoader.augments[id] = Augment(color, potions)
        }
    }

    internal class Provider : ItemColorProvider {
        override fun getColor(itemStack: ItemStack, i: Int): Int {
            return if (i == 0) getAugment(itemStack).value.color else 0xffffff
        }
    }
}