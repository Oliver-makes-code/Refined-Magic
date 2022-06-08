package olivermakesco.de.refmagic.block

import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.block.PlantBlock
import net.minecraft.block.ShapeContext
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.math.BlockPos
import net.minecraft.util.shape.VoxelShape
import net.minecraft.util.shape.VoxelShapes
import net.minecraft.world.BlockView
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings

class EnliumGrowthBlock : PlantBlock(QuiltBlockSettings.copyOf(Blocks.GRASS).sounds(BlockSoundGroup.NETHER_SPROUTS)) {
    override fun canPlantOnTop(floor: BlockState, world: BlockView, pos: BlockPos): Boolean {
        return floor.isIn(EnliumBlock.enliumGrowable)
    }

    override fun getOutlineShape(
        state: BlockState,
        world: BlockView,
        pos: BlockPos,
        context: ShapeContext
    ): VoxelShape {
        return shape
    }

    companion object {
        val shape: VoxelShape = VoxelShapes.cuboid(
            (1 / 16f).toDouble(),
            0.0,
            (1 / 16f).toDouble(),
            (15 / 16f).toDouble(),
            (1 / 4f).toDouble(),
            (15 / 16f).toDouble()
        )
    }
}