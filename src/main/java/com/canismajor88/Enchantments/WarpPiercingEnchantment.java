//package com.canismajor88.Enchantments;
//
//import com.canismajor88.init.EnchantmentsInit;
//import net.minecraft.enchantment.Enchantment;
//import net.minecraft.enchantment.EnchantmentType;
//import net.minecraft.enchantment.Enchantments;
//import net.minecraft.entity.Entity;
//import net.minecraft.entity.LivingEntity;
//import net.minecraft.inventory.EquipmentSlotType;
//import net.minecraft.item.ItemStack;
//import net.minecraft.potion.EffectInstance;
//import net.minecraft.potion.Effects;
//
//public class WarpPiercingEnchantment extends Enchantment {
//    public WarpPiercingEnchantment(Rarity rarityIn, EnchantmentType typeIn, EquipmentSlotType[] slots) {
//        super(rarityIn, typeIn, slots);
//    }
//
//    @Override
//    public int getMaxLevel() {
//        return 3;
//    }
//
//    @Override
//    public int getMinLevel() {
//        return 1;
//    }
//
//
//
//
//
//    @Override
//    public void onEntityDamaged(LivingEntity user, Entity target, int level) {
//       LivingEntity targetHit= (LivingEntity) target;
//        switch (level){
//            case 1: damage(2,targetHit);
//                break;
//            case 2: damage(4,targetHit);
//                break;
//            case 3: damage(6,targetHit);
//                break;
//                }
//        super.onEntityDamaged(user, target, level);
//    }
//    public void damage(float damageAmount, LivingEntity target) {
//        damageAmount = net.minecraftforge.event.ForgeEventFactory.onLivingHeal(target, damageAmount);
//        float targetHealth = target.getHealth();
//        if (targetHealth > 0) {
//            target.setHealth(targetHealth - damageAmount);
//        }
//    }
//
//    @Override
//    protected boolean canApplyTogether(Enchantment ench) {
//       boolean compatible=true;
//        if(ench== Enchantments.SHARPNESS||ench==Enchantments.SMITE||ench== EnchantmentsInit.warp_piercing) compatible = false;
//        return compatible;
//    }
//
//    @Override
//    public boolean canApplyAtEnchantingTable(ItemStack stack) {
//        return true;
//    }
//}
