package com.canismajor88.objects.items;


import com.canismajor88.init.SoundsInit;
import com.canismajor88.util.helpers.KeyBoardHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

import static com.canismajor88.util.DataTransferObject.warpStoneToolLife;
import static net.minecraft.util.SoundCategory.PLAYERS;

public class WeepingBlade extends SwordItem {
    public WeepingBlade(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        damage(4, target);
       return super.hitEntity(stack, target, attacker);
   }

    public void damage(float damageAmount, LivingEntity target) {
        damageAmount = net.minecraftforge.event.ForgeEventFactory.onLivingHeal(target, damageAmount);
        float targetHealth = target.getHealth();
        if (targetHealth > 0) {
            target.setHealth(targetHealth - damageAmount);
       }

    }




    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("4 " + "\u00A7e" + "Warp Piercing" + "\u00A77" + " Damage"));
        if (KeyBoardHelper.isHoldingShift()) {
            tooltip.add(new StringTextComponent("Right click for invisibility"));
        } else {
            tooltip.add(new StringTextComponent("Hold" + "\u00A7e" + " shift" + "\u00A77" + " for information"));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack weepingBlade = playerIn.getHeldItemMainhand();
        playerIn.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 250, 50));
        worldIn.playSound(playerIn.getPosX(),playerIn.getPosY(),playerIn.getPosZ(),SoundsInit.BLADE_ACTIVATION.get(), PLAYERS,1000f,50f,false);
        int l = weepingBlade.getDamage()+100;
        if(l<warpStoneToolLife) weepingBlade.setDamage(l);
        else weepingBlade.setDamage(warpStoneToolLife);
        return super.onItemRightClick(worldIn, playerIn, handIn);

    }


}
