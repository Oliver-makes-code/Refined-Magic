package olivermakesco.de.refmagic.effects

import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectType

class SmeltingAura : StatusEffect(StatusEffectType.BENEFICIAL, 0xFF4400) {
    override fun getTranslationKey(): String {
        return "refmagic.effects.smelting"
    }
}