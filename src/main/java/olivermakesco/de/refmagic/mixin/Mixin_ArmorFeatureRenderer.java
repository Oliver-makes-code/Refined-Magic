package olivermakesco.de.refmagic.mixin;

import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;
import olivermakesco.de.refmagic.Mod;
import olivermakesco.de.refmagic.material.WitheriteArmorMaterial;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ArmorFeatureRenderer.class)
public class Mixin_ArmorFeatureRenderer {
    @Inject(at = @At("HEAD"), method = "getArmorTexture", cancellable = true)
    private void setArmorTexture(ArmorItem item, boolean legs, String overlay, CallbackInfoReturnable<Identifier> cir) {
        if (item.getMaterial() instanceof WitheriteArmorMaterial)
            cir.setReturnValue(Mod.id("textures/models/armor/witherite_layer_" + (legs? 2: 1) + (overlay == null? "": "_"+overlay) + ".png"));
    }
}
