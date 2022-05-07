package olivermakesco.de.refmagic;

import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.item.ItemStack;
import olivermakesco.de.refmagic.client.AltarTableBlockEntityRenderer;
import olivermakesco.de.refmagic.item.NecklaceItem;
import olivermakesco.de.refmagic.registry.RefinedMagicBlockEntities;
import olivermakesco.de.refmagic.registry.RefinedMagicItems;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

public class ModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient(ModContainer mod) {
        BlockEntityRendererRegistry.register(RefinedMagicBlockEntities.altarTableBlockEntity, AltarTableBlockEntityRenderer::new);
        ColorProviderRegistry.ITEM.register(new Provider(), RefinedMagicItems.baseNecklace);


    }
    static class Provider implements ItemColorProvider {

        @Override
        public int getColor(ItemStack itemStack, int i) {
            if (i == 0) return NecklaceItem.getAugment(itemStack).getValue().color();
            return 0xffffff;
        }
    }
}
