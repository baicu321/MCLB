package com.cu6.mc_lb.entity;

import com.cu6.mc_lb.MCLB;
import com.cu6.mc_lb.entity.custom.MCPlayerEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MCLB.MOD_ID);

    public static final RegistryObject<EntityType<MCPlayerEntity>> MCPLAYER =
            ENTITY_TYPE.register("mc_player",()->EntityType.Builder.of(MCPlayerEntity::new, MobCategory.CREATURE)
                    .sized(1f,2f).build("mc_player"));




    public static void register(IEventBus eventBus){
        ENTITY_TYPE.register(eventBus);
    }
}
