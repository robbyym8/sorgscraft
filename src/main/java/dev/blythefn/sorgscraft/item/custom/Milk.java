package dev.blythefn.sorgscraft.item.custom;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class Milk extends Item {

    public Milk(Properties pProperties) {
        super(pProperties);
    }

   public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
      if (!pLevel.isClientSide) pEntityLiving.removeAllEffects(); // FORGE - move up so stack.shrink does not turn stack into air

      if (pEntityLiving instanceof Player && !((Player)pEntityLiving).getAbilities().instabuild) {
         pStack.shrink(1);
      }

      return pStack;
   }

   public int getUseDuration(ItemStack pStack) {
      return 1;
   }

   public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
      return ItemUtils.startUsingInstantly(pLevel, pPlayer, pHand);
   }
}
