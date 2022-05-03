package olivermakesco.de.refmagic.augment;

import net.minecraft.entity.effect.StatusEffect;

import java.util.List;

public interface IAugment {
    int getColor();
    List<StatusEffect> getStatusEffects();
}
