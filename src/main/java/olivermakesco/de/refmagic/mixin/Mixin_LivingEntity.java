package olivermakesco.de.refmagic.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import olivermakesco.de.refmagic.item.WitheriteArmorItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class Mixin_LivingEntity {
    @Shadow public abstract Iterable<ItemStack> getArmorItems();

    @Shadow public abstract boolean addStatusEffect(StatusEffectInstance effect);


    @Unique private int tickDelta = 0;

    @Inject(at = @At("HEAD"), method = "baseTick")
    private void addEffectsIfArmorApplied(CallbackInfo ci) {
        tickDelta++;
        tickDelta %= 40;
        if (tickDelta != 0) return;
        var armors = this.getArmorItems();
        for (var armor : armors) {
            if (!(armor.getItem() instanceof WitheriteArmorItem witheriteArmor)) continue;
            switch (witheriteArmor.getSlotType()) {
                case HEAD -> addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 80));
                case CHEST -> addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 80));
                case LEGS -> addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 80));
                case FEET -> addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, 80, 2));
            }
        }
    }
}
