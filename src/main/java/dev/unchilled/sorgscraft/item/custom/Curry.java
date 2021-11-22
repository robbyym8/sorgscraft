package dev.unchilled.sorgscraft.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DrinkHelper;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class Curry extends Item {

    public Curry(Properties pProperties) {
        super(pProperties);
    }
    
    public ItemStack finishUsingItem(ItemStack pStack, World pWorld, LivingEntity pEntityLiving) {
        if (!pWorld.isClientSide) {
            if(pEntityLiving instanceof PlayerEntity)
                {
                    ((PlayerEntity)pEntityLiving).setSecondsOnFire(20);
                }
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

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pTarget.setSecondsOnFire(20);
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

}
