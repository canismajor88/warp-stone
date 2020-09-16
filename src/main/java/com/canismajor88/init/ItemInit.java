package com.canismajor88.init;

import com.canismajor88.WarpStone.WarpStone;
import com.canismajor88.objects.items.WarpStoneOreAnalyser;
import com.canismajor88.objects.items.UnrefinedWarpStoneChunk;
import net.minecraft.item.*;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid= WarpStone.MOD_ID,bus= Mod.EventBusSubscriber.Bus.MOD)//allows for class to have events for forge to load into game
@ObjectHolder(WarpStone.MOD_ID)//tags class as object holder
public class ItemInit {
    public static final Item unrefined_warp_stone_chunk=null;
    public static final Item warp_stone_ore_analyser=null;
    public static final Item warp_stone_ingot=null;
    public  static final Item warp_stone_power_cell=null;
    public static final BucketItem molten_warped_earth_bucket=null;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event)
    {
    event.getRegistry().register(new UnrefinedWarpStoneChunk(new Item.Properties().group(WarpStone.WarpItemGroup.instance)).setRegistryName("unrefined_warp_stone_chunk"));
        event.getRegistry().register(new WarpStoneOreAnalyser(new Item.Properties().group(WarpStone.WarpItemGroup.instance).maxStackSize(1)).setRegistryName("warp_stone_ore_analyser"));
        event.getRegistry().register(new Item(new Item.Properties().group(WarpStone.WarpItemGroup.instance)).setRegistryName("warp_stone_ingot"));
        event.getRegistry().register(new Item(new Item.Properties().group(WarpStone.WarpItemGroup.instance)).setRegistryName("warp_stone_power_cell"));
        event.getRegistry().register(new BucketItem(()->FluidInit.MOLTEN_WARPED_EARTH.get(),new Item.Properties().group(WarpStone.WarpItemGroup.instance)).setRegistryName("molten_warped_earth_bucket"));
    }
}
