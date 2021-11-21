package dev.blythefn.sorgscraft.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class Milk extends Item {

    public Milk(Properties pProperties) {
        super(pProperties);
    }

   public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
      if (!pLevel.isClientSide) {
         pEntityLiving.removeEffect(MobEffects.POISON);
         pEntityLiving.removeEffect(MobEffects.SLOW_FALLING);
         if(pEntityLiving.hasEffect(MobEffects.LEVITATION)) {
            pEntityLiving.removeEffect(MobEffects.LEVITATION);
            pEntityLiving.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 400, 0, true, false, false));
            pEntityLiving.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 400, 0, true, false, false));
         } else {
            pEntityLiving.removeEffect(MobEffects.CONFUSION);
         };
         pEntityLiving.addEffect(new MobEffectInstance(MobEffects.SATURATION, 1, 4, true, false, false));
      }

      if (pEntityLiving instanceof Player && !((Player)pEntityLiving).getAbilities().instabuild) {
         pStack.shrink(1);
      }

      return pStack;
   }

   public int getUseDuration(ItemStack pStack) {
      return 16;
   }

   public UseAnim getUseAnimation(ItemStack pStack) {
      return UseAnim.DRINK;
   }

   public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
      return ItemUtils.startUsingInstantly(pLevel, pPlayer, pHand);
   }
}
