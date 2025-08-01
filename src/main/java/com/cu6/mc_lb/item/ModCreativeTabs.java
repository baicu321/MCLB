package com.cu6.mc_lb.item;

import com.cu6.mc_lb.MCLB;
import com.cu6.mc_lb.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MCLB.MOD_ID);


    public static final RegistryObject<CreativeModeTab> MCLB_TAB = CREATIVE_MODE_TABS.register("mclb.tab",
            ()-> CreativeModeTab.builder().icon(()-> new ItemStack(ModBlocks.MC_LUCKYBLOCK.get()))
                    .title(Component.translatable("creativetab.mclb_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.MC_LUCKYBLOCK.get());
                        output.accept(ModItems.FLOWER_DANCE.get());
                        //zi_min
                        output.accept(ModBlocks.ZIMINLUCKYBLOCK.get());
                        output.accept(ModItems.ZI_MIN_HELMET.get());
                        output.accept(ModItems.ZI_MIN_CHESTPLATE.get());
                        output.accept(ModItems.ZI_MIN_LEGGINGS.get());
                        output.accept(ModItems.ZI_MIN_BOOTS.get());
                        output.accept(ModItems.GOD_PICKAXE.get());
                        output.accept(ModItems.HIT_MAYI.get());
                        output.accept(ModItems.STONE_NUGGET.get());
                        //yushan
                        output.accept(ModBlocks.YUSHANLUCKYBLOCK.get());
                        output.accept(ModItems.YUSHAN_HELMET.get());
                        output.accept(ModItems.YUSHAN_CHESTPLATE.get());
                        output.accept(ModItems.YUSHAN_LEGGINGS.get());
                        output.accept(ModItems.YUSHAN_BOOTS.get());
                        //moonboos
                        output.accept(ModBlocks.MOONBOOSLUCKYBLOCK.get());
                        output.accept(ModItems.MOON_BOOS_HELMET.get());
                        output.accept(ModItems.MOON_BOOS_CHESTPLATE.get());
                        output.accept(ModItems.MOON_BOOS_LEGGINGS.get());
                        output.accept(ModItems.MOON_BOOS_BOOTS.get());
                        output.accept(ModItems.BOOS_SWORD.get());
                        //xiaoben
                        output.accept(ModBlocks.XIAOBENLUCKYBLOCK.get());
                        output.accept(ModItems.XIAOBEN_HELMET.get());
                        output.accept(ModItems.XIAOBEN_CHESTPLATE.get());
                        output.accept(ModItems.XIAOBEN_LEGGINGS.get());
                        output.accept(ModItems.XIAOBEN_BOOTS.get());
                        output.accept(ModItems.CHERRY_RADISH.get());
                        //xiaotian
                        output.accept(ModBlocks.XIAOTIANLUCKYBLOCK.get());
                        output.accept(ModItems.XIAOTIAN_HELMET.get());
                        output.accept(ModItems.XIAOTIAN_CHESTPLATE.get());
                        output.accept(ModItems.XIAOTIAN_LEGGINGS.get());
                        output.accept(ModItems.XIAOTIAN_BOOTS.get());
                        output.accept(ModItems.MISSILE.get());
                        //tianqi
                        output.accept(ModBlocks.TIANQILUCKYBLOCK.get());
                        output.accept(ModItems.TIANQI_HELMET.get());
                        output.accept(ModItems.TIANQI_CHESTPLATE.get());
                        output.accept(ModItems.TIANQI_LEGGINGS.get());
                        output.accept(ModItems.TIANQI_BOOTS.get());
                        output.accept(ModItems.MUSIC_DISC_DJ.get());
                        //nor
                        output.accept(ModBlocks.NORLUCKYBLOCK.get());
                        output.accept(ModItems.NOR_HELMET.get());
                        output.accept(ModItems.NOR_CHESTPLATE.get());
                        output.accept(ModItems.NOR_LEGGINGS.get());
                        output.accept(ModItems.NOR_BOOTS.get());
                        output.accept(ModItems.NO_OFFHAND_BOW.get());
                        output.accept(ModItems.CHUIBING.get());
                        output.accept(ModItems.CAT_SWORD.get());
                        //dige
                        output.accept(ModBlocks.DIGELUCKYBLOCK.get());
                        output.accept(ModItems.DIGE_HELMET.get());
                        output.accept(ModItems.DIGE_CHESTPLATE.get());
                        output.accept(ModItems.DIGE_LEGGINGS.get());
                        output.accept(ModItems.DIGE_BOOTS.get());
                        //uncle_red
                        output.accept(ModBlocks.UNCLEREDLUCKYBLOCK.get());
                        output.accept(ModItems.UNCLE_RED_HELMET.get());
                        output.accept(ModItems.UNCLE_RED_CHESTPLATE.get());
                        output.accept(ModItems.UNCLE_RED_LEGGINGS.get());
                        output.accept(ModItems.UNCLE_RED_BOOTS.get());
                        output.accept(ModItems.MASTER_SWORD.get());
                        //wuge
                        output.accept(ModBlocks.WUGELUCKYBLOCK.get());
                        output.accept(ModItems.WUGE_HELMET.get());
                        output.accept(ModItems.WUGE_CHESTPLATE.get());
                        output.accept(ModItems.WUGE_LEGGINGS.get());
                        output.accept(ModItems.WUGE_BOOTS.get());
                        //dachengzi
                        output.accept(ModBlocks.DACHENGZILUCKYBLOCK.get());
                        output.accept(ModItems.DACHENGZI_HELMET.get());
                        output.accept(ModItems.DACHENGZI_CHESTPLATE.get());
                        output.accept(ModItems.DACHENGZI_LEGGINGS.get());
                        output.accept(ModItems.DACHENGZI_BOOTS.get());
                    })



                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
