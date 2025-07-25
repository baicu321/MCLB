package com.cu6.mc_lb.util;

import com.cu6.mc_lb.MCLB;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.*;

@Mod.EventBusSubscriber(modid = MCLB.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DelayedMessageSystem {
    // 存储待发送的消息队列 (玩家UUID -> 消息队列)
    private static final Map<UUID, Queue<MessageEntry>> messageQueues = new HashMap<>();

    // 添加延迟消息
    public static void addMessage(ServerPlayer player, int delayTicks, Component message) {
        UUID playerId = player.getUUID();
        messageQueues.computeIfAbsent(playerId, k -> new LinkedList<>())
                .add(new MessageEntry(delayTicks, message));
    }

    // 添加一系列延迟消息（对话效果）
    public static void addConversation(ServerPlayer player, int delayBetweenMessages, Component... messages) {
        UUID playerId = player.getUUID();
        Queue<MessageEntry> queue = messageQueues.computeIfAbsent(playerId, k -> new LinkedList<>());

        int currentDelay = 0;
        for (Component message : messages) {
            queue.add(new MessageEntry(currentDelay, message));
            currentDelay += delayBetweenMessages;
        }
    }

    // 服务器每刻更新
    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        // 复制一份keySet，避免迭代过程中修改Map
        List<UUID> playerIds = new ArrayList<>(messageQueues.keySet());

        for (UUID playerId : playerIds) {
            Queue<MessageEntry> queue = messageQueues.get(playerId);
            if (queue == null || queue.isEmpty()) {
                messageQueues.remove(playerId);
                continue;
            }

            // 获取当前服务器
            net.minecraft.server.MinecraftServer server =
                    net.minecraftforge.server.ServerLifecycleHooks.getCurrentServer();

            // 获取玩家实体
            ServerPlayer player = server.getPlayerList().getPlayer(playerId);
            if (player == null) {
                messageQueues.remove(playerId);
                continue;
            }

            // 检查队列中的第一条消息是否应该发送
            MessageEntry entry = queue.peek();
            if (entry.ticksRemaining <= 0) {
                // 发送消息
                player.sendSystemMessage(entry.message);
                queue.poll(); // 移除已发送的消息
            } else {
                // 减少延迟计数
                entry.ticksRemaining--;
            }
        }
    }

    // 消息条目类
    private static class MessageEntry {
        int ticksRemaining;
        Component message;

        public MessageEntry(int ticksRemaining, Component message) {
            this.ticksRemaining = ticksRemaining;
            this.message = message;
        }
    }
}