package olivermakesco.de.refmagic.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;
import olivermakesco.de.refmagic.Mod;
import olivermakesco.de.refmagic.block.entity.AltarTableBlockEntity;

public class RefinedMagicBlockEntities {
    public static BlockEntityType<AltarTableBlockEntity> altarTableBlockEntity = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            Mod.id("alter_table"),
            FabricBlockEntityTypeBuilder.create(
                    AltarTableBlockEntity::new,
                    RefinedMagicBlocks.altarBlock
            ).build()
    );

    public static void register() {
    }
}
