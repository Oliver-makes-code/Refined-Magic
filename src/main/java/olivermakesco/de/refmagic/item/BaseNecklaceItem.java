package olivermakesco.de.refmagic.item;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;

public class BaseNecklaceItem extends TrinketItem {
    public BaseNecklaceItem(Settings settings) {
        super(settings);
    }

    public StatusEffect getEffect() {
        return null;
    }

    @Override
    public boolean isFireproof() {
        return true;
    }

    int cooldown = 0;

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        var effect = getEffect();
        if (effect == null) return;
        cooldown++;
        cooldown %= 20;
        if (cooldown == 0) {
            var instance = new StatusEffectInstance(effect, 80);
            entity.addStatusEffect(instance);
        }
    }
}
