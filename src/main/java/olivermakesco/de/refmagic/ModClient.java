package olivermakesco.de.refmagic;

import com.terraformersmc.terraform.sign.SpriteIdentifierRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import olivermakesco.de.refmagic.augment.Augment;
import olivermakesco.de.refmagic.augment.AugmentEvents;
import olivermakesco.de.refmagic.augment.AugmentLoader;
import olivermakesco.de.refmagic.client.AltarTableBlockEntityRenderer;
import olivermakesco.de.refmagic.item.NecklaceItem;
import olivermakesco.de.refmagic.registry.RefinedMagicBlockEntities;
import olivermakesco.de.refmagic.registry.RefinedMagicBlocks;
import olivermakesco.de.refmagic.registry.RefinedMagicItems;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.block.extensions.api.client.BlockRenderLayerMap;
import org.quiltmc.qsl.lifecycle.api.client.event.ClientLifecycleEvents;
import org.quiltmc.qsl.lifecycle.api.client.event.ClientWorldTickEvents;
import org.quiltmc.qsl.networking.api.client.ClientPlayNetworking;

import java.util.ArrayList;
import java.util.HashMap;

public class ModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient(ModContainer mod) {
        ClientWorldTickEvents.END.register((client, world) -> {
            AltarTableBlockEntityRenderer.rotation += 0.5;
        });
        BlockEntityRendererRegistry.register(RefinedMagicBlockEntities.altarTableBlockEntity, AltarTableBlockEntityRenderer::new);
        ColorProviderRegistry.ITEM.register(new Provider(), RefinedMagicItems.baseNecklace);
        BlockRenderLayerMap.put(RenderLayer.getCutout(), RefinedMagicBlocks.enliumGrowth);
        BlockRenderLayerMap.put(RenderLayer.getCutout(), RefinedMagicBlocks.enchantedFungus);
        BlockRenderLayerMap.put(RenderLayer.getCutout(), RefinedMagicBlocks.hoopvine);
        BlockRenderLayerMap.put(RenderLayer.getCutout(), RefinedMagicBlocks.enchantedTrapdoor);
        BlockRenderLayerMap.put(RenderLayer.getCutout(), RefinedMagicBlocks.enchantedDoor);
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, RefinedMagicBlocks.enchantedSign.getTexture()));
        ClientPlayNetworking.registerGlobalReceiver(AugmentEvents.id, (client, handler, buf, responseSender) -> {
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
    static class Provider implements ItemColorProvider {

        @Override
        public int getColor(ItemStack itemStack, int i) {
            if (i == 0) return NecklaceItem.getAugment(itemStack).getValue().color();
            return 0xffffff;
        }
    }
}
