package olivermakesco.de.refmagic.registry

import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.potion.Potion
import net.minecraft.potion.PotionUtil
import net.minecraft.potion.Potions
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import olivermakesco.de.refmagic.Mod
import olivermakesco.de.refmagic.augment.AugmentLoader
import olivermakesco.de.refmagic.effects.SmeltingAura
import olivermakesco.de.refmagic.item.NecklaceItem
import olivermakesco.de.refmagic.mixin.Invoker_BrewingRecipeRegistry

object RefinedMagicPotions {
    var potionsToAdd: MutableList<Potion> = ArrayList()
    var levitationPotion = Potion(StatusEffectInstance(StatusEffects.LEVITATION, 200))
    var longLevitationPotion = Potion(StatusEffectInstance(StatusEffects.LEVITATION, 400))
    @JvmField
    var smeltingAura: StatusEffect = SmeltingAura()
    var smeltingAuraPotion = Potion(StatusEffectInstance(smeltingAura, 2400, 0, false, true, true))
    var longSmeltingAuraPotion = Potion(StatusEffectInstance(smeltingAura, 4800, 0, false, true, true))
    fun register() {
        register(levitationPotion, Mod.id("levitation_potion"))
        register(Potions.THICK, RefinedMagicItems.kyriteShard, levitationPotion)
        register(longLevitationPotion, Mod.id("long_levitation_potion"))
        register(levitationPotion, Items.REDSTONE, longLevitationPotion)
        register(smeltingAura, Mod.id("smelting_aura"))
        register(smeltingAuraPotion, Mod.id("smelting_aura"))
        register(Potions.MUNDANE, RefinedMagicItems.topaz, smeltingAuraPotion)
        register(longSmeltingAuraPotion, Mod.id("long_smelting_aura"))
        register(smeltingAuraPotion, Items.REDSTONE, longSmeltingAuraPotion)
    }

    fun register(potion: StatusEffect, id: Identifier?) {
        Registry.register(Registry.STATUS_EFFECT, id, potion)
    }

    fun register(potion: Potion, id: Identifier?) {
        Registry.register(Registry.POTION, id, potion)
        potionsToAdd.add(potion)
    }

    fun register(`in`: Potion?, item: Item?, out: Potion?) {
        Invoker_BrewingRecipeRegistry.registerPotionRecipe(`in`, item, out)
    }

    @JvmStatic
    fun appendStacks(stacks: MutableList<ItemStack?>) {
        for ((id) in AugmentLoader.augments) {
            val necklace = RefinedMagicItems.baseNecklace.defaultStack
            NecklaceItem.setAugment(necklace, id)
            stacks.add(necklace)
        }
        for (potion in potionsToAdd) {
            stacks.add(PotionUtil.setPotion(Items.POTION.defaultStack, potion))
            stacks.add(PotionUtil.setPotion(Items.SPLASH_POTION.defaultStack, potion))
            stacks.add(PotionUtil.setPotion(Items.LINGERING_POTION.defaultStack, potion))
            stacks.add(PotionUtil.setPotion(Items.TIPPED_ARROW.defaultStack, potion))
        }
    }
}