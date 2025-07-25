package com.cu6.mc_lb.event;


import com.cu6.mc_lb.MCLB;
import com.cu6.mc_lb.villager.ModVillagers;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = MCLB.MOD_ID)
public class ModEvents {

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
        }

    }
}
