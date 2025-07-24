package com.cu6.mc_lb.block;

import com.cu6.mc_lb.MCLB;
import com.cu6.mc_lb.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MCLB.MOD_ID);


    public static final RegistryObject<Block> LUCKYBLOCK = registerBlock("lucky_block",
            ()->new LuckyBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()));
    public static final RegistryObject<Block> ZIMINLUCKYBLOCK = registerBlock("zi_min_luckyblock",
            ()->new ZiMinLuckyBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> YUSHANLUCKYBLOCK = registerBlock("yushan_luckyblock",
            ()->new YuShanLuckyBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> MOONBOOSLUCKYBLOCK = registerBlock("moon_boos_luckyblock",
            ()->new MoonBoosLuckyBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).noOcclusion()));



    public static <T extends Block> RegistryObject<T> registerBlock(String name ,Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }
    public static <T extends Block>RegistryObject<Item> registerBlockItem(String name,RegistryObject<T> block){
        return ModItems.ITEMS.register(name,()-> new BlockItem(block.get(),new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
