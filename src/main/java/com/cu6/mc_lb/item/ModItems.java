package com.cu6.mc_lb.item;

import com.cu6.mc_lb.MCLB;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MCLB.MOD_ID);
//zi_min
        public static final RegistryObject<Item> ZI_MIN_HELMET = ITEMS.register("zi_min_helmet",
        ()-> new ArmorItem(ModArmorMaterials.ZI_MIN,ArmorItem.Type.HELMET,new Item.Properties()));
        public static final RegistryObject<Item> ZI_MIN_CHESTPLATE = ITEMS.register("zi_min_chestplate",
        ()-> new ArmorItem(ModArmorMaterials.ZI_MIN,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
        public static final RegistryObject<Item> ZI_MIN_LEGGINGS = ITEMS.register("zi_min_leggings",
        ()-> new ArmorItem(ModArmorMaterials.ZI_MIN,ArmorItem.Type.LEGGINGS,new Item.Properties()));
        public static final RegistryObject<Item> ZI_MIN_BOOTS = ITEMS.register("zi_min_boots",
        ()-> new ArmorItem(ModArmorMaterials.ZI_MIN,ArmorItem.Type.BOOTS,new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
