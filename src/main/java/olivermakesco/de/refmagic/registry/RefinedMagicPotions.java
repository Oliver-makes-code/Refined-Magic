package olivermakesco.de.refmagic.registry;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import olivermakesco.de.refmagic.Mod;
import olivermakesco.de.refmagic.augment.AugmentLoader;
import olivermakesco.de.refmagic.effects.SmeltingAura;
import olivermakesco.de.refmagic.item.NecklaceItem;
import olivermakesco.de.refmagic.mixin.Invoker_BrewingRecipeRegistry;

import java.util.ArrayList;
import java.util.List;

public class RefinedMagicPotions {
    public static List<Potion> potionsToAdd = new ArrayList<>();

    public static Potion levitationPotion = new Potion(new StatusEffectInstance(StatusEffects.LEVITATION,200));
    public static Potion longLevitationPotion = new Potion(new StatusEffectInstance(StatusEffects.LEVITATION,400));

    public static StatusEffect smeltingAura = new SmeltingAura();
    public static Potion smeltingAuraPotion = new Potion(new StatusEffectInstance(smeltingAura, 2400, 0, false, true, true));
    public static Potion longSmeltingAuraPotion = new Potion(new StatusEffectInstance(smeltingAura, 4800, 0, false, true, true));

    public static void register() {
        register(levitationPotion, Mod.id("levitation_potion"));
        register(Potions.THICK, RefinedMagicItems.kyriteShard,levitationPotion);

        register(longLevitationPotion, Mod.id("long_levitation_potion"));
        register(levitationPotion, Items.REDSTONE, longLevitationPotion);

        register(smeltingAura, Mod.id("smelting_aura"));
        register(smeltingAuraPotion, Mod.id("smelting_aura"));
        register(Potions.MUNDANE, RefinedMagicItems.topaz, smeltingAuraPotion);

        register(longSmeltingAuraPotion, Mod.id("long_smelting_aura"));
        register(smeltingAuraPotion, Items.REDSTONE, longSmeltingAuraPotion);
    }


    public static void register(StatusEffect potion, Identifier id) {
        Registry.register(Registry.STATUS_EFFECT, id, potion);
    }
    public static void register(Potion potion, Identifier id) {
        Registry.register(Registry.POTION, id, potion);
        potionsToAdd.add(potion);
    }
    public static void register(Potion in, Item item, Potion out) {
        Invoker_BrewingRecipeRegistry.registerPotionRecipe(in,item,out);
    }

    public static void appendStacks(List<ItemStack> stacks) {
        for (var entry : AugmentLoader.augments.entrySet()) {
            var id = entry.getKey();
            var necklace = RefinedMagicItems.baseNecklace.getDefaultStack();
            NecklaceItem.setAugment(necklace, id);
            stacks.add(necklace);
        }
        for (var potion : potionsToAdd) {
            stacks.add(PotionUtil.setPotion(Items.POTION.getDefaultStack(), potion));
            stacks.add(PotionUtil.setPotion(Items.SPLASH_POTION.getDefaultStack(), potion));
            stacks.add(PotionUtil.setPotion(Items.LINGERING_POTION.getDefaultStack(), potion));
            stacks.add(PotionUtil.setPotion(Items.TIPPED_ARROW.getDefaultStack(), potion));
        }
    }
}
