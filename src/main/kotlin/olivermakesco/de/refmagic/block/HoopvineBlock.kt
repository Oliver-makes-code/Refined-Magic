package olivermakesco.de.refmagic.block

import net.minecraft.block.*
import net.minecraft.entity.ai.pathing.NavigationType
import net.minecraft.item.ItemPlacementContext
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.state.StateManager
import net.minecraft.state.property.BooleanProperty
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.util.random.RandomGenerator
import net.minecraft.util.shape.VoxelShape
import net.minecraft.util.shape.VoxelShapes
import net.minecraft.world.BlockView
import net.minecraft.world.StructureWorldAccess
import net.minecraft.world.WorldAccess
import net.minecraft.world.WorldView
import olivermakesco.de.refmagic.registry.RefinedMagicBlocks
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings
import java.util.*

class HoopvineBlock : PlantBlock(
    QuiltBlockSettings
        .copyOf(Blocks.GRASS)
        .material(Material.PLANT)
        .sounds(BlockSoundGroup.NETHER_SPROUTS)
) {
    init {
        defaultState = getStateManager().defaultState.with(top, true)
    }

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        builder.add(top)
    }

    private fun canPlantOnTop(floor: BlockState): Boolean {
        return floor.isIn(EnliumBlock.enliumGrowable) || floor.block === this
    }

    override fun getStateForNeighborUpdate(
        state: BlockState,
        direction: Direction,
        neighborState: BlockState,
        world: WorldAccess,
        pos: BlockPos,
        neighborPos: BlockPos
    ): BlockState {
        if (!state.canPlaceAt(world, pos)) return Blocks.AIR.defaultState
        return if (world.getBlockState(pos.up()).block !== this) state.with(
            top,
            true
        ) else state.with(top, false)
    }

    override fun getPlacementState(ctx: ItemPlacementContext): BlockState? {
        val state = super.getPlacementState(ctx)
        return if (ctx.world.getBlockState(ctx.blockPos.up()).block !== this) state!!.with(top, true) else state!!.with(
            top,
            false
        )
    }

    override fun canPlaceAt(state: BlockState, world: WorldView, pos: BlockPos): Boolean {
        return canPlantOnTop(world.getBlockState(pos.down()))
    }

    override fun isTranslucent(state: BlockState, world: BlockView, pos: BlockPos): Boolean {
        return state.fluidState.isEmpty
    }

    override fun canPathfindThrough(state: BlockState, world: BlockView, pos: BlockPos, type: NavigationType): Boolean {
        return type == NavigationType.AIR && !collidable || super.canPathfindThrough(state, world, pos, type)
    }

    override fun getOutlineShape(
        state: BlockState,
        world: BlockView,
        pos: BlockPos,
        context: ShapeContext
    ): VoxelShape {
        return if (state.get(top)) topShape else bottomShape
    }

    companion object {
        val top: BooleanProperty = BooleanProperty.of("top")
        val topShape: VoxelShape = VoxelShapes.cuboid(
            (6 / 16f).toDouble(),
            0.0,
            (6 / 16f).toDouble(),
            (10 / 16f).toDouble(),
            (15 / 16f).toDouble(),
            (10 / 16f).toDouble()
        )
        val bottomShape: VoxelShape = VoxelShapes.cuboid(
            (6 / 16f).toDouble(),
            0.0,
            (6 / 16f).toDouble(),
            (10 / 16f).toDouble(),
            1.0,
            (10 / 16f).toDouble()
        )

        fun grow(world: StructureWorldAccess, pos: BlockPos, random: RandomGenerator) {
            val height = random.nextInt(5)
            var npos = pos
            for (i in 0 until height) {
                if (!world.getBlockState(npos).isAir) break
                world.setBlockState(npos, RefinedMagicBlocks.hoopvine.defaultState, NOTIFY_ALL)
                if (i > 0) world.setBlockState(
                    npos.down(),
                    RefinedMagicBlocks.hoopvine.defaultState.with(top, false),
                    NOTIFY_ALL
                )
                npos = npos.up()
            }
        }
    }
}