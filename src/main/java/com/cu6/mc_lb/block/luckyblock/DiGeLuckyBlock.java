package com.cu6.mc_lb.block.luckyblock;

import com.cu6.mc_lb.MCLB;
import com.cu6.mc_lb.block.LuckyBlock;
import com.cu6.mc_lb.block.ModBlocks;
import com.cu6.mc_lb.item.ModItems;
import com.cu6.mc_lb.util.DelayedMessageSystem;
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

public class DiGeLuckyBlock extends LuckyBlock {
    public DiGeLuckyBlock(Properties pProperties) {
        super(pProperties);
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
                    spawnItem(serverLevel, pos, new ItemStack(ModItems.DIGE_HELMET.get(), random.nextInt(1) + 1));
                    spawnItem(serverLevel, pos, new ItemStack(ModItems.DIGE_CHESTPLATE.get(), random.nextInt(1) + 1));
                    spawnItem(serverLevel, pos, new ItemStack(ModItems.DIGE_LEGGINGS.get(), random.nextInt(1) + 1));
                    spawnItem(serverLevel, pos, new ItemStack(ModItems.DIGE_BOOTS.get(), random.nextInt(1) + 1));
                    break;
                case 1:
                    placeStructure(serverLevel,pos,new ResourceLocation(MCLB.MOD_ID,"lapis"), Rotation.getRandom(random));
                    DelayedMessageSystem.addMessage(
                            (ServerPlayer) player,
                            20,
                            Component.literal("星光大道已生成!")
                    );
                    break;
                case 2:
                    spawnItem(serverLevel, pos, new ItemStack(Items.STONE_HOE, random.nextInt(10) + 1));
                    break;
            }
        }
        return InteractionResult.SUCCESS;
    }
}
