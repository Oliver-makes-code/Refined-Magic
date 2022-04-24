package olivermakesco.de.refmagic.recipe;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import olivermakesco.de.refmagic.block.entity.AltarTableBlockEntity;
import olivermakesco.de.refmagic.registry.RefinedMagicRecipes;

import java.util.Optional;

public class AltarRecipe implements Recipe<AltarTableBlockEntity> {
    public final Identifier id;
    public final ItemStack a;
    public final ItemStack b;
    public final ItemStack c;
    public final ItemStack d;
    public final ItemStack result;

    public AltarRecipe(Identifier id, ItemStack a, ItemStack b, ItemStack c, ItemStack d, ItemStack result) {
        this.id = id;

        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;

        this.result = result;
    }

    @Override
    public boolean matches(AltarTableBlockEntity inventory, World world) {
        return inventory.test(a,b,c,d);
    }

    @Override
    public ItemStack craft(AltarTableBlockEntity inventory) {
        if (!inventory.test(a,b,c,d)) return ItemStack.EMPTY;
        inventory.setSlot(0, ItemStack.EMPTY);
        inventory.setSlot(1, ItemStack.EMPTY);
        inventory.setSlot(2, ItemStack.EMPTY);
        inventory.setSlot(3, ItemStack.EMPTY);
        return result.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return width < 4 && height == 1;
    }

    @Override
    public ItemStack getOutput() {
        return result;
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RefinedMagicRecipes.altarRecipeSerializer;
    }

    @Override
    public RecipeType<?> getType() {
        return altarRecipeRecipeType;
    }

    public static RecipeType<AltarRecipe> altarRecipeRecipeType = new RecipeType<>() {
        @Override
        public <C extends Inventory> Optional<AltarRecipe> match(Recipe<C> recipe, World world, C inventory) {
            return RecipeType.super.match(recipe, world, inventory);
        }
    };
}
