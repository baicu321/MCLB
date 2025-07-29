package com.cu6.mc_lb.item.tools;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MasterSword extends SwordItem {


    public MasterSword(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        boolean result = super.hurtEnemy(stack, target, attacker);


        if (result && !attacker.level().isClientSide()) {
            ServerLevel level = (ServerLevel) attacker.level();
            BlockPos targetPos = target.blockPosition();


            LightningBolt lightning = EntityType.LIGHTNING_BOLT.create(level);
            if (lightning != null) {

                lightning.moveTo(Vec3.atBottomCenterOf(targetPos));

                lightning.setCause(attacker instanceof ServerPlayer ? (ServerPlayer) attacker : null);

                level.addFreshEntity(lightning);
            }
        }

        return result;
    }
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.mc_lb.mastersword"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }


    private <T extends Entity> void spawnEntity(
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
}
