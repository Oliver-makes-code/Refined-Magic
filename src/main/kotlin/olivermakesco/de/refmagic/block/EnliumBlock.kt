package olivermakesco.de.refmagic.block

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.block.Fertilizable
import net.minecraft.server.world.ServerWorld
import net.minecraft.tag.TagKey
import net.minecraft.util.math.BlockPos
import net.minecraft.util.registry.Registry
import net.minecraft.world.BlockView
import net.minecraft.world.World
import net.minecraft.world.WorldView
import olivermakesco.de.refmagic.Mod
import olivermakesco.de.refmagic.registry.RefinedMagicWorldgen
import java.util.*

class EnliumBlock(settings: Settings?) : Block(settings), Fertilizable {
    override fun randomTick(state: BlockState, world: ServerWorld, pos: BlockPos, random: Random) {
        if (solid(world, pos)) world.setBlockState(pos, Blocks.END_STONE.defaultState)
    }

    override fun hasRandomTicks(state: BlockState): Boolean {
        return true
    }

    override fun grow(world: ServerWorld, random: Random, pos: BlockPos, state: BlockState) {
        RefinedMagicWorldgen.enliumPatch.value().generate(world, world.chunkManager.chunkGenerator, random, pos)
    }

    override fun isFertilizable(world: BlockView, pos: BlockPos, state: BlockState, isClient: Boolean): Boolean {
        return world.getBlockState(pos.up()).isAir
    }

    override fun canGrow(world: World, random: Random, pos: BlockPos, state: BlockState): Boolean {
        return true
    }

    companion object {
        var enliumGrowable: TagKey<Block> = TagKey.of(Registry.BLOCK_KEY, Mod.id("enlium_growable"))
        fun solid(world: WorldView, pos: BlockPos): Boolean {
            return world.getBlockState(pos.up()).isSolidBlock(world, pos.up())
        }
    }
}