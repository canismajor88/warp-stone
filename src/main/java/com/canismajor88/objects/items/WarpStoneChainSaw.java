package com.canismajor88.objects.items;

import com.canismajor88.init.SoundsInit;
import com.canismajor88.util.helpers.KeyBoardHelper;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

import static com.canismajor88.util.DataTransferObject.warpStoneToolLife;
import static net.minecraft.util.SoundCategory.PLAYERS;

public class WarpStoneChainSaw extends AxeItem {
    public boolean needsCharge=false;
    public WarpStoneChainSaw(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        ItemStack warp_stone_chainsaw = stack;
        int toolLife = warpStoneToolLife-warp_stone_chainsaw.getDamage();
        if(toolLife==1){
            tooltip.add(new StringTextComponent(0+" "+ "\u00A7e" + "Warp" + "\u00A77" + " Energy"));
        }else{
            tooltip.add(new StringTextComponent(toolLife+ "\u00A7e" + "Warp" + "\u00A77" + " Energy"));
        }
        if (KeyBoardHelper.isHoldingShift()) {
            tooltip.add(new StringTextComponent("Charge with warp cells\nRight click for overdrive "));
        } else {
            tooltip.add(new StringTextComponent("Hold" + "\u00A7e" + " shift" + "\u00A77" + " for information"));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, PlayerEntity player) {
        ItemStack warpStoneDrill = player.getHeldItemMainhand();
        int toolLife = warpStoneToolLife-warpStoneDrill.getDamage();

        if (toolLife<=1||needsCharge){
            player.addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, 125, 1000));

            needsCharge=true;
        }else{
            needsCharge=false;
        }

        return false;
    }

    @Override
    public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        needsCharge=false;
        super.onCreated(stack, worldIn, playerIn);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if(needsCharge){
            stack.setDamage(stack.getDamage()-1);
        }
        return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);

    }
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack warp_stone_chainsaw = playerIn.getHeldItemMainhand();
        playerIn.addPotionEffect(new EffectInstance(Effects.HASTE, 75, 50));
        worldIn.playSound(playerIn.getPosX(),playerIn.getPosY(),playerIn.getPosZ(), SoundsInit.WARP_STONE_DRILL_OVERDRIVE.get(), PLAYERS,1000f,50f,false);
        int l = warp_stone_chainsaw.getDamage()+200;
        if(l<warpStoneToolLife) warp_stone_chainsaw.setDamage(l);
        else warp_stone_chainsaw.setDamage(warpStoneToolLife-1);
        return super.onItemRightClick(worldIn, playerIn, handIn);

    }
}
