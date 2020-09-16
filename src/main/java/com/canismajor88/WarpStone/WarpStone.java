package com.canismajor88.WarpStone;

import com.canismajor88.init.*;
import com.canismajor88.world.WorldGenCM;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.annotation.Nullable;

import static com.canismajor88.util.DataTransferObject.warpStoneToolLife;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("warpstonecm")
public class WarpStone
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID="warpstonecm";
    public static WarpStone instance;
    public WarpStone() {
        final IEventBus modEventBus=FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);
        FluidInit.FLUIDS.register(modEventBus);
        FluidInit.BLOCKS.register(modEventBus);
        SoundsInit.SOUNDS.register(modEventBus);
        instance=this;
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        WorldGenCM.generate();
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        ToolInit.warp_stone_drill.addPropertyOverride(new ResourceLocation(MOD_ID, "charged"), new IItemPropertyGetter() {
            @Override
            public float call(ItemStack stack, @Nullable World worldIn, @Nullable LivingEntity entityIn) {
                ItemStack warpStoneDrill =stack;
                float isCharged;
                int toolLife = warpStoneToolLife-warpStoneDrill.getDamage();
                boolean needsCharge=false;
                if (toolLife<=1||needsCharge) needsCharge = true;
                if(needsCharge) isCharged=0f;
                else isCharged=1f;
                return isCharged;
            }

        });
        ToolInit.warp_stone_chainsaw.addPropertyOverride(new ResourceLocation(MOD_ID, "active"), new IItemPropertyGetter() {
            @Override
            public float call(ItemStack stack, @Nullable World worldIn, @Nullable LivingEntity entityIn) {
                ItemStack warp_stone_chainsaw =stack;
                float isCharged;
                int toolLife = warpStoneToolLife-warp_stone_chainsaw.getDamage();
                boolean needsCharge=false;
                if (toolLife<=1||needsCharge) needsCharge = true;
                if(needsCharge) isCharged=0f;
                else isCharged=1f;
                return isCharged;
            }

        });
    }
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents
    {

        /**
         * This method will be called by Forge when it is time for the mod to register features.
         */
        @SubscribeEvent
        public static void onRegisterFeatures(final RegistryEvent.Register<Feature<?>> event)
        {
            //registers the structures/features.
            //If you don't do this, you'll crash.
            FeatureInit.registerFeatures(event);

            LOGGER.log(Level.INFO, "features/structures registered.");
        }
    }

    /*
     * Helper method to quickly register features, blocks, items, structures, biomes, anything that can be registered.
     * only used method one time was trying to figure out how implement multiple ways registering objects
     */
    public static <T extends IForgeRegistryEntry<T>> T register(IForgeRegistry<T> registry, T entry, String registryKey)
    {
        entry.setRegistryName(new ResourceLocation(WarpStone.MOD_ID, registryKey));
        registry.register(entry);
        return entry;
    }
    public static class WarpItemGroup extends ItemGroup {
        public static final WarpItemGroup instance= new WarpItemGroup(ItemGroup.GROUPS.length,"warp_stone");
        private WarpItemGroup(int index, String lable)
        {
            super(index,lable);
        }

        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ItemInit.unrefined_warp_stone_chunk);
        }
    }

}
