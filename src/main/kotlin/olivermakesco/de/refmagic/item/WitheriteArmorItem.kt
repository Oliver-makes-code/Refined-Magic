package olivermakesco.de.refmagic.item

import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.ArmorItem
import olivermakesco.de.refmagic.material.WitheriteArmorMaterial

class WitheriteArmorItem(equipmentSlot: EquipmentSlot?, settings: Settings?) :
    ArmorItem(WitheriteArmorMaterial.instance, equipmentSlot, settings)