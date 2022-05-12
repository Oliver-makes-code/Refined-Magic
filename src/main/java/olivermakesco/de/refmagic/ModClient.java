package olivermakesco.de.refmagic;

import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import olivermakesco.de.refmagic.augment.Augment;
import olivermakesco.de.refmagic.augment.AugmentLoader;
import olivermakesco.de.refmagic.client.AltarTableBlockEntityRenderer;
import olivermakesco.de.refmagic.item.NecklaceItem;
import olivermakesco.de.refmagic.registry.RefinedMagicBlockEntities;
import olivermakesco.de.refmagic.registry.RefinedMagicItems;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.networking.api.PacketSender;
import org.quiltmc.qsl.networking.api.client.ClientPlayNetworking;

import java.util.ArrayList;
import java.util.HashMap;

public class ModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient(ModContainer mod) {
        BlockEntityRendererRegistry.register(RefinedMagicBlockEntities.altarTableBlockEntity, AltarTableBlockEntityRenderer::new);
        ColorProviderRegistry.ITEM.register(new Provider(), RefinedMagicItems.baseNecklace);

        ClientPlayNetworking.registerGlobalReceiver(Mod.id("augments"), (client, handler, buf, responseSender) -> {
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
