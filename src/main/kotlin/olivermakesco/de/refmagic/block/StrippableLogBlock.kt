package olivermakesco.de.refmagic.block

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.MapColor
import net.minecraft.block.PillarBlock
import net.minecraft.entity.EquipmentSlot
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.MiningToolItem
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import java.util.function.Supplier

class StrippableLogBlock(
    private val stripped: Supplier<Block>?,
    top: MapColor?,
    settings: Settings?
) : PillarBlock(settings) {
    override fun onUse(
        state: BlockState,
        world: World,
        pos: BlockPos,
        player: PlayerEntity,
        hand: Hand,
        hit: BlockHitResult
    ): ActionResult {
        val heldStack =
            player.getEquippedStack(if (hand == Hand.MAIN_HAND) EquipmentSlot.MAINHAND else EquipmentSlot.OFFHAND)
        if (heldStack.isEmpty) {
            return ActionResult.FAIL
        }
        val held = heldStack.item as? MiningToolItem ?: return ActionResult.FAIL
        if (stripped != null && (held.getMiningSpeedMultiplier(heldStack, state) > 1.0f)) {
            world.playSound(player, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0f, 1.0f)
            if (!world.isClient) {
                val target = stripped.get().defaultState.with(AXIS, state.get(AXIS))
                world.setBlockState(pos, target)
                heldStack.damage(
                    1, player
                ) { consumedPlayer: PlayerEntity ->
                    consumedPlayer.sendToolBreakStatus(
                        hand
                    )
                }
            }
            return ActionResult.SUCCESS
        }
        return ActionResult.FAIL
    }
}
