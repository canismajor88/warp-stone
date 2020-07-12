package com.canismajor88.init;

import com.canismajor88.WarpStone.WarpStone;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import java.util.ResourceBundle;

@Mod.EventBusSubscriber(modid= WarpStone.MOD_ID,bus= Mod.EventBusSubscriber.Bus.MOD)//allows for class to have events for forge to load into game
@ObjectHolder(WarpStone.MOD_ID)//tags class as object holder
public class SoundsInit {

    static ResourceLocation location= new ResourceLocation("warpstonecm","blade_activation");
 public static SoundEvent event= new SoundEvent(location);
}
