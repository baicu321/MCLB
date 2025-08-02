package com.cu6.mc_lb.block.luckyblock;

import com.cu6.mc_lb.MCLB;
import com.cu6.mc_lb.block.LuckyBlock;
import com.cu6.mc_lb.entity.ModEntities;
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
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class YuShanLuckyBlock extends LuckyBlock {

    public YuShanLuckyBlock(Properties pProperties) {
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
            int luck = random.nextInt(14);
            switch (luck) {
                case 0:
                    spawnItem(serverLevel, pos, new ItemStack(ModItems.YUSHAN_HELMET.get(), random.nextInt(1) + 1));
                    spawnItem(serverLevel, pos, new ItemStack(ModItems.YUSHAN_CHESTPLATE.get(), random.nextInt(1) + 1));
                    spawnItem(serverLevel, pos, new ItemStack(ModItems.YUSHAN_LEGGINGS.get(), random.nextInt(1) + 1));
                    spawnItem(serverLevel, pos, new ItemStack(ModItems.YUSHAN_BOOTS.get(), random.nextInt(1) + 1));
                    break;
                case 1:
                    spawnItem(serverLevel, pos, new ItemStack(Items.BONE, random.nextInt(9) + 1));
                    break;
                case 2:
                    spawnEntity(serverLevel,pos, EntityType.WOLF,1,6, Component.literal("歪歪"));
                    break;
                case 3:
                    spawnFluid(serverLevel,pos, Fluids.FLOWING_LAVA,5);
                    break;
                case 4:
                    spawnEntity(serverLevel,pos, EntityType.SHEEP,1,1, Component.literal("猴哥"));
                    break;
                case 5:
                    spawnEntity(serverLevel,pos, EntityType.TRADER_LLAMA,1,1, Component.literal("八戒"));
                    break;
                case 6:
                    spawnEntity(serverLevel,pos, EntityType.DROWNED,1,1, Component.literal("小僵"));
                    break;
                case 7:
                    spawnEntity(serverLevel,pos, EntityType.TURTLE,1,1, Component.literal("小王八犊子"));
                    break;
                case 8:
                    spawnEntity(serverLevel,pos, EntityType.PIG,1,1, Component.literal("臭屁"));
                    break;
                case 9:
                    spawnEntity(serverLevel,pos, EntityType.CAT,1,1, Component.literal("虾条"));
                    break;
                case 10:
                    spawnEntity(serverLevel,pos, EntityType.CAT,1,1, Component.literal("塞班"));
                    break;
                case 11:
                    spawnEntity(serverLevel,pos, EntityType.PARROT,1,1, Component.literal("哈哈"));
                    break;
                case 12:
                    placeStructure(serverLevel,pos,new ResourceLocation(MCLB.MOD_ID,"jail"), Rotation.getRandom(random));
                    break;
                case 13:
                    spawnEntity(serverLevel,pos, ModEntities.YUSHAN.get(),1,1, null);
                    break;
            }
        }
        return InteractionResult.SUCCESS;
    }
}
