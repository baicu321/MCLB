package com.cu6.mc_lb.item.tools;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class GodPickAxe extends PickaxeItem {

    public GodPickAxe(Tier tier, int attackDamageModifier, float attackSpeedModifier, Properties properties) {
        super(tier, attackDamageModifier, attackSpeedModifier, properties);
    }

    @Override
    public boolean onDroppedByPlayer(ItemStack item, Player player) {
        item.setCount(0);
        return super.onDroppedByPlayer(item, player);
    }

    @Override
    public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, T entity, Consumer<T> onBroken) {
        stack.setCount(0);
        return super.damageItem(stack, amount, entity, onBroken);
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
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);


        if (pLevel.isClientSide()) {
            return;
        }


        Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(pStack);


        if (!enchantments.containsKey(Enchantments.BLOCK_EFFICIENCY) ||
                enchantments.get(Enchantments.BLOCK_EFFICIENCY) < 10) {
            enchantments.put(Enchantments.BLOCK_EFFICIENCY, 10);
        }

        if (!enchantments.containsKey(Enchantments.BLOCK_FORTUNE) ||
                enchantments.get(Enchantments.BLOCK_FORTUNE) < 10) {
            enchantments.put(Enchantments.BLOCK_FORTUNE, 10);
        }

        if (!enchantments.containsKey(Enchantments.MENDING) ||
                enchantments.get(Enchantments.MENDING) < 1) {
            enchantments.put(Enchantments.MENDING, 1);
        }

        EnchantmentHelper.setEnchantments(enchantments, pStack);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.mc_lb.god_pickaxe1"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return true;
    }
}
