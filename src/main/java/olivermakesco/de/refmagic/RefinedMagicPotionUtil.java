package olivermakesco.de.refmagic;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;

public class RefinedMagicPotionUtil {
    public static final int cooldown = 20;
    public static void setCooldown(PlayerEntity player, int cooldown) {
        var manager = player.getItemCooldownManager();
        manager.set(Items.POTION, cooldown);
        manager.set(Items.SPLASH_POTION, cooldown);
        manager.set(Items.LINGERING_POTION, cooldown);
    }

    public static void setCooldown(PlayerEntity player) {
        setCooldown(player,cooldown);
    }
}
