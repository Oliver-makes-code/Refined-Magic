package olivermakesco.de.refmagic.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import olivermakesco.de.refmagic.item.DimensionalTotemItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public abstract class Mixin_ServerPlayerEntity extends PlayerEntity {
    public Mixin_ServerPlayerEntity(World world, BlockPos blockPos, float f, GameProfile gameProfile) {
        super(world, blockPos, f, gameProfile);
    }

    @Inject(at = @At("RETURN"), method = "copyFrom")
    private void copyInventory(ServerPlayerEntity oldPlayer, boolean alive, CallbackInfo ci) {
        var inv = oldPlayer.getInventory();
        if (oldPlayer.getStackInHand(Hand.MAIN_HAND).getItem() instanceof DimensionalTotemItem) {
            oldPlayer.setStackInHand(Hand.MAIN_HAND, ItemStack.EMPTY);
            world.sendEntityStatus(this, (byte)35);
            getInventory().clone(inv);
        } else if (oldPlayer.getStackInHand(Hand.OFF_HAND).getItem() instanceof DimensionalTotemItem) {
            oldPlayer.setStackInHand(Hand.OFF_HAND, ItemStack.EMPTY);
            world.sendEntityStatus(this, (byte)35);
            getInventory().clone(inv);
        }
    }
}
