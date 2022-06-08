package olivermakesco.de.refmagic.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import olivermakesco.de.refmagic.item.DimensionalTotemItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class Mixin_PlayerEntity extends LivingEntity {

    protected Mixin_PlayerEntity(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Shadow public abstract PlayerInventory getInventory();

    @Shadow protected abstract void vanishCursedItems();

    @Inject(at = @At("HEAD"), method = "dropInventory", cancellable = true)
    private void dropInjection(CallbackInfo ci) {
        if (getStackInHand(Hand.MAIN_HAND).getItem() instanceof DimensionalTotemItem) {
            vanishCursedItems();
            world.sendEntityStatus(this, (byte)35);
            ci.cancel();
        } else if (getStackInHand(Hand.OFF_HAND).getItem() instanceof DimensionalTotemItem) {
            vanishCursedItems();
            world.sendEntityStatus(this, (byte)35);
            ci.cancel();
        }
    }
}
