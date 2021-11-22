package dev.unchilled.sorgscraft.item.custom;

import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DrinkHelper;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.potion.EffectInstance;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;

public class Adderall extends Item {

    public Adderall(Properties pProperties) {
        super(pProperties);
    }

    public ItemStack finishUsingItem(ItemStack pStack, World pWorld, LivingEntity pEntityLiving) {
        if (!pWorld.isClientSide) {
            pEntityLiving.forceAddEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 12000, 1, true, false, false));
            pEntityLiving.forceAddEffect(new EffectInstance(Effects.DIG_SPEED, 12000, 2, true, false, false));
            pEntityLiving.forceAddEffect(new EffectInstance(Effects.REGENERATION, 12000, 1, true, false, false));
        };

        if (pEntityLiving instanceof PlayerEntity && !((PlayerEntity)pEntityLiving).abilities.instabuild) {
        pStack.shrink(1);
        }

        return pStack;
    }

    public int getUseDuration(ItemStack pStack) {
        return 32;
    }

    public UseAction getUseAnimation(ItemStack pStack) {
        return UseAction.EAT;
    }

    public ActionResult<ItemStack> use(World pWorld, PlayerEntity pPlayer, Hand pHand) {
        return DrinkHelper.useDrink(pWorld, pPlayer, pHand);
    }

}
