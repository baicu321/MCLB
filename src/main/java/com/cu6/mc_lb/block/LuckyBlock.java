package com.cu6.mc_lb.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

//这个类是示例幸运方块实现
public class LuckyBlock extends Block {
//渲染方块,16x16x16指的是一个方块的大小
    public static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

    public LuckyBlock(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

//这里是使用右键激活 use方法
    //注:使用override调用的便是原版方法
    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand pHand, BlockHitResult pHit) {
        if (!level.isClientSide()) {
            ServerLevel serverLevel = (ServerLevel) level;
            ServerPlayer serverPlayer = (ServerPlayer) player;
            RandomSource random = serverLevel.getRandom();

            level.destroyBlock(pos, false);
            level.playSound(null, pos, SoundEvents.UI_STONECUTTER_TAKE_RESULT,
                    SoundSource.BLOCKS, 1.0F, 1.0F);
            int luck = random.nextInt(1);//随机事件数量
            switch (luck) {
                case 0://生成随机数量钻石
                    spawnItem(serverLevel, pos, new ItemStack(Items.DIAMOND, random.nextInt(5) + 1));
            }
        }
        return InteractionResult.SUCCESS;
    }
    //这里我们自己构建了一个方法,这个方法会给你物品,并且定义了随机事件
    //你也可以尝试构建自己的方法!
    private void spawnItem(ServerLevel level, BlockPos pos, ItemStack stack) {
        ItemEntity itemEntity = new ItemEntity(level,
                pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                stack);
        itemEntity.setDeltaMovement(
                (level.getRandom().nextFloat() - 0.5) * 0.7,
                (level.getRandom().nextFloat() * 0.5) * 0.7,
                (level.getRandom().nextFloat() - 0.5) * 0.7);
        level.addFreshEntity(itemEntity);
    }
}
