package com.cu6.mc_lb.event;


import com.cu6.mc_lb.MCLB;
import com.cu6.mc_lb.entity.ModEntities;
import com.cu6.mc_lb.entity.custom.*;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MCLB.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.MC_PLAYER.get(), MCPlayerEntity.createAttributes().build());
        event.put(ModEntities.ZI_MIN.get(), ZiMinEntity.createAttributes().build());
        event.put(ModEntities.YUSHAN.get(), YuShanEntity.createAttributes().build());
        event.put(ModEntities.MOONBOOS.get(), MoonBoosEntity.createAttributes().build());
        event.put(ModEntities.XIAOBEN.get(), XiaoBenEnity.createAttributes().build());
        event.put(ModEntities.XIAOTIAN.get(), XiaoTianEntity.createAttributes().build());
        event.put(ModEntities.TIANQI.get(), TianQiEntity.createAttributes().build());
        event.put(ModEntities.NOR.get(), NorEntity.createAttributes().build());
        event.put(ModEntities.DIGE.get(), DiGeEntity.createAttributes().build());
        event.put(ModEntities.UNCLE_RED.get(), UncleRedEntity.createAttributes().build());
        event.put(ModEntities.DACHENGZI.get(), DaChengZiEntity.createAttributes().build());
        event.put(ModEntities.WUGE.get(), WuGeEntity.createAttributes().build());
    }

}
