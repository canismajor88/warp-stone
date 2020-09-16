//package com.canismajor88.init;
//
//import com.canismajor88.Enchantments.WarpPiercingEnchantment;
//import com.canismajor88.WarpStone.WarpStone;
//import com.canismajor88.objects.items.UnrefinedWarpStoneChunk;
//import com.canismajor88.objects.items.WarpStoneOreAnalyser;
//import net.minecraft.enchantment.Enchantment;
//import net.minecraft.enchantment.EnchantmentType;
//import net.minecraft.inventory.EquipmentSlotType;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemGroup;
//import net.minecraftforge.event.RegistryEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.RegistryObject;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.ForgeRegistries;
//import net.minecraftforge.registries.ObjectHolder;
//
//import java.util.function.Predicate;
//
//@Mod.EventBusSubscriber(modid= WarpStone.MOD_ID,bus= Mod.EventBusSubscriber.Bus.MOD)//allows for class to have events for forge to load into game
//@ObjectHolder(WarpStone.MOD_ID)//tags class as object holder
//public class EnchantmentsInit {
//    public static Enchantment warp_piercing=null;
//    public static EnchantmentType WeepingBladeEnchantmentType= EnchantmentType.create("weeping_blade", item -> item.equals(ToolInit.weeping_blade));
//    @SubscribeEvent
//    public static void registerEnchantments(final RegistryEvent.Register<Enchantment> event)
//    {
//        event.getRegistry().register(new WarpPiercingEnchantment(Enchantment.Rarity.COMMON,WeepingBladeEnchantmentType,new EquipmentSlotType[]{EquipmentSlotType.MAINHAND}).setRegistryName("warp_piercing"));
//    }
//}
