package olivermakesco.de.refmagic.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import olivermakesco.de.refmagic.material.WitheriteArmorMaterial;

public class WitheriteArmorItem extends ArmorItem {
    public WitheriteArmorItem(EquipmentSlot equipmentSlot, Settings settings) {
        super(WitheriteArmorMaterial.instance, equipmentSlot, settings);
    }
}
