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
                        output.accept(ModBlocks.LUCKYBLOCK.get());
                        output.accept(ModBlocks.ZIMINLUCKYBLOCK.get());
                        output.accept(ModItems.ZI_MIN_HELMET.get());
                        output.accept(ModItems.ZI_MIN_CHESTPLATE.get());
                        output.accept(ModItems.ZI_MIN_LEGGINGS.get());
                        output.accept(ModItems.ZI_MIN_BOOTS.get());



                    })



                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
