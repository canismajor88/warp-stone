package com.canismajor88.init;

import com.canismajor88.WarpStone.WarpStone;
import com.canismajor88.objects.blocks.CrudeWarpStoneOre;
import com.canismajor88.objects.blocks.WarpStoneOre;
import net.minecraft.block.Block;
import net.minecraft.block.FurnaceBlock;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid= WarpStone.MOD_ID,bus= Mod.EventBusSubscriber.Bus.MOD)//allows for class to have events for forge to load into game
@ObjectHolder(WarpStone.MOD_ID)
class BlockInit {
    public static final FurnaceBlock warp_stone_furnace=null;
    public static final OreBlock crude_warp_stone_ore=null;
    public static final OreBlock warp_stone_ore=null;
    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event)
    {
        event.getRegistry().register(new CrudeWarpStoneOre(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(5.0f,6.0f)
                .sound(SoundType.STONE)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE)).
                setRegistryName("crude_warp_stone_ore"));
        event.getRegistry().register(new WarpStoneOre(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(5.0f,6.0f)
                .sound(SoundType.STONE)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE)).
                setRegistryName("warp_stone_ore"));

    }
    @SubscribeEvent
    public static void registerBlockItems(final RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(new BlockItem(crude_warp_stone_ore,new Item.Properties()
                .group(ItemGroup.BUILDING_BLOCKS))
                .setRegistryName("crude_warp_stone_ore"));
        event.getRegistry().register(new BlockItem(warp_stone_ore,new Item.Properties()
                .group(ItemGroup.BUILDING_BLOCKS))
                .setRegistryName("warp_stone_ore"));

    }
}
