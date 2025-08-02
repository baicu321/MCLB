package com.cu6.mc_lb.entity;

import com.cu6.mc_lb.MCLB;
import com.cu6.mc_lb.entity.custom.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MCLB.MOD_ID);

    public static final RegistryObject<EntityType<MCPlayerEntity>> MC_PLAYER =
            ENTITY_TYPES.register("mc_player",()->EntityType.Builder.of(MCPlayerEntity::new, MobCategory.CREATURE)
                    .sized(0.75f,2f)
                    .build("mc_player"));
    public static final RegistryObject<EntityType<ZiMinEntity>> ZI_MIN =
            ENTITY_TYPES.register("zi_min",()->EntityType.Builder.of(ZiMinEntity::new, MobCategory.CREATURE)
                    .sized(0.75f,2f)
                    .build("zi_min"));
    public static final RegistryObject<EntityType<YuShanEntity>> YUSHAN =
            ENTITY_TYPES.register("yushan",()->EntityType.Builder.of(YuShanEntity::new, MobCategory.CREATURE)
                    .sized(0.75f,2f)
                    .build("yushan"));
    public static final RegistryObject<EntityType<MoonBoosEntity>> MOONBOOS =
            ENTITY_TYPES.register("moonboos",()->EntityType.Builder.of(MoonBoosEntity::new, MobCategory.CREATURE)
                    .sized(0.75f,2f)
                    .build("moonboos"));
    public static final RegistryObject<EntityType<XiaoBenEnity>> XIAOBEN =
            ENTITY_TYPES.register("xiaoben",()->EntityType.Builder.of(XiaoBenEnity::new, MobCategory.CREATURE)
                    .sized(0.75f,2f)
                    .build("xiaoben"));
    public static final RegistryObject<EntityType<XiaoTianEntity>> XIAOTIAN =
            ENTITY_TYPES.register("xiaotian",()->EntityType.Builder.of(XiaoTianEntity::new, MobCategory.CREATURE)
                    .sized(0.75f,2f)
                    .build("xiaotian"));
    public static final RegistryObject<EntityType<TianQiEntity>> TIANQI =
            ENTITY_TYPES.register("tianqi",()->EntityType.Builder.of(TianQiEntity::new, MobCategory.CREATURE)
                    .sized(0.75f,2f)
                    .build("tianqi"));
    public static final RegistryObject<EntityType<NorEntity>> NOR =
            ENTITY_TYPES.register("nor",()->EntityType.Builder.of(NorEntity::new, MobCategory.CREATURE)
                    .sized(0.75f,2f)
                    .build("nor"));
    public static final RegistryObject<EntityType<DiGeEntity>> DIGE =
            ENTITY_TYPES.register("dige",()->EntityType.Builder.of(DiGeEntity::new, MobCategory.CREATURE)
                    .sized(0.75f,2f)
                    .build("dige"));
    public static final RegistryObject<EntityType<UncleRedEntity>> UNCLE_RED =
            ENTITY_TYPES.register("uncle_red",()->EntityType.Builder.of(UncleRedEntity::new, MobCategory.CREATURE)
                    .sized(0.75f,2f)
                    .build("uncle_red"));
    public static final RegistryObject<EntityType<DaChengZiEntity>> DACHENGZI=
            ENTITY_TYPES.register("dachengzi",()->EntityType.Builder.of(DaChengZiEntity::new, MobCategory.CREATURE)
                    .sized(0.75f,2f)
                    .build("dachengzi"));
    public static final RegistryObject<EntityType<WuGeEntity>> WUGE=
            ENTITY_TYPES.register("wuge",()->EntityType.Builder.of(WuGeEntity::new, MobCategory.CREATURE)
                    .sized(0.75f,2f)
                    .build("wuge"));


    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
