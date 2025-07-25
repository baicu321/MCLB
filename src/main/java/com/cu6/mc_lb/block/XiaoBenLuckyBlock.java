package com.cu6.mc_lb.block;

import com.cu6.mc_lb.MCLB;
import com.cu6.mc_lb.item.ModItems;
import com.cu6.mc_lb.util.DelayedMessageSystem;
import com.cu6.mc_lb.util.LoveParticleHandler;
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
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class XiaoBenLuckyBlock extends LuckyBlock{

    public static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

    public XiaoBenLuckyBlock(Properties pProperties) {
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
                    placeStructure(serverLevel,pos,new ResourceLocation(MCLB.MOD_ID,"xiaoben_end"), Rotation.getRandom(random));
                    LightningBolt lightning = EntityType.LIGHTNING_BOLT.create(serverLevel);
                    if (lightning != null) {
                        Vec3 playerPos = player.position();

                        lightning.moveTo(playerPos.x, playerPos.y, playerPos.z);
                        lightning.setVisualOnly(false);

                        serverLevel.addFreshEntityWithPassengers(lightning);
                    }
                    LoveParticleHandler.addLoveEffect(serverPlayer, 32);
                    applyEffectToPlayer(serverPlayer,new MobEffectInstance(MobEffects.LEVITATION,32 * 20, 1));
                    DelayedMessageSystem.addConversation(
                            (ServerPlayer) player,
                            16,
                            Component.literal("§d[小本]在此小本渡劫!"),
                            Component.literal("§d[小本]哎呀渡劫完了过后就像奥特曼一样,慢慢的飘起来"),
                            Component.literal("§d[小本]然后看着小朋友们啊"),
                            Component.literal("§d[小本]好像你们已经不再是小朋友了..."),
                            Component.literal("§d[小本]如果还是小朋友的啊"),
                            Component.literal("§d[小本]应该是我的新粉丝了"),
                            Component.literal("§d[小本]好的啊,我像奥特曼一样看着你"),
                            Component.literal("§d[小本]话说现在的小朋友还看奥特曼吗?"),
                            Component.literal("§d...")
                    );
                    break;
                case 1:
                    spawnItem(serverLevel, pos, new ItemStack(ModItems.XIAOBEN_HELMET.get(), random.nextInt(1) + 1));
                    spawnItem(serverLevel, pos, new ItemStack(ModItems.XIAOBEN_CHESTPLATE.get(), random.nextInt(1) + 1));
                    spawnItem(serverLevel, pos, new ItemStack(ModItems.XIAOBEN_LEGGINGS.get(), random.nextInt(1) + 1));
                    spawnItem(serverLevel, pos, new ItemStack(ModItems.XIAOBEN_BOOTS.get(), random.nextInt(1) + 1));
                    break;
                case 2:
                    spawnEntity(serverLevel,pos,EntityType.ZOMBIE,1,5,null);
            }
        }
        return InteractionResult.SUCCESS;
    }
}
