package olivermakesco.de.refinedmagic;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import olivermakesco.de.refinedmagic.registry.RefinedMagicBlocks;

public class ModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(RefinedMagicBlocks.glassTank, RenderLayer.getTranslucent());
    }
}
