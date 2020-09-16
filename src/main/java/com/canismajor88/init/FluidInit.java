package com.canismajor88.init;

import com.canismajor88.WarpStone.WarpStone;
import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FluidInit {
    public static final ResourceLocation MOLTEN_WARPED_EARTH_STILL_RL= new ResourceLocation(WarpStone.MOD_ID,"blocks/molten_warped_earth_still");
    public static final ResourceLocation MOLTEN_WARPED_EARTH_FlOWING_RL= new ResourceLocation(WarpStone.MOD_ID,"blocks/molten_warped_earth_flowing");
    public static final ResourceLocation MOLTEN_WARPED_EARTH_OVERLAY_RL= new ResourceLocation(WarpStone.MOD_ID,"blocks/molten_warped_earth_overlay");
    public static final DeferredRegister<Fluid> FLUIDS= new DeferredRegister<>(ForgeRegistries.FLUIDS,WarpStone.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS= new DeferredRegister<>(ForgeRegistries.BLOCKS,WarpStone.MOD_ID);

    public static final RegistryObject<FlowingFluid> MOLTEN_WARPED_EARTH=FLUIDS.register("molten_warped_earth_fluid",()->new ForgeFlowingFluid.Source(FluidInit.MOLTEN_WARPED_EARTH_PROPERTIES));

    public static final RegistryObject<FlowingFluid> MOLTEN_WARPED_EARTH_FLOWING=FLUIDS.register("molten_warped_earth_flowing",()->new ForgeFlowingFluid.Flowing(FluidInit.MOLTEN_WARPED_EARTH_PROPERTIES));

    public static final ForgeFlowingFluid.Properties MOLTEN_WARPED_EARTH_PROPERTIES= new ForgeFlowingFluid.Properties(()->MOLTEN_WARPED_EARTH.get(),()->MOLTEN_WARPED_EARTH_FLOWING.get(),
            FluidAttributes.builder(MOLTEN_WARPED_EARTH_STILL_RL,MOLTEN_WARPED_EARTH_FlOWING_RL).luminosity(14)
                    .temperature(100).density(5).viscosity(5).sound(SoundEvents.BLOCK_LAVA_AMBIENT).overlay(MOLTEN_WARPED_EARTH_OVERLAY_RL)).block(()-> FluidInit.MOLTEN_WARPED_EARTH_BLOCK.get());
    public static final RegistryObject<FlowingFluidBlock> MOLTEN_WARPED_EARTH_BLOCK=BLOCKS.register("molten_warped_earth_block",()->new FlowingFluidBlock(()->FluidInit.MOLTEN_WARPED_EARTH.get(),Block.Properties.create(Material.LAVA).doesNotBlockMovement().noDrops()));
}
