package com.canismajor88.init;

import com.canismajor88.WarpStone.WarpStone;
import com.canismajor88.objects.blocks.CrudeWarpStoneOre;
import com.canismajor88.objects.blocks.WarpStoneCrystal;
import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid= WarpStone.MOD_ID,bus= Mod.EventBusSubscriber.Bus.MOD)//allows for class to have events for forge to load into game
@ObjectHolder(WarpStone.MOD_ID)
public class BlockInit {
    public static final Block warp_stone_block=null;
    public static final OreBlock crude_warp_stone_ore=null;
    public static final OreBlock warp_stone_crystal=null;
    public static final Block warp_stone_meteor_block=null;
    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event)
    {
        event.getRegistry().register(new CrudeWarpStoneOre(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(5.0f,6.0f)
                .sound(SoundType.STONE)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE)
                .lightValue(4)).
                setRegistryName("crude_warp_stone_ore"));
        event.getRegistry().register(new WarpStoneCrystal(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(5.0f,6.0f)
                .sound(SoundType.GLASS)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE)
                .lightValue(16)).
                setRegistryName("warp_stone_crystal"));
        event.getRegistry().register(new Block(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(5.0f,6.0f)
                .sound(SoundType.STONE)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE)
                .lightValue(16)).
                setRegistryName("warp_stone_block"));
        event.getRegistry().register(new Block(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(5.0f,6.0f)
                .sound(SoundType.STONE)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE)
                .lightValue(4)
                ).setRegistryName("warp_stone_meteor_block"));

    }
    @SubscribeEvent
    public static void registerBlockItems(final RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(new BlockItem(crude_warp_stone_ore,new Item.Properties()
                .group(WarpStone.WarpItemGroup.instance))
                .setRegistryName("crude_warp_stone_ore"));
        event.getRegistry().register(new BlockItem(warp_stone_crystal,new Item.Properties()
                .group(WarpStone.WarpItemGroup.instance))
                .setRegistryName("warp_stone_crystal"));
        event.getRegistry().register(new BlockItem(warp_stone_block,new Item.Properties()
                .group(WarpStone.WarpItemGroup.instance))
                .setRegistryName("warp_stone_block"));
        event.getRegistry().register(new BlockItem(warp_stone_meteor_block,new Item.Properties()
                .group(WarpStone.WarpItemGroup.instance))
                .setRegistryName("warp_stone_meteor_block"));
    }
}
