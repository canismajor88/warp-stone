package com.canismajor88.init;

import com.canismajor88.WarpStone.WarpStone;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

import java.util.ResourceBundle;


public class SoundsInit {
    static ResourceLocation locationBladeActivation= new ResourceLocation("warpstonecm","blade_activation");
    static ResourceLocation locationOverDrive= new ResourceLocation("warpstonecm","overdrive");
 public static final DeferredRegister<SoundEvent> SOUNDS= new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS,WarpStone.MOD_ID);
 public static final RegistryObject<SoundEvent> BLADE_ACTIVATION = SOUNDS.register("blade_activation",()-> new SoundEvent(locationBladeActivation));
    public static final RegistryObject<SoundEvent> WARP_STONE_DRILL_OVERDRIVE = SOUNDS.register("warp_stone_drill_overdrive",()-> new SoundEvent(locationOverDrive));
}
