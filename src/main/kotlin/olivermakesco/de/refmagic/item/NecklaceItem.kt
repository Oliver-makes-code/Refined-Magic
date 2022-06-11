package olivermakesco.de.refmagic.item

import dev.emi.trinkets.api.SlotReference
import dev.emi.trinkets.api.TrinketItem
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import net.minecraft.world.World
import olivermakesco.de.refmagic.Mod
import olivermakesco.de.refmagic.augment.Augment
import olivermakesco.de.refmagic.augment.AugmentLoader
import java.util.AbstractMap.SimpleImmutableEntry

class NecklaceItem(settings: Settings?) : TrinketItem(settings) {
    override fun isFireproof(): Boolean {
        return true
    }

    override fun getDefaultStack(): ItemStack {
        val stack = super.getDefaultStack()
        setAugment(stack, Mod.id("base"))
        return stack
    }

    var cooldown = 0
    override fun tick(stack: ItemStack, slot: SlotReference, entity: LivingEntity) {
        val (_, augment) = getAugment(stack)
        cooldown++
        cooldown %= 80
        if (cooldown == 0) for (id in augment.potion) entity.addStatusEffect(
            StatusEffectInstance(
                Registry.STATUS_EFFECT[id],
                85
            )
        )
    }

    override fun getTranslationKey(stack: ItemStack): String {
        var id = Mod.id("base")
        try {
            val (key) = getAugment(stack)
            id = key
        } catch (ignored: Throwable) {
        }
        return id.namespace + ".necklace.augment." + id.path
    }

    override fun appendTooltip(stack: ItemStack, world: World?, tooltip: MutableList<Text>, context: TooltipContext) {
        val (_, value) = getAugment(stack)
        for (potion in value.potion) for (instance in Registry.POTION[potion].effects) tooltip.add(
            Text.translatable(
                "potion.withAmplifier",
                Text.translatable(instance.translationKey),
                Text.translatable("potion.potency." + instance.amplifier)
            ).formatted(instance.effectType.type.formatting)
        )
        super.appendTooltip(stack, world, tooltip, context)
    }

    companion object {
        @JvmStatic
        fun getAugment(stack: ItemStack): Map.Entry<Identifier, Augment> {
            val nbt = stack.orCreateNbt
            var name: String? = "refmagic:base"
            if (nbt.contains("augment")) name = nbt.getString("augment")
            val id = Identifier(name)
            var augment = AugmentLoader.augments[id]
            if (augment == null) augment =
                Augment(0xffffff, ArrayList())
            return SimpleImmutableEntry(id, augment)
        }

        fun setAugment(stack: ItemStack, id: Identifier) {
            val nbt = stack.orCreateNbt
            nbt.putString("augment", id.toString())
            stack.nbt = nbt
        }
    }
}