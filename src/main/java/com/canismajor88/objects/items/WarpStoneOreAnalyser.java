package com.canismajor88.objects.items;

import com.canismajor88.util.helpers.KeyBoardHelper;
import net.minecraft.block.BedBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.BedTileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;


public class WarpStoneOreAnalyser extends Item {
    public WarpStoneOreAnalyser(Properties properties) {
        super(properties);
    }
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(KeyBoardHelper.isHoldingShift()){
            tooltip.add(new StringTextComponent("Use to find warp chunks in crude warp stone"));
        }else{
            tooltip.add(new StringTextComponent("Hold"+"\u00A7e"+" shift"+"\u00A77"+" for information"));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }


}
