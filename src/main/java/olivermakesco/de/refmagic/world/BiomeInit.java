package olivermakesco.de.refmagic.world;

import net.fabricmc.fabric.api.biome.v1.TheEndBiomes;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.util.Holder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.BiomePlacementModifier;
import net.minecraft.world.gen.decorator.CountOnEveryLayerPlacementModifier;
import net.minecraft.world.gen.decorator.DecoratorContext;
import net.minecraft.world.gen.decorator.PlacementModifierType;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.util.ConfiguredFeatureUtil;
import net.minecraft.world.gen.feature.util.PlacedFeatureUtil;
import olivermakesco.de.refmagic.Mod;
import olivermakesco.de.refmagic.registry.RefinedMagicBlocks;

import java.util.Random;
import java.util.stream.Stream;

public final class BiomeInit {

    public static final RegistryKey<Biome> mushroomIsles = RegistryKey.of(Registry.BIOME_KEY,Mod.id("mushroom_isles"));

    public static final Holder<ConfiguredFeature<HugeFungusFeatureConfig, ?>> enchantedFungusPlanted = ConfiguredFeatureUtil.register(
            Mod.id("encahnted_mushroom_planted").toString(),
            Feature.HUGE_FUNGUS,
            new HugeFungusFeatureConfig(
                    RefinedMagicBlocks.enlium.getDefaultState(),
                    RefinedMagicBlocks.enchantedStem.getDefaultState(),
                    RefinedMagicBlocks.enchantedWart.getDefaultState(),
                    RefinedMagicBlocks.enchantedShroomlight.getDefaultState(),
                    false
            )
    );

    public static final Holder<PlacedFeature> enchantedFungusPlaced = PlacedFeatureUtil.register(Mod.id("enchanted_fungus_placed").toString(), enchantedFungusPlanted, CountOnEveryLayerPlacementModifier.create(8), BiomePlacementModifier.getInstance());

    public static final Biome mushroomIslesBiome = createMushroomIsles();

    private static Biome createBaseEndBiome(GenerationSettings.Builder builder) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addEndMobs(spawnSettings);
        return (new Biome.Builder())
                .precipitation(Biome.Precipitation.NONE)
                .category(Biome.Category.THEEND)
                .temperature(0.5F)
                .downfall(0.5F)
                .effects((new BiomeEffects.Builder())
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .fogColor(10518688).skyColor(0)
                        .moodSound(BiomeMoodSound.CAVE)
                        .build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(builder.build())
                .build();
    }

    public static Biome createMushroomIsles() {
        GenerationSettings.Builder builder = new GenerationSettings.Builder()
                .feature(GenerationStep.Feature.SURFACE_STRUCTURES, EndPlacedFeatures.END_GATEWAY_RETURN)
                .feature(GenerationStep.Feature.VEGETAL_DECORATION, enchantedFungusPlaced);
        return createBaseEndBiome(builder);
    }

    public static void register() {
        Registry.register(BuiltinRegistries.BIOME, mushroomIsles.getValue(), mushroomIslesBiome);
        TheEndBiomes.addHighlandsBiome(mushroomIsles, 5.0);
    }

}
