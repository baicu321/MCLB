package com.cu6.mc_lb.villager;

import com.cu6.mc_lb.MCLB;
import com.google.common.collect.ImmutableSet;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModVillagers {

    public static final DeferredRegister<PoiType> POI_TYPE =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, MCLB.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS,MCLB.MOD_ID);

    public static final RegistryObject<PoiType> DJ_POI = POI_TYPE.register("dj_poi",
            ()->new PoiType(ImmutableSet.copyOf(Blocks.NOTE_BLOCK.getStateDefinition().getPossibleStates()),
                    1,1 ));

    public static final RegistryObject<VillagerProfession> DJ =
            VILLAGER_PROFESSIONS.register("dj",() -> new VillagerProfession("dj",
                    holder -> holder.get() == DJ_POI.get(),holder -> holder.get() == DJ_POI.get(),
                    ImmutableSet.of(),ImmutableSet.of(), SoundEvents.NOTE_BLOCK_BASS.get()));

    public static void register(IEventBus eventBus){
        POI_TYPE.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }

}
