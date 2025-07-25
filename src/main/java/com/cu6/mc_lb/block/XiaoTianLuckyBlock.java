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
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class XiaoTianLuckyBlock extends LuckyBlock{

    public static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

    public XiaoTianLuckyBlock(Properties pProperties) {
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
            int luck = random.nextInt(3);
            switch (luck) {
                case 0:
                    spawnItem(serverLevel, pos, new ItemStack(Items.DIAMOND, random.nextInt(10) + 1));
                    break;
                case 1:
                    spawnEntity(serverLevel,pos,EntityType.VILLAGER,1,1, Component.literal("DJ"));
                    placeStructure(serverLevel,pos,new ResourceLocation(MCLB.MOD_ID,"noteblock"), Rotation.getRandom(random));
                    break;
                case 2:
                    spawnItem(serverLevel, pos, new ItemStack(ModItems.XIAOTIAN_HELMET.get(), random.nextInt(1) + 1));
                    spawnItem(serverLevel, pos, new ItemStack(ModItems.XIAOTIAN_CHESTPLATE.get(), random.nextInt(1) + 1));
                    spawnItem(serverLevel, pos, new ItemStack(ModItems.XIAOTIAN_LEGGINGS.get(), random.nextInt(1) + 1));
                    spawnItem(serverLevel, pos, new ItemStack(ModItems.XIAOTIAN_BOOTS.get(), random.nextInt(1) + 1));
                    break;
            }
        }
        return InteractionResult.SUCCESS;
    }
}
