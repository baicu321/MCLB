package com.cu6.mc_lb.item.tools;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class GodPickAxe extends PickaxeItem {
    private static final Map<Enchantment, Integer> ENCHANTMENTS = new HashMap<>();

    static {
        ENCHANTMENTS.put(Enchantments.BLOCK_FORTUNE, 10);
        ENCHANTMENTS.put(Enchantments.BLOCK_EFFICIENCY, 10);
        ENCHANTMENTS.put(Enchantments.MENDING, 1);
        ENCHANTMENTS.put(Enchantments.UNBREAKING, 10);
    }

    public GodPickAxe(Tier tier, int attackDamageModifier, float attackSpeedModifier, Properties properties) {
        super(tier, attackDamageModifier, attackSpeedModifier, properties);
    }

@Override
public ItemStack getDefaultInstance() {
    ItemStack stack = super.getDefaultInstance();
    for (Map.Entry<Enchantment, Integer> entry : ENCHANTMENTS.entrySet()) {
        stack.enchant(entry.getKey(), entry.getValue());
    }
    return stack;
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
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.mc_lb.god_pickaxe1"));
        pTooltipComponents.add(Component.translatable("tooltip.mc_lb.god_pickaxe2"));
        pTooltipComponents.add(Component.translatable("tooltip.mc_lb.god_pickaxe3"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return true;
    }
}
