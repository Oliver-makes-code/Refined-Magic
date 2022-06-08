package olivermakesco.de.refmagic.recipe

import net.minecraft.item.ItemStack
import net.minecraft.recipe.Ingredient
import net.minecraft.recipe.Recipe
import net.minecraft.recipe.RecipeSerializer
import net.minecraft.recipe.RecipeType
import net.minecraft.util.Identifier
import net.minecraft.util.collection.DefaultedList
import net.minecraft.util.registry.Registry
import net.minecraft.world.World
import olivermakesco.de.refmagic.Mod
import olivermakesco.de.refmagic.block.entity.AltarTableBlockEntity
import olivermakesco.de.refmagic.recipe.serializer.AltarRecipeSerializer

data class AltarRecipe(
    @JvmField
    val id: Identifier,
    val catalyst: Ingredient,
    val inputs: Array<Ingredient?>,
    val result: ItemStack
) : Recipe<AltarTableBlockEntity> {
    override fun matches(inventory: AltarTableBlockEntity, world: World?): Boolean {
        if (!catalyst.test(inventory.catalyst)) return false
        val met = BooleanArray(4)
        for (i in 0 until inventory.size()) for (j in inputs.indices) if (!met[j]) met[j] = inputs[j]?.test(
            inventory.getStack(i)
        )!!
        for (b in met) if (!b) return false
        return true
    }

    override fun craft(inventory: AltarTableBlockEntity): ItemStack = result.copy()

    override fun fits(width: Int, height: Int): Boolean = width < 4 && height == 1

    override fun getOutput(): ItemStack = result

    override fun getId(): Identifier = ID

    override fun getIngredients(): DefaultedList<Ingredient> {
        val list = DefaultedList.of<Ingredient>()
        list.addAll(listOf(*inputs))
        return list
    }

    override fun getSerializer(): RecipeSerializer<*> = AltarRecipeSerializer.INSTANCE

    override fun getType(): RecipeType<*> = Type.INSTANCE

    companion object {
        var ID = Mod.id("altar")
        class Type : RecipeType<AltarRecipe?> {
            companion object {
                val INSTANCE: Type = Type()
            }
        }
        fun getTypeInstance(): Type = Type.INSTANCE
        fun register() {
            Registry.register(
                Registry.RECIPE_SERIALIZER,
                ID,
                AltarRecipeSerializer.INSTANCE
            )
        }
    }
}
