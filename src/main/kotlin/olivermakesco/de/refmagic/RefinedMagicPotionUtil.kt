package olivermakesco.de.refmagic

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Items

object RefinedMagicPotionUtil {
    const val cooldown = 20
    fun setCooldown(player: PlayerEntity, cooldown: Int) {
        val manager = player.itemCooldownManager
        manager[Items.POTION] = cooldown
        manager[Items.SPLASH_POTION] = cooldown
        manager[Items.LINGERING_POTION] = cooldown
    }

    @JvmStatic
    fun setCooldown(player: PlayerEntity) {
        setCooldown(player, cooldown)
    }
}