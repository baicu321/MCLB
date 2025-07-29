package com.cu6.mc_lb.item;

import com.cu6.mc_lb.MCLB;
import com.cu6.mc_lb.block.ModBlocks;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    ZI_MIN("zi_min",999,new int[]{3,8,6,3},25,
            SoundEvents.ARMOR_EQUIP_GOLD,1f,1f,()->Ingredient.of(ModBlocks.ZIMINLUCKYBLOCK.get())),
    YUSHAN("yushan",999,new int[]{3,8,6,3},25,
    SoundEvents.ARMOR_EQUIP_GOLD,1f,1f,()->Ingredient.of(ModBlocks.YUSHANLUCKYBLOCK.get())),
    MOON_BOOS("moon_boos",999,new int[]{3,8,6,3},25,
            SoundEvents.ARMOR_EQUIP_GOLD,1f,1f,()->Ingredient.of(ModBlocks.MOONBOOSLUCKYBLOCK.get())),
    XIAOBEN("xiaoben",999,new int[]{3,8,6,3},25,
            SoundEvents.ARMOR_EQUIP_GOLD,1f,1f,()->Ingredient.of(ModBlocks.XIAOBENLUCKYBLOCK.get())),
    XIAOTIAN("xiaotian",999,new int[]{3,8,6,3},25,
    SoundEvents.ARMOR_EQUIP_GOLD,1f,1f,()->Ingredient.of(ModBlocks.XIAOTIANLUCKYBLOCK.get())),
    TIANQI("tianqi",999,new int[]{3,8,6,3},25,
            SoundEvents.ARMOR_EQUIP_GOLD,1f,1f,()->Ingredient.of(ModBlocks.TIANQILUCKYBLOCK.get())),
    NOR("nor",999,new int[]{3,8,6,3},25,
            SoundEvents.ARMOR_EQUIP_GOLD,1f,1f,()->Ingredient.of(ModBlocks.NORLUCKYBLOCK.get())),
    DIGE("dige",999,new int[]{3,8,6,3},25,
            SoundEvents.ARMOR_EQUIP_GOLD,1f,1f,()->Ingredient.of(ModBlocks.DIGELUCKYBLOCK.get())),
    UNCLE_RED("uncle_red",999,new int[]{3,8,6,3},25,
            SoundEvents.ARMOR_EQUIP_GOLD,1f,1f,()->Ingredient.of(ModBlocks.LUCKYBLOCK.get()));
    private final String name;
    private final int durabiltyMultiplier;
    private final int[] protectionAmounts;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILTY = {11,16,16,13};

    ModArmorMaterials(String name, int durabiltyMultiplier, int[] protectionAmounts, int enchantmentValue, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabiltyMultiplier = durabiltyMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return BASE_DURABILTY[type.ordinal()] * this.durabiltyMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return MCLB.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
