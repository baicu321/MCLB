package com.cu6.mc_lb.item;

import com.cu6.mc_lb.MCLB;
import com.cu6.mc_lb.item.tools.GodPickAxe;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MCLB.MOD_ID);
//zi_min籽岷
        public static final RegistryObject<Item> ZI_MIN_HELMET = ITEMS.register("zi_min_helmet",
        ()-> new ArmorItem(ModArmorMaterials.ZI_MIN,ArmorItem.Type.HELMET,new Item.Properties()));
        public static final RegistryObject<Item> ZI_MIN_CHESTPLATE = ITEMS.register("zi_min_chestplate",
        ()-> new ArmorItem(ModArmorMaterials.ZI_MIN,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
        public static final RegistryObject<Item> ZI_MIN_LEGGINGS = ITEMS.register("zi_min_leggings",
        ()-> new ArmorItem(ModArmorMaterials.ZI_MIN,ArmorItem.Type.LEGGINGS,new Item.Properties()));
        public static final RegistryObject<Item> ZI_MIN_BOOTS = ITEMS.register("zi_min_boots",
        ()-> new ArmorItem(ModArmorMaterials.ZI_MIN,ArmorItem.Type.BOOTS,new Item.Properties()));
    public static final RegistryObject<Item> STONE_NUGGET = ITEMS.register("stone_nugget",
            ()-> new Item(new Item.Properties()));
        public static final RegistryObject<Item> GOD_PICKAXE = ITEMS.register("god_pickaxe",
                ()-> new GodPickAxe(Tiers.DIAMOND,16,-2.8F,new Item.Properties().durability(1)));
//yushan与山
        public static final RegistryObject<Item> YUSHAN_HELMET = ITEMS.register("yushan_helmet",
        ()-> new ArmorItem(ModArmorMaterials.YUSHAN,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> YUSHAN_CHESTPLATE = ITEMS.register("yushan_chestplate",
            ()-> new ArmorItem(ModArmorMaterials.YUSHAN,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> YUSHAN_LEGGINGS = ITEMS.register("yushan_leggings",
            ()-> new ArmorItem(ModArmorMaterials.YUSHAN,ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> YUSHAN_BOOTS = ITEMS.register("yushan_boots",
            ()-> new ArmorItem(ModArmorMaterials.YUSHAN,ArmorItem.Type.BOOTS,new Item.Properties()));
    //moon_boos明月庄主
    public static final RegistryObject<Item> MOON_BOOS_HELMET = ITEMS.register("moon_boos_helmet",
            ()-> new ArmorItem(ModArmorMaterials.MOON_BOOS,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> MOON_BOOS_CHESTPLATE = ITEMS.register("moon_boos_chestplate",
            ()-> new ArmorItem(ModArmorMaterials.MOON_BOOS,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> MOON_BOOS_LEGGINGS = ITEMS.register("moon_boos_leggings",
            ()-> new ArmorItem(ModArmorMaterials.MOON_BOOS,ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> MOON_BOOS_BOOTS = ITEMS.register("moon_boos_boots",
            ()-> new ArmorItem(ModArmorMaterials.MOON_BOOS,ArmorItem.Type.BOOTS,new Item.Properties()));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
