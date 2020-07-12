package com.canismajor88.init;

import com.canismajor88.WarpStone.WarpStone;
import com.canismajor88.objects.items.WeepingBlade;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid= WarpStone.MOD_ID,bus= Mod.EventBusSubscriber.Bus.MOD)//allows for class to have events for forge to load into game
@ObjectHolder(WarpStone.MOD_ID)//tags class as object holder
public class ToolInit {
    public static final Item weeping_blade=null;
    public static final Item warp_stone_pickax=null;
    public static final Item warp_stone_ax=null;
    public static final Item warp_stone_shovel=null;
    public static final Item warp_stone_hoe=null;
    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event)
    {
        //1+baseDamage(0)+addedDamage(0)
        //4-1==3 attack speed
event.getRegistry().register(new WeepingBlade(WarpStoneItemTier.WARP_STONE_ITEM_TIER,4,0
        ,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("weeping_blade"));
    }
}    enum WarpStoneItemTier implements IItemTier {
    WARP_STONE_ITEM_TIER(5, 2000, 13f, 0f, 15, () -> {
        return Ingredient.fromItems(ItemInit.warp_stone_ingot);
    });
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantablity;
    private final LazyValue<Ingredient> repairMaterial;

    private WarpStoneItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantablity, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantablity = enchantablity;
        this.repairMaterial = new LazyValue<>(repairMaterial);

    }

    @Override
    public int getMaxUses() {
        return this.maxUses;
    }

    @Override
    public float getEfficiency() {
        return this.efficiency;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantablity;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }
}
