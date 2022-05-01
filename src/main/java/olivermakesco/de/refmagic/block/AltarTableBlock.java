package olivermakesco.de.refmagic.block;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.InventoryS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.command.ParticleCommand;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import olivermakesco.de.refmagic.Mod;
import olivermakesco.de.refmagic.block.entity.AltarTableBlockEntity;
import olivermakesco.de.refmagic.recipe.AltarRecipe;
import olivermakesco.de.refmagic.registry.RefinedMagicItems;
import olivermakesco.de.refmagic.registry.RefinedMagicRecipes;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class AltarTableBlock extends BlockWithEntity {
    public AltarTableBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new AltarTableBlockEntity(pos,state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public boolean isTranslucent(BlockState state, BlockView world, BlockPos pos) {
        return false;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.union(
                VoxelShapes.cuboid(0f,0.5625f,0f,1f, 0.75f,1f),
                VoxelShapes.cuboid(0.125f,0f,0.125f,0.3125f, 0.5625f,0.3125f),
                VoxelShapes.cuboid(0.125f,0f,0.6875f,0.3125f,0.5625f,0.875f),
                VoxelShapes.cuboid(0.6875f,0f,0.125f,0.875f,0.5625f,0.3125f),
                VoxelShapes.cuboid(0.6875f,0f,0.6875f,0.875f,0.5625f,0.875f)
        );
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return getOutlineShape(state, world, pos, context);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) return ActionResult.SUCCESS;
        var serverWorld = (ServerWorld) world;
        if (player.isSneaking()) return ActionResult.PASS;
        var entity = (AltarTableBlockEntity) world.getBlockEntity(pos);
        assert entity != null;

        if (!player.getStackInHand(hand).isEmpty() && entity.isFull()) {
            entity.catalyst = player.getStackInHand(hand).copy();
            Optional<AltarRecipe> optional = world.getRecipeManager().getFirstMatch(AltarRecipe.Type.INSTANCE, entity, world);
            entity.catalyst = null;
            if (optional.isEmpty()) {
                return ActionResult.PASS;
            }
            AltarRecipe match = optional.get();
            player.getStackInHand(hand).decrement(1);
            player.getInventory().offerOrDrop(match.result().copy());
            entity.clear();
            update(pos, serverWorld, (ServerPlayerEntity) player);
            world.playSound(null, pos, SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.BLOCKS, 10, 0);
            serverWorld.spawnParticles(ParticleTypes.EXPLOSION, pos.getX(), pos.getY()+0.5, pos.getZ(), 15, 1, 1, 1, 1);
            return ActionResult.SUCCESS;
        }

        var x = hit.getPos().x % 1;
        x += 1;
        x %= 1;
        var z = hit.getPos().z % 1;
        z += 1;
        z %= 1;
        int a = x < 0.5? 0b00: 0b01;
        int b = z < 0.5? 0b00: 0b10;
        int c = a+b;
        if (entity.getSlot(c) == ItemStack.EMPTY) {
            if (player.getStackInHand(hand).isEmpty())
                return ActionResult.PASS;

            var next = player.getStackInHand(hand).copy();
            next.setCount(1);
            player.getStackInHand(hand).decrement(1);
            entity.setSlot(c,next);
            update(pos, serverWorld, (ServerPlayerEntity)player);
            world.playSound(null,pos,SoundEvents.BLOCK_END_PORTAL_FRAME_FILL,SoundCategory.BLOCKS,10,0);
            return ActionResult.SUCCESS;
        }
        var stackToSet = ItemStack.EMPTY;
        if (!player.getStackInHand(hand).isEmpty() && player.getStackInHand(hand).getItem() != entity.getSlot(c).getItem()) {
            stackToSet = player.getStackInHand(hand).copy();
            stackToSet.setCount(1);
            player.getStackInHand(hand).decrement(1);
        }
        var next = entity.getSlot(c);
        player.getInventory().insertStack(next);
        entity.setSlot(c, stackToSet);
        update(pos, serverWorld, (ServerPlayerEntity)player);
        world.playSound(null,pos,SoundEvents.BLOCK_END_PORTAL_FRAME_FILL,SoundCategory.BLOCKS,10,0);
        return ActionResult.SUCCESS;
    }

    public void update(BlockPos pos, ServerWorld world, ServerPlayerEntity entity) {
        world.getChunkManager().markForUpdate(pos);
        entity.getInventory().markDirty();
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        super.onBreak(world, pos, state, player);
        var entity = (AltarTableBlockEntity) world.getBlockEntity(pos);
        var itemEntity0 = new ItemEntity(world, pos.getX(),pos.getY(),pos.getZ(), entity.getSlot(0));
        world.spawnEntity(itemEntity0);
        var itemEntity1 = new ItemEntity(world, pos.getX(),pos.getY(),pos.getZ(), entity.getSlot(1));
        world.spawnEntity(itemEntity1);
        var itemEntity2 = new ItemEntity(world, pos.getX(),pos.getY(),pos.getZ(), entity.getSlot(2));
        world.spawnEntity(itemEntity2);
        var itemEntity3 = new ItemEntity(world, pos.getX(),pos.getY(),pos.getZ(), entity.getSlot(3));
        world.spawnEntity(itemEntity3);
    }
}
