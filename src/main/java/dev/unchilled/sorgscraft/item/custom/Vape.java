package dev.unchilled.sorgscraft.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DrinkHelper;
import net.minecraft.util.Hand;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.world.World;

public class Vape extends Item {

    public Vape(Properties pProperties) {
        super(pProperties);
    }

    public ItemStack finishUsingItem(ItemStack pStack, World pLevel, LivingEntity pEntityLiving) {
        if (!pLevel.isClientSide) {
            pEntityLiving.addEffect(new EffectInstance(Effects.CONFUSION, 600, 0, true, false, false));
            pEntityLiving.addEffect(new EffectInstance(Effects.LEVITATION, 600, 0, true, false, false));
            pStack.hurtAndBreak(1, ((PlayerEntity)pEntityLiving), p -> {
                p.broadcastBreakEvent(pEntityLiving.getUsedItemHand());
            });
        };

        return pStack;
    }

    public int getUseDuration(ItemStack pStack) {
        return 32;
    }

    public UseAction getUseAnimation(ItemStack pStack) {
        return UseAction.DRINK;
    }

    public ActionResult<ItemStack> use(World pLevel, PlayerEntity pPlayer, Hand pHand) {
        return DrinkHelper.useDrink(pLevel, pPlayer, pHand);
    }
    
}
