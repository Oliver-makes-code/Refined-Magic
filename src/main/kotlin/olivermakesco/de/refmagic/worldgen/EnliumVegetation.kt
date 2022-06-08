package olivermakesco.de.refmagic.worldgen

import com.mojang.serialization.Codec
import net.minecraft.block.BlockState
import net.minecraft.block.TallPlantBlock
import net.minecraft.util.math.BlockPos
import net.minecraft.world.StructureWorldAccess
import net.minecraft.world.gen.feature.SimpleBlockFeature
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig
import net.minecraft.world.gen.feature.util.FeatureContext
import olivermakesco.de.refmagic.block.HoopvineBlock

class EnliumVegetation(codec: Codec<SimpleBlockFeatureConfig?>?) : SimpleBlockFeature(codec) {
    override fun place(context: FeatureContext<SimpleBlockFeatureConfig>): Boolean {
        val simpleBlockFeatureConfig = context.config
        val structureWorldAccess = context.world
        val blockPos = context.origin
        val blockState = simpleBlockFeatureConfig.toPlace().getBlockState(context.random, blockPos)
        return tryPlace(blockState, structureWorldAccess, blockPos, context)
    }

    private fun tryPlace(
        blockState: BlockState,
        structureWorldAccess: StructureWorldAccess,
        blockPos: BlockPos,
        context: FeatureContext<*>
    ): Boolean {
        return if (blockState.canPlaceAt(structureWorldAccess, blockPos)) {
            if (blockState.block is TallPlantBlock) {
                if (!structureWorldAccess.isAir(blockPos.up())) {
                    return false
                }
                TallPlantBlock.placeAt(structureWorldAccess, blockState, blockPos, 2)
            } else if (blockState.block is HoopvineBlock) {
                HoopvineBlock.grow(structureWorldAccess, blockPos, context.random)
            } else {
                structureWorldAccess.setBlockState(blockPos, blockState, 2)
            }
            true
        } else {
            false
        }
    }
}