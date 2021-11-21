package dev.unchilled.sorgscraft.item.custom;

import dev.unchilled.sorgscraft.item.ModItemTier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;

public class RobsHand extends SwordItem {

    public RobsHand(ModItemTier rob, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(rob, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pTarget.addEffect(new EffectInstance(Effects.POISON, 600, 0));
        pTarget.addEffect(new EffectInstance(Effects.CONFUSION, 600, 0, true, false, false));
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
    
}
