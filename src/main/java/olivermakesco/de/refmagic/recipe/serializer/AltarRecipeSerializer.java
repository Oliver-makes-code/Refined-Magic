package olivermakesco.de.refmagic.recipe.serializer;

import com.google.gson.*;
import com.mojang.serialization.JsonOps;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import olivermakesco.de.refmagic.recipe.AltarRecipe;
import olivermakesco.de.refmagic.registry.RefinedMagicItems;
import org.quiltmc.qsl.recipe.api.serializer.QuiltRecipeSerializer;

import java.util.ArrayList;

public class AltarRecipeSerializer implements QuiltRecipeSerializer<AltarRecipe> {

    public static AltarRecipeSerializer INSTANCE = new AltarRecipeSerializer();

    public static class JsonFormat {
        JsonObject catalyst;
        JsonArray inputs;
        JsonObject result;
    }

    @Override
    public AltarRecipe read(Identifier id, JsonObject json) {
        JsonFormat recipeJson = new Gson().fromJson(json, JsonFormat.class);
        if (recipeJson.inputs == null) {
            throw new JsonSyntaxException("Missing field 'inputs'");
        }
        if (recipeJson.result == null) {
            throw new JsonSyntaxException("Missing field 'result'");
        }
        Ingredient catalyst = recipeJson.catalyst != null
                ? Ingredient.fromJson(recipeJson.catalyst)
                : Ingredient.ofStacks(RefinedMagicItems.kyritePowder.getDefaultStack());
        Ingredient[] inputs = new Ingredient[4];
        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = Ingredient.fromJson(recipeJson.inputs.get(i));
        }
        ItemStack result = ShapedRecipe.outputFromJson(recipeJson.result);
        return new AltarRecipe(id, catalyst, inputs, result);
    }

    @Override
    public JsonObject toJson(AltarRecipe recipe) {
        JsonObject obj = new JsonObject();
        obj.add("type", new JsonPrimitive(AltarRecipe.ID.toString()));
        obj.add("catalyst", recipe.catalyst().toJson());
        JsonArray inputs = new JsonArray();
        for (Ingredient input : recipe.inputs()) {
            inputs.add(input.toJson());
        }
        obj.add("inputs", inputs);
        ItemStack.CODEC.encode(recipe.result(), JsonOps.INSTANCE, JsonOps.INSTANCE.empty())
                .result()
                .ifPresent(result -> obj.add("result", result));
        return obj;
    }

    @Override
    public AltarRecipe read(Identifier id, PacketByteBuf buf) {
        Ingredient catalyst = Ingredient.fromPacket(buf);
        Ingredient[] inputs = new Ingredient[4];
        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = Ingredient.fromPacket(buf);
        }
        ItemStack result = buf.readItemStack();
        return new AltarRecipe(id, catalyst, inputs, result);
    }

    @Override
    public void write(PacketByteBuf buf, AltarRecipe recipe) {
        recipe.catalyst().write(buf);
        for (Ingredient input : recipe.inputs()) {
            input.write(buf);
        }
        buf.writeItemStack(recipe.result());
    }
}
