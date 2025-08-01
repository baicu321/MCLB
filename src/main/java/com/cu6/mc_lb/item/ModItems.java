package com.cu6.mc_lb.item;

import com.cu6.mc_lb.MCLB;
import com.cu6.mc_lb.item.armor.WugeBoots;
import com.cu6.mc_lb.item.tools.*;
import com.cu6.mc_lb.sound.ModSounds;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MCLB.MOD_ID);

    public static final RegistryObject<Item> FLOWER_DANCE = ITEMS.register("flower_dance",
            ()-> new RecordItem(6, ModSounds.FLOWER_DANCE,new Item.Properties().stacksTo(1),3700));
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
        public static final RegistryObject<Item> HIT_MAYI = ITEMS.register("hit_mayi",
                ()->new HitMayi(new Item.Properties()));
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
    public static final RegistryObject<Item> BOOS_SWORD = ITEMS.register("boos_sword",
            ()-> new SwordItem(Tiers.DIAMOND, 4,-1,new Item.Properties()));
    //xiaoben小本
    public static final RegistryObject<Item> XIAOBEN_HELMET = ITEMS.register("xiaoben_helmet",
            ()-> new ArmorItem(ModArmorMaterials.XIAOBEN,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> XIAOBEN_CHESTPLATE = ITEMS.register("xiaoben_chestplate",
            ()-> new ArmorItem(ModArmorMaterials.XIAOBEN,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> XIAOBEN_LEGGINGS = ITEMS.register("xiaoben_leggings",
            ()-> new ArmorItem(ModArmorMaterials.XIAOBEN,ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> XIAOBEN_BOOTS = ITEMS.register("xiaoben_boots",
            ()-> new ArmorItem(ModArmorMaterials.XIAOBEN,ArmorItem.Type.BOOTS,new Item.Properties()));
    public static final RegistryObject<Item> CHERRY_RADISH = ITEMS.register("cherry_radish",
            ()-> new Item(new Item.Properties().food(ModFoods.CHERRY_RADISH)));
    //xiaotian悠然小天
    public static final RegistryObject<Item> XIAOTIAN_HELMET = ITEMS.register("xiaotian_helmet",
            ()-> new ArmorItem(ModArmorMaterials.XIAOTIAN,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> XIAOTIAN_CHESTPLATE = ITEMS.register("xiaotian_chestplate",
            ()-> new ArmorItem(ModArmorMaterials.XIAOTIAN,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> XIAOTIAN_LEGGINGS = ITEMS.register("xiaotian_leggings",
            ()-> new ArmorItem(ModArmorMaterials.XIAOTIAN,ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> XIAOTIAN_BOOTS = ITEMS.register("xiaotian_boots",
            ()-> new ArmorItem(ModArmorMaterials.XIAOTIAN,ArmorItem.Type.BOOTS,new Item.Properties()));
    public static final RegistryObject<Item> MISSILE = ITEMS.register("missile",
            ()-> new MissileItem(new Item.Properties()));
    //tianqi天骐
    public static final RegistryObject<Item> TIANQI_HELMET = ITEMS.register("tianqi_helmet",
            ()-> new ArmorItem(ModArmorMaterials.TIANQI,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> TIANQI_CHESTPLATE = ITEMS.register("tianqi_chestplate",
            ()-> new ArmorItem(ModArmorMaterials.TIANQI,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> TIANQI_LEGGINGS = ITEMS.register("tianqi_leggings",
            ()-> new ArmorItem(ModArmorMaterials.TIANQI,ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> TIANQI_BOOTS = ITEMS.register("tianqi_boots",
            ()-> new ArmorItem(ModArmorMaterials.TIANQI,ArmorItem.Type.BOOTS,new Item.Properties()));
    public static final RegistryObject<Item> MUSIC_DISC_DJ = ITEMS.register("music_disc_dj",
            ()-> new RecordItem(6, ModSounds.IF_I_WERE_DJ,new Item.Properties().stacksTo(1),5260));
    //nor
    public static final RegistryObject<Item> NOR_HELMET = ITEMS.register("nor_helmet",
            ()-> new ArmorItem(ModArmorMaterials.NOR,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> NOR_CHESTPLATE = ITEMS.register("nor_chestplate",
            ()-> new ArmorItem(ModArmorMaterials.NOR,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> NOR_LEGGINGS = ITEMS.register("nor_leggings",
            ()-> new ArmorItem(ModArmorMaterials.NOR,ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> NOR_BOOTS = ITEMS.register("nor_boots",
            ()-> new ArmorItem(ModArmorMaterials.NOR,ArmorItem.Type.BOOTS,new Item.Properties()));
    public static final RegistryObject<Item> CHUIBING = ITEMS.register("chuibing",
            ()-> new Item(new Item.Properties().food(ModFoods.CHUIBING)));
    public static final RegistryObject<Item> NO_OFFHAND_BOW = ITEMS.register("no_offhand_bow",
            () -> new NoOffHandBow(new Item.Properties().durability(384)));
    public static final RegistryObject<Item> CAT_SWORD = ITEMS.register("cat_sword",
            () -> new CatSword(Tiers.DIAMOND, 3,-2.4F,new Item.Properties().durability(1561)));
    //dige迪哥
    public static final RegistryObject<Item> DIGE_HELMET = ITEMS.register("dige_helmet",
            ()-> new ArmorItem(ModArmorMaterials.DIGE,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> DIGE_CHESTPLATE = ITEMS.register("dige_chestplate",
            ()-> new ArmorItem(ModArmorMaterials.DIGE,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> DIGE_LEGGINGS = ITEMS.register("dige_leggings",
            ()-> new ArmorItem(ModArmorMaterials.DIGE,ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> DIGE_BOOTS = ITEMS.register("dige_boots",
            ()-> new ArmorItem(ModArmorMaterials.DIGE,ArmorItem.Type.BOOTS,new Item.Properties()));
    //uncle_red红叔
    public static final RegistryObject<Item> UNCLE_RED_HELMET = ITEMS.register("uncle_red_helmet",
            ()-> new ArmorItem(ModArmorMaterials.UNCLE_RED,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> UNCLE_RED_CHESTPLATE = ITEMS.register("uncle_red_chestplate",
            ()-> new ArmorItem(ModArmorMaterials.UNCLE_RED,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> UNCLE_RED_LEGGINGS = ITEMS.register("uncle_red_leggings",
            ()-> new ArmorItem(ModArmorMaterials.UNCLE_RED,ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> UNCLE_RED_BOOTS = ITEMS.register("uncle_red_boots",
            ()-> new ArmorItem(ModArmorMaterials.UNCLE_RED,ArmorItem.Type.BOOTS,new Item.Properties()));
    public static final RegistryObject<Item> MASTER_SWORD = ITEMS.register("master_sword",
            ()-> new MasterSword(Tiers.NETHERITE,5,-2.2F,new Item.Properties().durability(2000)));
    //wuge五歌
    public static final RegistryObject<Item> WUGE_HELMET = ITEMS.register("wuge_helmet",
            ()-> new ArmorItem(ModArmorMaterials.WUGE,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> WUGE_CHESTPLATE = ITEMS.register("wuge_chestplate",
            ()-> new ArmorItem(ModArmorMaterials.WUGE,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> WUGE_LEGGINGS = ITEMS.register("wuge_leggings",
            ()-> new ArmorItem(ModArmorMaterials.WUGE,ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> WUGE_BOOTS = ITEMS.register("wuge_boots",
            ()-> new WugeBoots(ModArmorMaterials.WUGE,ArmorItem.Type.BOOTS,new Item.Properties()));
    //dachengzi大橙子
    public static final RegistryObject<Item> DACHENGZI_HELMET = ITEMS.register("dachengzi_helmet",
            ()-> new ArmorItem(ModArmorMaterials.DACHENGZI,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> DACHENGZI_CHESTPLATE = ITEMS.register("dachengzi_chestplate",
            ()-> new ArmorItem(ModArmorMaterials.DACHENGZI,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> DACHENGZI_LEGGINGS = ITEMS.register("dachengzi_leggings",
            ()-> new ArmorItem(ModArmorMaterials.DACHENGZI,ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> DACHENGZI_BOOTS = ITEMS.register("dachengzi_boots",
            ()-> new ArmorItem(ModArmorMaterials.DACHENGZI,ArmorItem.Type.BOOTS,new Item.Properties()));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
