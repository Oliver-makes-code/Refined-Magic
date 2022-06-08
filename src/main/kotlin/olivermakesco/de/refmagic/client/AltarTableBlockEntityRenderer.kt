package olivermakesco.de.refmagic.client

import net.minecraft.client.MinecraftClient
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.block.entity.BlockEntityRenderer
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory
import net.minecraft.client.render.model.json.ModelTransformation
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.math.Vec3f
import olivermakesco.de.refmagic.block.entity.AltarTableBlockEntity

class AltarTableBlockEntityRenderer(ctx: BlockEntityRendererFactory.Context?) :
    BlockEntityRenderer<AltarTableBlockEntity> {
    override fun render(
        entity: AltarTableBlockEntity,
        tickDelta: Float,
        matrices: MatrixStack,
        vertexConsumers: VertexConsumerProvider,
        light: Int,
        overlay: Int
    ) {
        val time = rotation
        val offset = Math.sin((time + tickDelta) / 8.0) / 8.0
        drawItem(0.25, 0.25, offset, entity, tickDelta, matrices, vertexConsumers, light, overlay, time, 0)
        drawItem(0.75, 0.25, offset, entity, tickDelta, matrices, vertexConsumers, light, overlay, time, 1)
        drawItem(0.25, 0.75, offset, entity, tickDelta, matrices, vertexConsumers, light, overlay, time, 2)
        drawItem(0.75, 0.75, offset, entity, tickDelta, matrices, vertexConsumers, light, overlay, time, 3)
    }

    private fun drawItem(
        offx: Double,
        offz: Double,
        offset: Double,
        entity: AltarTableBlockEntity,
        tickDelta: Float,
        matrices: MatrixStack,
        vertexConsumers: VertexConsumerProvider,
        light: Int,
        overlay: Int,
        time: Float,
        slot: Int
    ) {
        matrices.push()
        matrices.translate(offx, 1.1 + offset, offz)
        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion((time + tickDelta) * 4))
        matrices.scale(0.5f, 0.5f, 0.5f)
        MinecraftClient.getInstance().itemRenderer.renderItem(
            entity.getSlot(slot),
            ModelTransformation.Mode.FIXED,
            light,
            overlay,
            matrices,
            vertexConsumers,
            0
        )
        matrices.pop()
    }

    companion object {
        var rotation = 0f
    }
}