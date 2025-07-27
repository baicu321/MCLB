package com.cu6.mc_lb.event;


import com.cu6.mc_lb.MCLB;
import com.cu6.mc_lb.item.ModItems;
import com.cu6.mc_lb.villager.ModVillagers;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = MCLB.MOD_ID)
public class ModEvents {
    private static boolean isProcessing = false;
    @SubscribeEvent
    public static void addCutomTrades(VillagerTradesEvent event){

        if (event.getType() == ModVillagers.DJ.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemStack(Items.DIAMOND,1),
                    new ItemStack(Items.MUSIC_DISC_STAL,1),
                    10,20,0
            ));
            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemStack(Items.DIAMOND,1),
                    new ItemStack(Items.MUSIC_DISC_STRAD,1),
                    10,20,0
            ));
            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemStack(Items.DIAMOND,1),
                    new ItemStack(Items.MUSIC_DISC_PIGSTEP,1),
                    10,20,0
            ));
            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemStack(Items.DIAMOND,1),
                    new ItemStack(Items.MUSIC_DISC_RELIC,1),
                    10,20,0
            ));
            trades.get(2).add((entity, randomSource) -> new MerchantOffer(
                    new ItemStack(Items.DIAMOND,2),
                    new ItemStack(ModItems.MUSIC_DISC_DJ.get(),1),
                    10,20,0
            ));
        }

    }
    @SubscribeEvent
    public static void onEquipmentChange(LivingEquipmentChangeEvent event){
        // 只处理玩家
        if (!(event.getEntity() instanceof Player player)) return;

        // 如果是正在处理的操作，跳过
        if (isProcessing) return;

        // 只关心副手槽
        if (event.getSlot() != EquipmentSlot.OFFHAND) return;

        ItemStack newItem = event.getTo();

        // 检测是否是我们的弓
        if (newItem.getItem() == ModItems.NO_OFFHAND_BOW.get()) {
            try {
                // 设置处理标志防止循环
                isProcessing = true;

                // 获取主手物品
                ItemStack mainHandItem = player.getMainHandItem();

                // 如果主手为空，直接移到主手
                if (mainHandItem.isEmpty()) {
                    player.setItemSlot(EquipmentSlot.MAINHAND, newItem.copy());
                    player.setItemSlot(EquipmentSlot.OFFHAND, ItemStack.EMPTY);
                    return;
                }

                // 如果主手有物品，尝试放入玩家物品栏
                if (!player.getInventory().add(newItem.copy())) {
                    // 如果物品栏已满，丢到地上
                    player.drop(newItem.copy(), false);
                }
                // 清空副手
                player.setItemSlot(EquipmentSlot.OFFHAND, ItemStack.EMPTY);

            } finally {
                // 确保标志始终被重置
                isProcessing = false;
            }
        }
    }
}
