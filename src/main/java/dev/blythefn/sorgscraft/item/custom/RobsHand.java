package dev.blythefn.sorgscraft.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class RobsHand extends SwordItem {

    public RobsHand(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pTarget.addEffect(new MobEffectInstance(MobEffects.POISON, 600, 0));
        pTarget.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 600, 0, true, false, false));
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
    
}
