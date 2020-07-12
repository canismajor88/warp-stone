package com.canismajor88.init;

import com.canismajor88.WarpStone.WarpStone;
import com.canismajor88.world.structures.WarpStoneMeteor;
import com.canismajor88.world.structures.WarpStoneMeteorPieces;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Locale;

public class FeatureInit {
    public static Structure<NoFeatureConfig> WARP_STONE_METEOR= new WarpStoneMeteor(NoFeatureConfig::deserialize);
    public static IStructurePieceType WSMS = WarpStoneMeteorPieces.Piece::new;
    public static void registerFeatures(RegistryEvent.Register<Feature<?>> event)
    {
        IForgeRegistry<Feature<?>> registry = event.getRegistry();

        /* Registers the structure itself and sets what its path is. In this case,
         * the structure will have the resourcelocation of structure_tutorial:run_down_house .
         *
         * It is always a good idea to register your regular features too so that other mods
         * can use them too directly from the Forge Registry. It great for mod compatibility.
         */
    WarpStone.register(registry, WARP_STONE_METEOR, "warp_stone_meteor");
        register(WSMS, "WSMS");
    }
    static IStructurePieceType register(IStructurePieceType structurePiece, String key)
    {
        return Registry.register(Registry.STRUCTURE_PIECE, key.toLowerCase(Locale.ROOT), structurePiece);
    }
}
