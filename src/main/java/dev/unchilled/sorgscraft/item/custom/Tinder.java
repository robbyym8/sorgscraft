package dev.unchilled.sorgscraft.item.custom;

import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;

public class Tinder extends Item {
    public Tinder(Properties properties) {
        super(properties);
    }


    @Override
    public ActionResultType useOn(ItemUseContext pContext) {
        if(!pContext.getLevel().isClientSide()) {
            World level = pContext.getLevel();
            BlockPos blockpos = pContext.getClickedPos();
            VillagerEntity victim = new VillagerEntity(EntityType.VILLAGER, level);
            victim.setBaby(true);
            victim.moveTo(blockpos.above(), 0, 0);
            victim.setCustomName(new StringTextComponent("Victim"));
            victim.setCustomNameVisible(true);
            level.addFreshEntity(victim);
            pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), p -> {
                p.broadcastBreakEvent(pContext.getHand());
            });
        }
        return super.useOn(pContext);
    }
    
}
