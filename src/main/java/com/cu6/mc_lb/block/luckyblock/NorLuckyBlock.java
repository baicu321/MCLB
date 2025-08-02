package com.cu6.mc_lb.block.luckyblock;

import com.cu6.mc_lb.block.LuckyBlock;
import com.cu6.mc_lb.entity.ModEntities;
import com.cu6.mc_lb.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.CatVariant;
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

import java.util.Objects;

public class NorLuckyBlock extends LuckyBlock {
    public NorLuckyBlock(Properties pProperties) {
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
            int luck = random.nextInt(7);
            switch (luck) {
                case 0:
                    spawnItem(serverLevel, pos, new ItemStack(ModItems.NOR_HELMET.get(), random.nextInt(1) + 1));
                    spawnItem(serverLevel, pos, new ItemStack(ModItems.NOR_CHESTPLATE.get(), random.nextInt(1) + 1));
                    spawnItem(serverLevel, pos, new ItemStack(ModItems.NOR_LEGGINGS.get(), random.nextInt(1) + 1));
                    spawnItem(serverLevel, pos, new ItemStack(ModItems.NOR_BOOTS.get(), random.nextInt(1) + 1));
                    break;
                case 1:
                    spawnItem(serverLevel, pos, new ItemStack(ModItems.CHUIBING.get(), random.nextInt(5) + 1));
                    break;
                case 2:
                    spawnEntity(serverLevel,pos,EntityType.CAT,1,1, Component.literal("发财猫"));
                    break;
                case 3:
                    spawnItem(serverLevel, pos, new ItemStack(Items.MILK_BUCKET, random.nextInt(2) + 1));
                    break;
                case 4:
                    spawnItem(serverLevel, pos, new ItemStack(ModItems.NO_OFFHAND_BOW.get(), random.nextInt(1) + 1));
                    break;
                case 5:
                    spawnItem(serverLevel, pos, new ItemStack(ModItems.CAT_SWORD.get(), random.nextInt(1) + 1));
                    break;
                case 6:
                    spawnEntity(serverLevel,pos, ModEntities.NOR.get(),1,1, null);
                    break;
            }
        }
        return InteractionResult.SUCCESS;
    }
}
