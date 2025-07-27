package com.cu6.mc_lb.item.tools;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MissileItem extends Item {
    public MissileItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!level.isClientSide()) {

            player.getCommandSenderWorld().getEntitiesOfClass(ArmorStand.class,
                            player.getBoundingBox().inflate(2.0D),
                            armorStand -> armorStand.isAlive() &&
                                    armorStand.getItemBySlot(EquipmentSlot.HEAD).isEmpty())
                    .forEach(armorStand -> {

                        level.explode(null, armorStand.getX(), armorStand.getY(), armorStand.getZ(),
                                100.0F, Level.ExplosionInteraction.TNT);

                        if (!player.getAbilities().instabuild) {
                            stack.shrink(1);
                        }
                    });
        }
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.mc_lb.missile"));
        pTooltipComponents.add(Component.translatable("tooltip.mc_lb.missile1"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
