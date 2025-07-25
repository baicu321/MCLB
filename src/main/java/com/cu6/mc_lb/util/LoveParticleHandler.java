package com.cu6.mc_lb.util;

import com.cu6.mc_lb.MCLB;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.ServerLifecycleHooks;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = MCLB.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LoveParticleHandler {

    private static final Map<UUID, Integer> activeLoveEffects = new HashMap<>();


    public static void addLoveEffect(ServerPlayer player, int durationSeconds) {

        int durationTicks = durationSeconds * 20;
        activeLoveEffects.put(player.getUUID(), durationTicks);
    }

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        activeLoveEffects.entrySet().removeIf(entry -> {
            UUID playerUUID = entry.getKey();
            int remainingTicks = entry.getValue() - 1;


            ServerLevel level = ServerLifecycleHooks.getCurrentServer().overworld();
            ServerPlayer player = (ServerPlayer) level.getPlayerByUUID(playerUUID);


            if (player == null || !player.isAlive()) {
                return true;
            }


            entry.setValue(remainingTicks);


            if (remainingTicks % 5 == 0) {
                spawnLoveParticles(player);
            }


            return remainingTicks <= 0;
        });
    }


    private static void spawnLoveParticles(ServerPlayer player) {
        ServerLevel level = (ServerLevel) player.level();
        Vec3 pos = player.position();


        int particleCount = 1 + level.random.nextInt(3);

        for (int i = 0; i < particleCount; i++) {

            double offsetX = (level.random.nextDouble() - 0.5) * player.getBbWidth() * 1.2;
            double offsetY = level.random.nextDouble() * player.getBbHeight();
            double offsetZ = (level.random.nextDouble() - 0.5) * player.getBbWidth() * 1.2;


            double motionY = 0.05 + level.random.nextDouble() * 0.1;


            level.sendParticles(
                    ParticleTypes.HEART,
                    pos.x + offsetX,
                    pos.y + offsetY,
                    pos.z + offsetZ,
                    1,
                    0, 0, 0,
                    motionY
            );
        }
    }
}