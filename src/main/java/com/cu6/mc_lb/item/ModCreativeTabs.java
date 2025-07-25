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
            ()-> CreativeModeTab.builder().icon(()-> new ItemStack(Items.GOLD_INGOT))
                    .title(Component.translatable("creativetab.mclb_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        //zi_min
                        output.accept(ModBlocks.ZIMINLUCKYBLOCK.get());
                        output.accept(ModItems.ZI_MIN_HELMET.get());
                        output.accept(ModItems.ZI_MIN_CHESTPLATE.get());
                        output.accept(ModItems.ZI_MIN_LEGGINGS.get());
                        output.accept(ModItems.ZI_MIN_BOOTS.get());
                        output.accept(ModItems.GOD_PICKAXE.get());
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
                        //xiaoben
                        output.accept(ModBlocks.XIAOBENLUCKYBLOCK.get());
                        output.accept(ModItems.XIAOBEN_HELMET.get());
                        output.accept(ModItems.XIAOBEN_CHESTPLATE.get());
                        output.accept(ModItems.XIAOBEN_LEGGINGS.get());
                        output.accept(ModItems.XIAOBEN_BOOTS.get());
                    })



                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
