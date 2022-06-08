package olivermakesco.de.refmagic.material;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import olivermakesco.de.refmagic.registry.RefinedMagicItems;

public class WitheriteArmorMaterial implements ArmorMaterial {
    public static WitheriteArmorMaterial instance = new WitheriteArmorMaterial();

    @Override
    public int getDurability(EquipmentSlot slot) {
        return ArmorMaterials.NETHERITE.getDurability(slot);
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return ArmorMaterials.NETHERITE.getProtectionAmount(slot);
    }

    @Override
    public int getEnchantability() {
        return ArmorMaterials.NETHERITE.getEnchantability();
    }

    @Override
    public SoundEvent getEquipSound() {
        return ArmorMaterials.NETHERITE.getEquipSound();
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(RefinedMagicItems.witheredHeart);
    }

    @Override
    public String getName() {
        return "witherite";
    }

    @Override
    public float getToughness() {
        return ArmorMaterials.NETHERITE.getToughness();
    }

    @Override
    public float getKnockbackResistance() {
        return ArmorMaterials.NETHERITE.getKnockbackResistance();
    }
}
