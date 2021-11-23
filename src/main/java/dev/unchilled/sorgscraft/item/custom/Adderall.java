package dev.unchilled.sorgscraft.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class Adderall extends Item {

    public Adderall(Properties pProperties) {
        super(pProperties);
    }

    public ItemStack finishUsingItem(ItemStack pStack, Level pWorld, LivingEntity pEntityLiving) {
        if (!pWorld.isClientSide) {
            pEntityLiving.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 12000, 1, true, false, false));
            pEntityLiving.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 12000, 2, true, false, false));
            pEntityLiving.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 12000, 1, true, false, false));
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

}
