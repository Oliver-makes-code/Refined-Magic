package olivermakesco.de.refmagic.recipe.serializer;

import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import olivermakesco.de.refmagic.recipe.AltarRecipe;

import java.util.ArrayList;

public class AlterRecipeSerializer implements RecipeSerializer<AltarRecipe> {

    @Override
    public AltarRecipe read(Identifier id, JsonObject json) {
        var a = new ItemStack(Registry.ITEM.get(new Identifier(json.get("1").getAsString())));
        var b = new ItemStack(Registry.ITEM.get(new Identifier(json.get("2").getAsString())));
        var c = new ItemStack(Registry.ITEM.get(new Identifier(json.get("3").getAsString())));
        var d = new ItemStack(Registry.ITEM.get(new Identifier(json.get("4").getAsString())));

        var resultJson = json.get("result").getAsJsonObject();
        var result = new ItemStack(Registry.ITEM.get(new Identifier(resultJson.get("identifier").getAsString())));
        result.setCount(resultJson.get("count").getAsByte());

        return new AltarRecipe(id,a,b,c,d,result);
    }

    @Override
    public AltarRecipe read(Identifier id, PacketByteBuf buf) {
        var a = buf.readItemStack();
        var b = buf.readItemStack();
        var c = buf.readItemStack();
        var d = buf.readItemStack();
        var result = buf.readItemStack();
        return new AltarRecipe(id,a,b,c,d,result);
    }

    @Override
    public void write(PacketByteBuf buf, AltarRecipe recipe) {
        buf.writeItemStack(recipe.a);
        buf.writeItemStack(recipe.b);
        buf.writeItemStack(recipe.c);
        buf.writeItemStack(recipe.d);
        buf.writeItemStack(recipe.result);
    }
}
