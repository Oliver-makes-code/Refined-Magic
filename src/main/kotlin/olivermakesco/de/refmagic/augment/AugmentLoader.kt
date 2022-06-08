package olivermakesco.de.refmagic.augment

import com.google.gson.Gson
import com.google.gson.JsonElement
import net.minecraft.resource.JsonDataLoader
import net.minecraft.resource.ResourceManager
import net.minecraft.util.Identifier
import net.minecraft.util.profiler.Profiler
import olivermakesco.de.refmagic.Mod
import org.quiltmc.qsl.resource.loader.api.reloader.IdentifiableResourceReloader

class AugmentLoader(gson: Gson?, string: String?) : JsonDataLoader(gson, string), IdentifiableResourceReloader {
    override fun apply(prepared: Map<Identifier, JsonElement?>, manager: ResourceManager, profiler: Profiler) {
        augments = HashMap()
        for (id in prepared.keys) {
            val element = prepared[id]
            val `object` = element!!.asJsonObject
            val color = `object`["color"].asInt
            val potions = `object`["potions"].asJsonArray
            val potionList = ArrayList<Identifier>()
            for (jsonElement in potions) potionList.add(Identifier(jsonElement.asString))
            augments[id] = Augment(color, potionList)
        }
    }

    override fun getQuiltId(): Identifier {
        return id
    }

    companion object {
        val id = Mod.id("augments")
        var augments: MutableMap<Identifier, Augment> = HashMap()
    }
}