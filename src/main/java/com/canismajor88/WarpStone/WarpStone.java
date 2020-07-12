package com.canismajor88.WarpStone;

import com.canismajor88.init.FeatureInit;
import com.canismajor88.world.WorldGenCM;
import net.minecraft.util.ResourceLocation;
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
        instance=this;
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        WorldGenCM.generate();
    }

    private void doClientStuff(final FMLClientSetupEvent event) {

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
     */
    public static <T extends IForgeRegistryEntry<T>> T register(IForgeRegistry<T> registry, T entry, String registryKey)
    {
        entry.setRegistryName(new ResourceLocation(WarpStone.MOD_ID, registryKey));
        registry.register(entry);
        return entry;
    }

}
