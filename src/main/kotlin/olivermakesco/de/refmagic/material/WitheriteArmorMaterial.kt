package olivermakesco.de.refmagic.material

import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.ArmorMaterial
import net.minecraft.item.ArmorMaterials
import net.minecraft.recipe.Ingredient
import net.minecraft.sound.SoundEvent
import olivermakesco.de.refmagic.registry.RefinedMagicItems

class WitheriteArmorMaterial : ArmorMaterial {
    override fun getDurability(slot: EquipmentSlot): Int {
        return ArmorMaterials.NETHERITE.getDurability(slot)
    }

    override fun getProtectionAmount(slot: EquipmentSlot): Int {
        return ArmorMaterials.NETHERITE.getProtectionAmount(slot)
    }

    override fun getEnchantability(): Int {
        return ArmorMaterials.NETHERITE.enchantability
    }

    override fun getEquipSound(): SoundEvent {
        return ArmorMaterials.NETHERITE.equipSound
    }

    override fun getRepairIngredient(): Ingredient {
        return Ingredient.ofItems(RefinedMagicItems.witheredHeart)
    }

    override fun getName(): String {
        return "witherite"
    }

    override fun getToughness(): Float {
        return ArmorMaterials.NETHERITE.toughness
    }

    override fun getKnockbackResistance(): Float {
        return ArmorMaterials.NETHERITE.knockbackResistance
    }

    companion object {
        var instance = WitheriteArmorMaterial()
    }
}