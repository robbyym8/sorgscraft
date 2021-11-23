package dev.unchilled.sorgscraft.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;

public class Curry extends Item {

    public Curry(Properties pProperties) {
        super(pProperties);
    }
    
    public ItemStack finishUsingItem(ItemStack pStack, Level pWorld, LivingEntity pEntityLiving) {
        if (!pWorld.isClientSide) {
            if(pEntityLiving instanceof Player)
                {
                    ((Player)pEntityLiving).setSecondsOnFire(20);
                }
        };

        if (pEntityLiving instanceof Player && !((Player)pEntityLiving).getAbilities().instabuild) {
        pStack.shrink(1);
        }

        return pStack;
    }

    public int getUseDuration(ItemStack pStack) {
        return 32;
    }

    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.EAT;
    }

    public InteractionResultHolder<ItemStack> use(Level pWorld, Player pPlayer, InteractionHand pHand) {
        return ItemUtils.startUsingInstantly(pWorld, pPlayer, pHand);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pTarget.setSecondsOnFire(20);
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

}
