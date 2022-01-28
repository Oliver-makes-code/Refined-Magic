package olivermakesco.de.refinedmagic.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import olivermakesco.de.refinedmagic.Mod;
import olivermakesco.de.refinedmagic.block.entity.GlassTankBlockEntity;

public class RefinedMagicBlockEntities {
    public static BlockEntityType<GlassTankBlockEntity> glassTank = FabricBlockEntityTypeBuilder.create(GlassTankBlockEntity::new, RefinedMagicBlocks.glassTank).build();

    public static void register() {
        register(glassTank, Mod.id("glassTank"));
    }

    public static void register(BlockEntityType<?> type, Identifier id) {
        Registry.register(Registry.BLOCK_ENTITY_TYPE, id, type);
    }
}
