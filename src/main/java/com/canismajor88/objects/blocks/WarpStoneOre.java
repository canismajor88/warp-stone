package com.canismajor88.objects.blocks;

import net.minecraft.block.OreBlock;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class WarpStoneOre extends OreBlock {
    public WarpStoneOre(Properties properties) {
        super(properties);
    }

    @Override
    protected int getExperience(Random rand) {
        return MathHelper.nextInt(rand,2,10);
    }
}
