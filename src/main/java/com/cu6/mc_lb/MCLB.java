package com.cu6.mc_lb;

import com.cu6.mc_lb.block.ModBlocks;
import com.cu6.mc_lb.entity.ModEntities;
import com.cu6.mc_lb.entity.client.MCPlayerRenderer;
import com.cu6.mc_lb.entity.client.render.*;
import com.cu6.mc_lb.item.ModCreativeTabs;
import com.cu6.mc_lb.item.ModItems;
import com.cu6.mc_lb.sound.ModSounds;
import com.cu6.mc_lb.villager.ModVillagers;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(MCLB.MOD_ID)
public class MCLB
{

    public static final String MOD_ID = "mc_lb";

    private static final Logger LOGGER = LogUtils.getLogger();

    public MCLB()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
        ModVillagers.register(modEventBus);
        ModSounds.register(modEventBus);
        ModEntities.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(ModEntities.MC_PLAYER.get(), MCPlayerRenderer::new);
            EntityRenderers.register(ModEntities.ZI_MIN.get(), ZiMinRenderer::new);
            EntityRenderers.register(ModEntities.YUSHAN.get(), YuShanRenderer::new);
            EntityRenderers.register(ModEntities.MOONBOOS.get(), MoonBoosRenderer::new);
            EntityRenderers.register(ModEntities.XIAOBEN.get(), XiaoBenRenderer::new);
            EntityRenderers.register(ModEntities.XIAOTIAN.get(), XiaoTianRenderer::new);
            EntityRenderers.register(ModEntities.TIANQI.get(), TianQiRenderer::new);
            EntityRenderers.register(ModEntities.NOR.get(), NorRenderer::new);
            EntityRenderers.register(ModEntities.DIGE.get(), DiGeRenderer::new);
            EntityRenderers.register(ModEntities.UNCLE_RED.get(), UncleRedRenderer::new);
            EntityRenderers.register(ModEntities.DACHENGZI.get(), DaChengziRenderer::new);
            EntityRenderers.register(ModEntities.WUGE.get(), WuGeRenderer::new);
        }
    }
}
