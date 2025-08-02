package com.cu6.mc_lb.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

import net.minecraftforge.registries.RegistryObject;

public class ModFoods {
    public static final FoodProperties CHUIBING = new FoodProperties.Builder()
            .alwaysEat().
            effect( ()-> new MobEffectInstance(MobEffects.LUCK,200),1f)
            .nutrition(3)
            .saturationMod(0.3f)
            .build();
    public static final FoodProperties CHERRY_RADISH = new FoodProperties.Builder()
            .alwaysEat()
            .nutrition(0)
            .saturationMod(0)
            .build();
    public static final FoodProperties MIXIAN = new FoodProperties.Builder()
            .alwaysEat()
            .nutrition(8)
            .saturationMod(20)
            .build();
}
