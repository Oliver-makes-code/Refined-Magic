package olivermakesco.de.potiontweaks.registry;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import olivermakesco.de.potiontweaks.Mod;
import olivermakesco.de.potiontweaks.effects.SmeltingAura;
import olivermakesco.de.potiontweaks.mixin.invoker.BrewingRecipeRegistryInvoker;

import java.util.ArrayList;
import java.util.List;

public class Potions {
    public static List<Potion> potionsToAdd = new ArrayList<>();

    public static Potion levitationPotion = new Potion(new StatusEffectInstance(StatusEffects.LEVITATION,200));
    public static Potion longLevitationPotion = new Potion(new StatusEffectInstance(StatusEffects.LEVITATION,400));

    public static StatusEffect smeltingAura = new SmeltingAura();
    public static Potion smeltingAuraPotion = new Potion(new StatusEffectInstance(smeltingAura, 2400, 0, false, true, true));
    public static Potion longSmeltingAuraPotion = new Potion(new StatusEffectInstance(smeltingAura, 4800, 0, false, true, true));

    public static void register() {
        register(levitationPotion, Mod.id("levitation_potion"));
        register(net.minecraft.potion.Potions.THICK, Items.kyriteShard,levitationPotion);

        register(longLevitationPotion, Mod.id("long_levitation_potion"));
        register(levitationPotion, net.minecraft.item.Items.REDSTONE, longLevitationPotion);

        register(smeltingAuraPotion, Mod.id("smelting_aura"));
        register(net.minecraft.potion.Potions.MUNDANE, Items.topaz, smeltingAuraPotion);

        register(longSmeltingAuraPotion, Mod.id("long_smelting_aura"));
        register(smeltingAuraPotion, net.minecraft.item.Items.REDSTONE, longSmeltingAuraPotion);
    }

    public static void register(Potion potion, Identifier id) {
        Registry.register(Registry.POTION, id, potion);
        potionsToAdd.add(potion);
    }
    public static void register(Potion in, Item item, Potion out) {
        BrewingRecipeRegistryInvoker.registerPotionRecipe(in,item,out);
    }

    public static void appendStacks(List<ItemStack> stacks) {
        for (var potion : potionsToAdd) {
            stacks.add(net.minecraft.potion.PotionUtil.setPotion(net.minecraft.item.Items.POTION.getDefaultStack(), potion));
            stacks.add(net.minecraft.potion.PotionUtil.setPotion(net.minecraft.item.Items.SPLASH_POTION.getDefaultStack(), potion));
            stacks.add(net.minecraft.potion.PotionUtil.setPotion(net.minecraft.item.Items.LINGERING_POTION.getDefaultStack(), potion));
            stacks.add(net.minecraft.potion.PotionUtil.setPotion(net.minecraft.item.Items.TIPPED_ARROW.getDefaultStack(), potion));
        }
    }
}
