package com.canismajor88.objects.items;

import com.canismajor88.init.ItemInit;
import com.canismajor88.init.SoundsInit;
import com.canismajor88.util.helpers.KeyBoardHelper;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.client.event.sound.PlaySoundEvent;

import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WeepingBlade extends SwordItem {
    public WeepingBlade(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        damage(4,target);
        return super.hitEntity(stack, target, attacker);
    }

    public void damage(float damageAmount,LivingEntity target ) {
        damageAmount = net.minecraftforge.event.ForgeEventFactory.onLivingHeal(target, damageAmount);
        float targetHealth = target.getHealth();
        if (targetHealth > 0) {
            target.setHealth(targetHealth - damageAmount);
        }

    }


    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("4 "+"\u00A7e"+"Void"+"\u00A77"+" Damage"));
        if(KeyBoardHelper.isHoldingShift()){
            tooltip.add(new StringTextComponent("Right click for invisibility"));
        }else{
            tooltip.add(new StringTextComponent("Hold"+"\u00A7e"+" shift"+"\u00A77"+" for information"));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
       ItemStack weepingBlade= playerIn.getHeldItemMainhand();
       playerIn.addPotionEffect(new EffectInstance(Effects.INVISIBILITY,250,50));
    playerIn.playSound(SoundsInit.event,50f,50f);
        int l = weepingBlade.getDamage() + 100;
        weepingBlade.setDamage(l);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }


}
