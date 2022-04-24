package olivermakesco.de.refmagic.item;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;

public class AquaNecklaceItem extends BaseNecklaceItem {
    public AquaNecklaceItem(Settings settings) {
        super(settings);
    }

    @Override
    public StatusEffect getEffect() {
        return StatusEffects.WATER_BREATHING;
    }
}
