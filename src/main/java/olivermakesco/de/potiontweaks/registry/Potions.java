package olivermakesco.de.potiontweaks.registry;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import olivermakesco.de.potiontweaks.Mod;
import olivermakesco.de.potiontweaks.mixin.invoker.BrewingRecipeRegistryInvoker;

import java.util.ArrayList;
import java.util.List;

public class Potions {
    static List<Potion> potionsToAdd = new ArrayList<>();

    static Potion levitationPotion = new Potion(new StatusEffectInstance(StatusEffects.LEVITATION,200));
    static Potion longLevitationPotion = new Potion(new StatusEffectInstance(StatusEffects.LEVITATION,400));

    public static void register() {
        register(levitationPotion, Mod.id("levitation_potion"));
        register(net.minecraft.potion.Potions.THICK, Items.kyriteShard,levitationPotion);

        register(longLevitationPotion, Mod.id("long_levitation_potion"));
        register(levitationPotion, net.minecraft.item.Items.REDSTONE, longLevitationPotion);
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
