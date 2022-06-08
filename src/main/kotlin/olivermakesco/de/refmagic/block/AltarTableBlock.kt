package olivermakesco.de.refmagic.block

import net.minecraft.block.BlockRenderType
import net.minecraft.block.BlockState
import net.minecraft.block.BlockWithEntity
import net.minecraft.block.ShapeContext
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.ItemEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.particle.ParticleTypes
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.server.world.ServerWorld
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.util.shape.VoxelShape
import net.minecraft.util.shape.VoxelShapes
import net.minecraft.world.BlockView
import net.minecraft.world.World
import olivermakesco.de.refmagic.block.entity.AltarTableBlockEntity
import olivermakesco.de.refmagic.recipe.AltarRecipe.Companion.getTypeInstance

class AltarTableBlock(settings: Settings?) : BlockWithEntity(settings) {
    override fun createBlockEntity(pos: BlockPos, state: BlockState): BlockEntity? {
        return AltarTableBlockEntity(pos, state)
    }

    override fun getRenderType(state: BlockState): BlockRenderType {
        return BlockRenderType.MODEL
    }

    override fun isTranslucent(state: BlockState, world: BlockView, pos: BlockPos): Boolean {
        return false
    }

    override fun getOutlineShape(
        state: BlockState,
        world: BlockView,
        pos: BlockPos,
        context: ShapeContext
    ): VoxelShape {
        return VoxelShapes.union(
            VoxelShapes.cuboid(0.0, 0.5625, 0.0, 1.0, 0.75, 1.0),
            VoxelShapes.cuboid(0.125, 0.0, 0.125, 0.3125, 0.5625, 0.3125),
            VoxelShapes.cuboid(0.125, 0.0, 0.6875, 0.3125, 0.5625, 0.875),
            VoxelShapes.cuboid(0.6875, 0.0, 0.125, 0.875, 0.5625, 0.3125),
            VoxelShapes.cuboid(0.6875, 0.0, 0.6875, 0.875, 0.5625, 0.875)
        )
    }

    override fun getCollisionShape(
        state: BlockState,
        world: BlockView,
        pos: BlockPos,
        context: ShapeContext
    ): VoxelShape {
        return getOutlineShape(state, world, pos, context)
    }

    override fun onUse(
        state: BlockState,
        world: World,
        pos: BlockPos,
        player: PlayerEntity,
        hand: Hand,
        hit: BlockHitResult
    ): ActionResult {
        if (world.isClient) return ActionResult.SUCCESS
        val serverWorld = world as ServerWorld
        if (player.isSneaking) return ActionResult.PASS
        val entity = (world.getBlockEntity(pos) as AltarTableBlockEntity?)!!
        if (!player.getStackInHand(hand).isEmpty && entity.isFull) {
            entity.catalyst = player.getStackInHand(hand).copy()
            val optional = world.getRecipeManager().getFirstMatch(getTypeInstance(), entity, world)
            entity.catalyst = null
            if (optional.isPresent) {
                val (_, _, _, result) = optional.get()
                player.getStackInHand(hand).decrement(1)
                player.inventory.offerOrDrop(result.copy())
                entity.clear()
                update(pos, serverWorld, player as ServerPlayerEntity)
                world.playSound(null, pos, SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.BLOCKS, 10f, 0f)
                serverWorld.spawnParticles(
                    ParticleTypes.EXPLOSION,
                    pos.x.toDouble(),
                    pos.y + 0.5,
                    pos.z.toDouble(),
                    15,
                    1.0,
                    1.0,
                    1.0,
                    1.0
                )
                return ActionResult.SUCCESS
            }
        }
        var x = hit.pos.x % 1
        x += 1.0
        x %= 1.0
        var z = hit.pos.z % 1
        z += 1.0
        z %= 1.0
        val a = if (x < 0.5) 0 else 1
        val b = if (z < 0.5) 0 else 2
        val c = a + b
        if (entity.getSlot(c) == ItemStack.EMPTY) {
            if (player.getStackInHand(hand).isEmpty) return ActionResult.PASS
            val next = player.getStackInHand(hand).copy()
            next.count = 1
            player.getStackInHand(hand).decrement(1)
            entity.setSlot(c, next)
            update(pos, serverWorld, player as ServerPlayerEntity)
            world.playSound(null, pos, SoundEvents.BLOCK_END_PORTAL_FRAME_FILL, SoundCategory.BLOCKS, 10f, 0f)
            return ActionResult.SUCCESS
        }
        var stackToSet = ItemStack.EMPTY
        if (!player.getStackInHand(hand).isEmpty && player.getStackInHand(hand).item !== entity.getSlot(c).item) {
            stackToSet = player.getStackInHand(hand).copy()
            stackToSet.count = 1
            player.getStackInHand(hand).decrement(1)
        }
        val next = entity.getSlot(c)
        player.inventory.insertStack(next)
        entity.setSlot(c, stackToSet)
        update(pos, serverWorld, player as ServerPlayerEntity)
        world.playSound(null, pos, SoundEvents.BLOCK_END_PORTAL_FRAME_FILL, SoundCategory.BLOCKS, 10f, 0f)
        return ActionResult.SUCCESS
    }

    private fun update(pos: BlockPos?, world: ServerWorld, entity: ServerPlayerEntity) {
        world.chunkManager.markForUpdate(pos)
        entity.inventory.markDirty()
    }

    override fun onBreak(world: World, pos: BlockPos, state: BlockState, player: PlayerEntity) {
        super.onBreak(world, pos, state, player)
        val entity = world.getBlockEntity(pos) as AltarTableBlockEntity?
        val itemEntity0 = ItemEntity(world, pos.x.toDouble(), pos.y.toDouble(), pos.z.toDouble(), entity!!.getSlot(0))
        world.spawnEntity(itemEntity0)
        val itemEntity1 = ItemEntity(world, pos.x.toDouble(), pos.y.toDouble(), pos.z.toDouble(), entity.getSlot(1))
        world.spawnEntity(itemEntity1)
        val itemEntity2 = ItemEntity(world, pos.x.toDouble(), pos.y.toDouble(), pos.z.toDouble(), entity.getSlot(2))
        world.spawnEntity(itemEntity2)
        val itemEntity3 = ItemEntity(world, pos.x.toDouble(), pos.y.toDouble(), pos.z.toDouble(), entity.getSlot(3))
        world.spawnEntity(itemEntity3)
    }
}