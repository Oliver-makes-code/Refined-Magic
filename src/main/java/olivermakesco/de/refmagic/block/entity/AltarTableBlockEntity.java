package olivermakesco.de.refmagic.block.entity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.math.BlockPos;
import olivermakesco.de.refmagic.registry.RefinedMagicBlockEntities;

import javax.annotation.Nullable;

public class AltarTableBlockEntity extends BlockEntity implements Inventory {

    public ItemStack catalyst = null;
    public ItemStack[] slots = {ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY};

    public AltarTableBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(RefinedMagicBlockEntities.altarTableBlockEntity, blockPos, blockState);
    }

    public ItemStack getSlot(int slot) {
        return slots[slot];
    }

    public void setSlot(int slot, ItemStack stack) {
        slots[slot] = stack;
        markDirty();
    }

    public boolean isFull() {
        for (ItemStack stack : slots) {
            if (stack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void writeNbt(NbtCompound tag) {
        var list = new NbtList();
        for (var i = 0; i < 4; i++) {
            var nbt = new NbtCompound();
            getSlot(i).writeNbt(nbt);
            list.add(nbt);
        }
        tag.put("Items", list);
        super.writeNbt(tag);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        var list = nbt.getList("Items",10);
        for (var i = 0; i < 4; i++) {
            setSlot(i, ItemStack.fromNbt(list.getCompound(i)));
        }
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.of(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return toNbt();
    }

    @Override
    public int size() {
        return 4;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public ItemStack getStack(int slot) {
        return getSlot(slot);
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        return null;
    }

    @Override
    public ItemStack removeStack(int slot) {
        return null;
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        setSlot(slot,stack);
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size(); i++) {
            setSlot(i, ItemStack.EMPTY);
        }
    }
}
