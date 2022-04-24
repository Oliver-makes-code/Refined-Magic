package olivermakesco.de.refmagic.registry;

import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.registry.SimpleRegistry;
import olivermakesco.de.refmagic.Mod;
import olivermakesco.de.refmagic.recipe.AltarRecipe;
import olivermakesco.de.refmagic.recipe.serializer.AlterRecipeSerializer;

import java.util.HashMap;
import java.util.Map;

public class RefinedMagicRecipes {

    public static RecipeSerializer<AltarRecipe> altarRecipeSerializer;
    public static Map<Identifier, AltarRecipe> altarRecipes = new HashMap<>();

    public static void register() {
        altarRecipeSerializer = Registry.register(Registry.RECIPE_SERIALIZER, Mod.id("alter_recipe"), new AlterRecipeSerializer());
        altarRecipes.put(Mod.id("dimensional_totem_recipe"), new AltarRecipe(
                Mod.id("dimensional_totem_recipe"),
                Items.TOTEM_OF_UNDYING.getDefaultStack(),
                RefinedMagicItems.bismuth.getDefaultStack(),
                RefinedMagicItems.kyriteShard.getDefaultStack(),
                RefinedMagicItems.topaz.getDefaultStack(),
                RefinedMagicItems.dimensionalTotem.getDefaultStack()
        ));
        altarRecipes.put(Mod.id("necklace_recipe"), new AltarRecipe(
                Mod.id("necklace_recipe"),
                Items.CHAIN.getDefaultStack(),
                Items.IRON_NUGGET.getDefaultStack(),
                Items.IRON_NUGGET.getDefaultStack(),
                Items.IRON_INGOT.getDefaultStack(),
                RefinedMagicItems.baseNecklace.getDefaultStack()
        ));
        altarRecipes.put(Mod.id("fire_necklace_recipe"), new AltarRecipe(
                Mod.id("fire_necklace_recipe"),
                RefinedMagicItems.baseNecklace.getDefaultStack(),
                RefinedMagicItems.bismuth.getDefaultStack(),
                RefinedMagicItems.citrine.getDefaultStack(),
                RefinedMagicItems.topaz.getDefaultStack(),
                RefinedMagicItems.fireNecklace.getDefaultStack()
        ));
    }
}
