package dev.unchilled.sorgscraft.item.custom;

import dev.unchilled.sorgscraft.item.ModItemTier;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;

public class RobsHand extends SwordItem {

    public RobsHand(ModItemTier rob, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(rob, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pTarget.addEffect(new MobEffectInstance(MobEffects.POISON, 600, 0));
        pTarget.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 600, 0, true, false, false));
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
    
}
