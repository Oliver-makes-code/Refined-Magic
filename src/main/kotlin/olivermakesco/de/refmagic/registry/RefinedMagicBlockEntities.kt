package olivermakesco.de.refmagic.registry

import net.fabricmc.fabric.api.`object`.builder.v1.block.entity.FabricBlockEntityTypeBuilder
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.util.math.BlockPos
import net.minecraft.util.registry.Registry
import olivermakesco.de.refmagic.Mod
import olivermakesco.de.refmagic.block.entity.AltarTableBlockEntity
import org.quiltmc.qkl.wrapper.minecraft.registry.*

object RefinedMagicBlockEntities {
    var altarTableBlockEntity: BlockEntityType<AltarTableBlockEntity> = FabricBlockEntityTypeBuilder.create({blockPos: BlockPos?, blockState: BlockState? ->
            AltarTableBlockEntity(
                blockPos,
                blockState
            )
        },
        RefinedMagicBlocks.altarBlock
    ).build()

    fun register() {
        Registry.BLOCK_ENTITY_TYPE(Mod.modid) {
            altarTableBlockEntity withName "alter_table"
        }
    }
}