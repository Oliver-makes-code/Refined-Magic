package olivermakesco.de.refinedmagic;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;

public class PotionUtil {
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
