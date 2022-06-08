package olivermakesco.de.refmagic.block.entity

import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.inventory.Inventory
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import net.minecraft.nbt.NbtList
import net.minecraft.network.Packet
import net.minecraft.network.listener.ClientPlayPacketListener
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket
import net.minecraft.util.math.BlockPos
import olivermakesco.de.refmagic.registry.RefinedMagicBlockEntities

class AltarTableBlockEntity(blockPos: BlockPos?, blockState: BlockState?) :
    BlockEntity(RefinedMagicBlockEntities.altarTableBlockEntity, blockPos, blockState), Inventory {
    var catalyst: ItemStack? = null
    var slots = arrayOf(ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY)
    fun getSlot(slot: Int): ItemStack {
        return slots[slot]
    }

    fun setSlot(slot: Int, stack: ItemStack) {
        slots[slot] = stack
        markDirty()
    }

    val isFull: Boolean
        get() {
            for (stack in slots) {
                if (stack.isEmpty) {
                    return false
                }
            }
            return true
        }

    public override fun writeNbt(tag: NbtCompound) {
        val list = NbtList()
        for (i in 0..3) {
            val nbt = NbtCompound()
            getSlot(i).writeNbt(nbt)
            list.add(nbt)
        }
        tag.put("Items", list)
        super.writeNbt(tag)
    }

    override fun readNbt(nbt: NbtCompound) {
        super.readNbt(nbt)
        val list = nbt.getList("Items", 10)
        for (i in 0..3) {
            setSlot(i, ItemStack.fromNbt(list.getCompound(i)))
        }
    }

    override fun toUpdatePacket(): Packet<ClientPlayPacketListener>? {
        return BlockEntityUpdateS2CPacket.of(this)
    }

    override fun toInitialChunkDataNbt(): NbtCompound {
        return toNbt()
    }

    override fun size(): Int {
        return 4
    }

    override fun isEmpty(): Boolean {
        return false
    }

    override fun getStack(slot: Int): ItemStack {
        return getSlot(slot)
    }

    override fun removeStack(slot: Int, amount: Int): ItemStack? {
        return null
    }

    override fun removeStack(slot: Int): ItemStack? {
        return null
    }

    override fun setStack(slot: Int, stack: ItemStack) {
        setSlot(slot, stack)
    }

    override fun canPlayerUse(player: PlayerEntity): Boolean {
        return false
    }

    override fun clear() {
        for (i in 0 until size()) {
            setSlot(i, ItemStack.EMPTY)
        }
    }
}