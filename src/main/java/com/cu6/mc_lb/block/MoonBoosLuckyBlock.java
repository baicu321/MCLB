package com.cu6.mc_lb.block;

import com.cu6.mc_lb.MCLB;
import com.cu6.mc_lb.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MoonBoosLuckyBlock extends LuckyBlock{

    public static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    public MoonBoosLuckyBlock(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand pHand, BlockHitResult pHit) {
        if (!level.isClientSide()) {
            ServerLevel serverLevel = (ServerLevel) level;
            ServerPlayer serverPlayer = (ServerPlayer) player;
            RandomSource random = serverLevel.getRandom();

            level.destroyBlock(pos, false);
            level.playSound(null, pos, SoundEvents.UI_STONECUTTER_TAKE_RESULT,
                    SoundSource.BLOCKS, 1.0F, 1.0F);
            int luck = random.nextInt(6);
            switch (luck) {
                case 0:
                    placeStructure(serverLevel,pos,new ResourceLocation(MCLB.MOD_ID,"music_star"), Rotation.getRandom(random));
                    break;
                case 1:
                    spawnItem(serverLevel, pos, new ItemStack(Items.REDSTONE_BLOCK, random.nextInt(16) + 1));
                    spawnItem(serverLevel, pos, new ItemStack(Items.REPEATER, random.nextInt(16) + 1));
                    spawnItem(serverLevel, pos, new ItemStack(Items.REDSTONE_TORCH, random.nextInt(16) + 1));
                    spawnItem(serverLevel, pos, new ItemStack(Items.REDSTONE, random.nextInt(40) + 1));
                    spawnItem(serverLevel, pos, new ItemStack(Items.LEVER, random.nextInt(16) + 1));
                    spawnItem(serverLevel, pos, new ItemStack(Items.COMPARATOR, random.nextInt(16) + 1));
                    break;
                case 2:
                    spawnItem(serverLevel, pos, new ItemStack(Items.CHEST, random.nextInt(16) + 1));
                    spawnItem(serverLevel, pos, new ItemStack(Items.TRAPPED_CHEST, random.nextInt(16) + 1));
                    spawnItem(serverLevel, pos, new ItemStack(Items.HOPPER, random.nextInt(16) + 1));
                    spawnItem(serverLevel, pos, new ItemStack(Items.DISPENSER, random.nextInt(16) + 1));
                    spawnItem(serverLevel, pos, new ItemStack(Items.DROPPER, random.nextInt(16) + 1));
                    break;
                case 3:
                    spawnItem(serverLevel, pos, new ItemStack(Items.STONE_PRESSURE_PLATE, random.nextInt(16) + 1));
                    spawnItem(serverLevel, pos, new ItemStack(Items.LIGHT_WEIGHTED_PRESSURE_PLATE, random.nextInt(16) + 1));
                    spawnItem(serverLevel, pos, new ItemStack(Items.OAK_PRESSURE_PLATE, random.nextInt(16) + 1));
                    spawnItem(serverLevel, pos, new ItemStack(Items.HEAVY_WEIGHTED_PRESSURE_PLATE, random.nextInt(16) + 1));
                    spawnItem(serverLevel, pos, new ItemStack(Items.OAK_BUTTON, random.nextInt(16) + 1));
                    spawnItem(serverLevel, pos, new ItemStack(Items.STONE_BUTTON, random.nextInt(16) + 1));
                    break;
                case 4:
                    spawnItem(serverLevel, pos, new ItemStack(Items.PISTON, random.nextInt(16) + 1));
                    spawnItem(serverLevel, pos, new ItemStack(Items.STICKY_PISTON, random.nextInt(16) + 1));
                    spawnItem(serverLevel, pos, new ItemStack(Items.SLIME_BLOCK, random.nextInt(16) + 1));
                    spawnItem(serverLevel, pos, new ItemStack(Items.TNT, random.nextInt(30) + 1));
                    spawnItem(serverLevel, pos, new ItemStack(Items.OBSERVER, random.nextInt(16) + 1));
                    break;
                case 5:
                    spawnItem(serverLevel, pos, new ItemStack(Items.END_ROD, random.nextInt(1) + 1));
                    break;
            }
        }
        return InteractionResult.SUCCESS;
    }
}
