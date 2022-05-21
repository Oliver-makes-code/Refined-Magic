package olivermakesco.de.refmagic.world;

import net.fabricmc.fabric.api.biome.v1.TheEndBiomes;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.util.Holder;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.util.ConfiguredFeatureUtil;
import net.minecraft.world.gen.feature.util.PlacedFeatureUtil;
import olivermakesco.de.refmagic.Mod;

public final class BiomeInit {

    public static final RegistryKey<Biome> MUSHROOM_ISLES = RegistryKey.of(Registry.BIOME_KEY, new Identifier(Mod.modid, "mushroom_isles"));

    public static final Feature<DefaultFeatureConfig> GIANT_MUSHROOM_FEATURE = Registry.register(Registry.FEATURE, "giant_mushroom", new GiantMushroomFeature());
    public static final Holder<ConfiguredFeature<DefaultFeatureConfig, ?>> GIANT_MUSHROOM_FEATURE_CONFIGURED = ConfiguredFeatureUtil.register("giant_mushroom", GIANT_MUSHROOM_FEATURE);
    public static final Holder<PlacedFeature> GIANT_MUSHROOM_FEATURE_PLACED = PlacedFeatureUtil.register("giant_mushroom", GIANT_MUSHROOM_FEATURE_CONFIGURED);

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
                .feature(GenerationStep.Feature.SURFACE_STRUCTURES,GIANT_MUSHROOM_FEATURE_PLACED);
        return createBaseEndBiome(builder);
    }

    public static void register() {
        Registry.register(BuiltinRegistries.BIOME, MUSHROOM_ISLES.getValue(), createMushroomIsles());
        TheEndBiomes.addHighlandsBiome(MUSHROOM_ISLES, 5.0);
    }

}
