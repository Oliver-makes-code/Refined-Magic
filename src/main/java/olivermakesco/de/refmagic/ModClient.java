package olivermakesco.de.refmagic;

import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import olivermakesco.de.refmagic.client.AltarTableBlockEntityRenderer;
import olivermakesco.de.refmagic.registry.RefinedMagicBlockEntities;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

public class ModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient(ModContainer mod) {
        BlockEntityRendererRegistry.register(RefinedMagicBlockEntities.altarTableBlockEntity, AltarTableBlockEntityRenderer::new);
    }
}
