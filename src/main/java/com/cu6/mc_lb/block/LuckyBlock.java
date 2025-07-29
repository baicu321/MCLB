package com.cu6.mc_lb.block;

import com.cu6.mc_lb.MCLB;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.registries.ForgeRegistries;

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
    public void spawnItem(ServerLevel level, BlockPos pos, ItemStack stack) {
        ItemEntity itemEntity = new ItemEntity(level,
                pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                stack);
        itemEntity.setDeltaMovement(
                (level.getRandom().nextFloat() - 0.5) * 0.7,
                (level.getRandom().nextFloat() * 0.5) * 0.7,
                (level.getRandom().nextFloat() - 0.5) * 0.7);
        level.addFreshEntity(itemEntity);
    }
    //生成生物方法
   public <T extends Entity> void spawnEntity(
            ServerLevel level, BlockPos pos, EntityType<T> entityType,
            int minCount, int maxCount, Component customName) {

        RandomSource random = level.getRandom();
        int count = minCount + random.nextInt(maxCount - minCount + 1);

        for (int i = 0; i < count; i++) {
            double offsetX = (random.nextDouble() - 0.5) * 2.0;
            double offsetZ = (random.nextDouble() - 0.5) * 2.0;

            BlockPos spawnPos = pos.offset((int) offsetX, 0, (int) offsetZ);

            T entity = entityType.create(level);
            if (entity != null) {
                entity.moveTo(spawnPos.getX() + 0.5, spawnPos.getY(), spawnPos.getZ() + 0.5);
                if (customName != null) {
                    entity.setCustomName((Component) customName);
                    entity.setCustomNameVisible(true);
                }

                if (entity instanceof Mob) {
                    ((Mob) entity).finalizeSpawn(level, level.getCurrentDifficultyAt(spawnPos),
                            MobSpawnType.MOB_SUMMONED, null, null);
                }

                level.addFreshEntity(entity);
            }
        }
    }
    //放置流体方法
    public void spawnFluid(ServerLevel level, BlockPos pos, Fluid fluid, int amount) {

        if (fluid == null || fluid.isSame(Fluids.EMPTY)) {
            return;
        }


        BlockState targetState = level.getBlockState(pos);
        if (!targetState.canBeReplaced()) {

            pos = pos.above();
            targetState = level.getBlockState(pos);
            if (!targetState.canBeReplaced()) {
                return;
            }
        }


        if (fluid.isSame(Fluids.WATER)) {
            level.setBlock(pos, Blocks.WATER.defaultBlockState(), 3);
        } else if (fluid.isSame(Fluids.LAVA)) {
            level.setBlock(pos, Blocks.LAVA.defaultBlockState(), 3);
        } else {

            if (fluid.defaultFluidState().createLegacyBlock().canSurvive(level, pos)) {
                level.setBlock(pos, fluid.defaultFluidState().createLegacyBlock(), 3);
            }
        }

        level.playSound(null, pos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
    }
    //放置结构方法
    public void placeStructure(ServerLevel level, BlockPos pos, ResourceLocation structureLocation, Rotation rotation) {
        StructureTemplateManager structureManager = level.getStructureManager();
        StructureTemplate template = structureManager.getOrCreate(structureLocation);

        if (template != null) {

            StructurePlaceSettings settings = new StructurePlaceSettings()
                    .setRotation(rotation)
                    .setMirror(Mirror.NONE)
                    .setIgnoreEntities(false)
                    .addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK);


            BlockPos offsetPos = pos.offset(-template.getSize().getX() / 2, 0, -template.getSize().getZ() / 2);


            template.placeInWorld(level, offsetPos, offsetPos, settings, level.random, 3);


            level.playSound(null, pos, SoundEvents.STONE_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
        }
    }
    // 给予玩家状态效果
    public void applyEffectToPlayer(ServerPlayer player, MobEffectInstance effectInstance) {
        if (player.hasEffect(effectInstance.getEffect())) {
            MobEffectInstance existingEffect = player.getEffect(effectInstance.getEffect());
            if (existingEffect != null) {
                int newAmplifier = Math.max(existingEffect.getAmplifier(), effectInstance.getAmplifier());
                int newDuration = existingEffect.getDuration() + effectInstance.getDuration();
                MobEffectInstance newEffect = new MobEffectInstance(
                        effectInstance.getEffect(),
                        newDuration,
                        newAmplifier,
                        effectInstance.isAmbient(),
                        effectInstance.isVisible(),
                        effectInstance.showIcon()
                );

                player.addEffect(newEffect);
            }
        } else {
            player.addEffect(effectInstance);
        }
    }
    //播放音频
    public static void playSound(ServerPlayer player, SoundEvent soundEvent, SoundSource category, float volume, float pitch) {
        if (player != null && player.level() instanceof ServerLevel serverLevel) {
            serverLevel.playSound(null, player.blockPosition(), soundEvent, category, volume, pitch);
        }
    }

    public static void playCustomSound(ServerPlayer player, String soundName, SoundSource category, float volume, float pitch) {
        ResourceLocation soundLocation = new ResourceLocation(MCLB.MOD_ID, soundName);
        SoundEvent soundEvent = ForgeRegistries.SOUND_EVENTS.getValue(soundLocation);

        if (soundEvent != null) {
            playSound(player, soundEvent, category, volume, pitch);
        }
    }
}
