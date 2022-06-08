package olivermakesco.de.refmagic.recipe.serializer

import com.google.gson.*
import com.mojang.serialization.JsonOps
import net.minecraft.item.ItemStack
import net.minecraft.network.PacketByteBuf
import net.minecraft.recipe.Ingredient
import net.minecraft.recipe.ShapedRecipe
import net.minecraft.util.Identifier
import olivermakesco.de.refmagic.item.NecklaceItem
import olivermakesco.de.refmagic.recipe.AltarRecipe
import olivermakesco.de.refmagic.registry.RefinedMagicItems
import org.quiltmc.qsl.recipe.api.serializer.QuiltRecipeSerializer

class AltarRecipeSerializer : QuiltRecipeSerializer<AltarRecipe> {
    class JsonFormat {
        var catalyst: JsonObject? = null
        var inputs: JsonArray? = null
        var result: JsonObject? = null
        var augment: JsonPrimitive? = null
    }

    override fun read(id: Identifier, json: JsonObject): AltarRecipe {
        val recipeJson = Gson().fromJson(json, JsonFormat::class.java)
        if (recipeJson.inputs == null) {
            throw JsonSyntaxException("Missing field 'inputs'")
        }
        if (recipeJson.result == null) {
            throw JsonSyntaxException("Missing field 'result'")
        }
        val catalyst =
            if (recipeJson.catalyst != null) Ingredient.fromJson(recipeJson.catalyst) else Ingredient.ofStacks(
                RefinedMagicItems.kyritePowder.defaultStack
            )
        val augment = if (recipeJson.augment != null) Identifier(
            recipeJson.augment!!.asString
        ) else null
        val inputs = arrayOfNulls<Ingredient>(4)
        for (i in inputs.indices) {
            inputs[i] = Ingredient.fromJson(recipeJson.inputs!![i])
        }
        val result = ShapedRecipe.outputFromJson(recipeJson.result)
        if (augment != null) NecklaceItem.setAugment(result, augment)
        return AltarRecipe(id, catalyst, inputs, result)
    }

    override fun toJson(recipe: AltarRecipe): JsonObject {
        val obj = JsonObject()
        obj.add("type", JsonPrimitive(recipe.id.toString()))
        obj.add("catalyst", recipe.catalyst.toJson())
        val inputs = JsonArray()
        for (input in recipe.inputs) {
            if (input != null) {
                inputs.add(input.toJson())
            }
        }
        obj.add("inputs", inputs)
        ItemStack.CODEC.encode(recipe.result, JsonOps.INSTANCE, JsonOps.INSTANCE.empty())
            .result()
            .ifPresent { result: JsonElement? -> obj.add("result", result) }
        return obj
    }

    override fun read(id: Identifier, buf: PacketByteBuf): AltarRecipe {
        val catalyst = Ingredient.fromPacket(buf)
        val inputs = arrayOfNulls<Ingredient>(4)
        for (i in inputs.indices) {
            inputs[i] = Ingredient.fromPacket(buf)
        }
        val result = buf.readItemStack()
        return AltarRecipe(id, catalyst, inputs, result)
    }

    override fun write(buf: PacketByteBuf, recipe: AltarRecipe) {
        recipe.catalyst.write(buf)
        for (input in recipe.inputs) {
            input?.write(buf)
        }
        buf.writeItemStack(recipe.result)
    }

    companion object {
        var INSTANCE = AltarRecipeSerializer()
    }
}