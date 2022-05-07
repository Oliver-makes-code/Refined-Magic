package olivermakesco.de.refmagic.augment;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.resource.JsonDataLoader;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import olivermakesco.de.refmagic.Mod;
import olivermakesco.de.refmagic.augment.Augment;
import org.quiltmc.qsl.resource.loader.api.reloader.IdentifiableResourceReloader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AugmentLoader extends JsonDataLoader implements IdentifiableResourceReloader {
    public static final Identifier id = Mod.id("augments");
    public static Map<Identifier, Augment> augments;

    public AugmentLoader(Gson gson, String string) {
        super(gson, string);
    }

    @Override
    protected void apply(Map<Identifier, JsonElement> prepared, ResourceManager manager, Profiler profiler) {
        augments = new HashMap<>();
        for (Identifier id : prepared.keySet()) {
            var element = prepared.get(id);
            JsonObject object = element.getAsJsonObject();
            int color = object.get("color").getAsInt();
            JsonArray potions = object.get("potions").getAsJsonArray();
            ArrayList<Identifier> potionList = new ArrayList<>();
            for (JsonElement jsonElement : potions)
                potionList.add(new Identifier(jsonElement.getAsString()));
            augments.put(id, new Augment(color, potionList));
        }
    }

    @Override
    public Identifier getQuiltId() {
        return id;
    }
}
