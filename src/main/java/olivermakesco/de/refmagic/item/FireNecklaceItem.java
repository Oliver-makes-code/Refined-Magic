package olivermakesco.de.refmagic.item;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.SlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectUtil;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potions;
import net.minecraft.server.command.EffectCommand;
import olivermakesco.de.refmagic.Mod;

public class FireNecklaceItem extends BaseNecklaceItem {
    public FireNecklaceItem(Settings settings) {
        super(settings);
    }

    @Override
    public StatusEffect getEffect() {
        return StatusEffects.FIRE_RESISTANCE;
    }
}
