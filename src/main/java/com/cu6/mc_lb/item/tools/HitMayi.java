package com.cu6.mc_lb.item.tools;

import com.cu6.mc_lb.MCLB;
import net.minecraft.client.telemetry.TelemetryProperty;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HitMayi extends Item {
    public HitMayi(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof ServerPlayer player){
            if (!player.gameMode.getGameModeForPlayer().isCreative()){
                CompoundTag tag = player.getPersistentData();
                long lastAttackTime = tag.getLong("LastHitMayiAttack");
                long currentTime = player.level().getGameTime();

                if (currentTime - lastAttackTime < 1940) {
                    return false;
                }


                tag.putLong("LastHitMayiAttack", currentTime);

                playCustomSound((ServerPlayer) attacker, "friend", SoundSource.PLAYERS, 1.0F, 1.0F);
                attacker.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1940, 1145));
                attacker.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 1940, 2));
            }
            Level level = target.level();
            Vec3 position = target.position();
            level.explode(player, position.x(), position.y()+1, position.z(),
                    0.0F, Level.ExplosionInteraction.TNT);
            playCustomSound((ServerPlayer) attacker, "headshoot", SoundSource.PLAYERS, 1.0F, 1.0F);
            target.setHealth(0);
        }
        return super.hurtEnemy(stack, target, attacker);
    }
    public static void playSound(ServerPlayer player, SoundEvent soundEvent, SoundSource category, float volume, float pitch) {
        if (player != null && player.level() instanceof ServerLevel serverLevel) {
            serverLevel.playSound(null, player.blockPosition(), soundEvent, category, volume, pitch);
        }
    }

    private static void playCustomSound(ServerPlayer player, String soundName, SoundSource category, float volume, float pitch) {
        ResourceLocation soundLocation = new ResourceLocation(MCLB.MOD_ID, soundName);
        SoundEvent soundEvent = ForgeRegistries.SOUND_EVENTS.getValue(soundLocation);

        if (soundEvent != null) {
            playSound(player, soundEvent, category, volume, pitch);
        }
    }
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.mc_lb.hitmayi"));
        pTooltipComponents.add(Component.translatable("tooltip.mc_lb.hitmayi1"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
