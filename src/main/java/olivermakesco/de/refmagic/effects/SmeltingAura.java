package olivermakesco.de.refmagic.effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;

public class SmeltingAura extends StatusEffect {
    public SmeltingAura() {
        super(StatusEffectType.BENEFICIAL, 0xFF4400);
    }

    @Override
    public String getTranslationKey() {
        return "refmagic.effects.smelting";
    }
}
