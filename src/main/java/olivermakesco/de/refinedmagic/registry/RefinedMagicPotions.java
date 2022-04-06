package olivermakesco.de.refinedmagic.registry;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import olivermakesco.de.refinedmagic.Mod;
import olivermakesco.de.refinedmagic.mixin.invoker.BrewingRecipeRegistryInvoker;

public class RefinedMagicPotions {
    static Potion levitationPotion = new Potion(new StatusEffectInstance(StatusEffects.LEVITATION,200));
    static Potion longLevitationPotion = new Potion(new StatusEffectInstance(StatusEffects.LEVITATION,400));

    public static void register() {
        register(levitationPotion, Mod.id("levitation_potion"));
        register(Potions.THICK,RefinedMagicItems.kyriteShard,levitationPotion);

        register(longLevitationPotion, Mod.id("long_levitation_potion"));
        register(levitationPotion, Items.REDSTONE, longLevitationPotion);
    }

    public static void register(Potion potion, Identifier id) {
        Registry.register(Registry.POTION, id, potion);
    }
    public static void register(Potion in, Item item, Potion out) {
        BrewingRecipeRegistryInvoker.registerPotionRecipe(in,item,out);
    }
}
