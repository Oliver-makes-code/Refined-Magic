package olivermakesco.de.refmagic.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3f;
import olivermakesco.de.refmagic.block.entity.AltarTableBlockEntity;

public class AltarTableBlockEntityRenderer implements BlockEntityRenderer<AltarTableBlockEntity> {
    public int rotation = 0;

    public AltarTableBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {

    }

    @Override
    public void render(AltarTableBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        var time = ++rotation;
        double offset = Math.sin((time + tickDelta) / 8.0) / 8.0;

        matrices.push();
        matrices.translate(0.25, 1.1 + offset, 0.25);
        drawItem(entity, tickDelta, matrices, vertexConsumers, light, overlay, time,0);
        matrices.pop();
        matrices.push();
        matrices.translate(0.75, 1.1 + offset, 0.25);
        drawItem(entity, tickDelta, matrices, vertexConsumers, light, overlay, time,1);
        matrices.pop();
        matrices.push();
        matrices.translate(0.25, 1.1 + offset, 0.75);
        drawItem(entity, tickDelta, matrices, vertexConsumers, light, overlay, time,2);
        matrices.pop();
        matrices.push();
        matrices.translate(0.75, 1.1 + offset, 0.75);
        drawItem(entity, tickDelta, matrices, vertexConsumers, light, overlay, time,3);
        matrices.pop();
    }

    private void drawItem(AltarTableBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, long time, int slot) {
        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion((time + tickDelta) * 4));
        matrices.scale(0.5f,0.5f,0.5f);
        MinecraftClient.getInstance().getItemRenderer().renderItem(entity.getSlot(slot), ModelTransformation.Mode.FIXED, light, overlay, matrices, vertexConsumers, 0);
        matrices.pop();
        matrices.push();
    }
}
