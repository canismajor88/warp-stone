package com.canismajor88.objects.items;

import com.canismajor88.init.ItemInit;
import com.canismajor88.util.helpers.KeyBoardHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapData;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import javax.annotation.Nullable;
import java.util.List;

import static net.minecraft.item.FilledMapItem.getMapData;

public class UnrefinedWarpStoneChunk extends Item {
    public UnrefinedWarpStoneChunk(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
       if(KeyBoardHelper.isHoldingShift()){
        tooltip.add(new StringTextComponent("cook in blast furnace to refine"));
        }else{
           tooltip.add(new StringTextComponent("hold shift for info"));
       }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    public void giveRandomEffect(PlayerEntity playerIn){
        int random = (int )(Math.random() * 5 + 1);
        switch (random){
            case 1: playerIn.addPotionEffect(new EffectInstance(Effects.WITHER,100,50));
                break;
            case 2: playerIn.addPotionEffect(new EffectInstance(Effects.REGENERATION,100,1));
            break;
            case 3: playerIn.addPotionEffect(new EffectInstance(Effects.BLINDNESS,100,50));
            break;
            case 4: playerIn.addPotionEffect(new EffectInstance(Effects.NAUSEA,100,50));
            break;
            case 5: playerIn.addPotionEffect(new EffectInstance(Effects.SLOWNESS,100,1));
            break;
        }
    }
    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (entityIn instanceof PlayerEntity) {
            PlayerEntity playerIn = (PlayerEntity)entityIn;
            giveRandomEffect(playerIn);
        }
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }



    @Override
    public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        ItemStack item = new ItemStack((Item)ItemInit.warp_stone_ore_analyser);
        playerIn.inventory.addItemStackToInventory(item);
        super.onCreated(stack, worldIn, playerIn);
    }
}
