package olivermakesco.de.refmagic.item;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PotionItem;
import net.minecraft.potion.PotionUtil;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import olivermakesco.de.refmagic.Mod;
import olivermakesco.de.refmagic.augment.Augment;
import olivermakesco.de.refmagic.augment.AugmentLoader;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.CallbackI;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NecklaceItem extends TrinketItem {
    public NecklaceItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean isFireproof() {
        return true;
    }

    public static Map.Entry<Identifier, Augment> getAugment(ItemStack stack) {
        var nbt = stack.getOrCreateNbt();
        String name = "refmagic:base";
        if (nbt.contains("augment"))
            name = nbt.getString("augment");
        Identifier id = new Identifier((name));
        Augment augment = AugmentLoader.augments.get(id);
        if (augment == null)
            augment = AugmentLoader.augments.get(Mod.id("base"));
        return new AbstractMap.SimpleImmutableEntry<>(id, augment);
    }
    public static void setAugment(ItemStack stack, Identifier id) {
        var nbt = stack.getOrCreateNbt();
        nbt.putString("augment", id.toString());
        stack.setNbt(nbt);
    }

    @Override
    public ItemStack getDefaultStack() {
        var stack = super.getDefaultStack();
        setAugment(stack, Mod.id("base"));
        return stack;
    }

    int cooldown = 0;

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        var augmentEntry = getAugment(stack);
        var augment = augmentEntry.getValue();
        cooldown++;
        cooldown %= 80;
        if (cooldown == 0)
            for (Identifier id : augment.potion())
                entity.addStatusEffect(new StatusEffectInstance(Registry.STATUS_EFFECT.get(id), 85));
    }

    @Override
    public String getTranslationKey(ItemStack stack) {
        Identifier id = Mod.id("base");
        try {
            var augmentEntry = getAugment(stack);
            id = augmentEntry.getKey();
        } catch (Throwable ignored) {}
        return id.getNamespace()+".necklace.augment."+id.getPath();
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        var augments = getAugment(stack);
        for (Identifier potion : augments.getValue().potion())
            for (var instance : Registry.POTION.get(potion).getEffects())
                tooltip.add(
                        new TranslatableText(
                                "potion.withAmplifier",
                                new TranslatableText(instance.getTranslationKey()),
                                new TranslatableText("potion.potency."+instance.getAmplifier())
                        ).formatted(instance.getEffectType().getType().getFormatting())
                );
        super.appendTooltip(stack, world, tooltip, context);
    }
}
