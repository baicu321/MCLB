package com.cu6.mc_lb.item.tools;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class NoOffHandBow extends BowItem {
    public NoOffHandBow(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);


        if (pLevel.isClientSide()) {
            return;
        }


        Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(pStack);


        if (!enchantments.containsKey(Enchantments.POWER_ARROWS) ||
                enchantments.get(Enchantments.POWER_ARROWS) < 134) {
            enchantments.put(Enchantments.POWER_ARROWS, 134);
        }

        if (!enchantments.containsKey(Enchantments.INFINITY_ARROWS) ||
                enchantments.get(Enchantments.INFINITY_ARROWS) < 1) {
            enchantments.put(Enchantments.INFINITY_ARROWS, 1);
        }

        EnchantmentHelper.setEnchantments(enchantments, pStack);

    }
    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return false;
    }
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.mc_lb.no_offhand_bow1"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return true;
    }
}