package com.cu6.mc_lb.sound;

import com.cu6.mc_lb.MCLB;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MCLB.MOD_ID);

    public static final RegistryObject<SoundEvent> IF_I_WERE_DJ = regiterSoundEvents("if_i_were_dj");
    public static final RegistryObject<SoundEvent> FLOWER_DANCE = regiterSoundEvents("flower_dance");
    public static final RegistryObject<SoundEvent> MAYI = regiterSoundEvents("mayi");
    public static final RegistryObject<SoundEvent> FRIEND = regiterSoundEvents("friend");
    public static final RegistryObject<SoundEvent> HEADSHOOT = regiterSoundEvents("headshoot");



    private static RegistryObject<SoundEvent> regiterSoundEvents(String name) {
        return SOUND_EVENTS.register(name,()->SoundEvent.createVariableRangeEvent(new ResourceLocation(MCLB.MOD_ID,name)));
    }
    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
