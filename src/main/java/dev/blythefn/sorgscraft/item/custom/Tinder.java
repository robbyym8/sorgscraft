package dev.blythefn.sorgscraft.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class Tinder extends Item {
    public Tinder(Properties properties) {
        super(properties);
    }


    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()) {
            Level level = pContext.getLevel();
            BlockPos blockpos = pContext.getClickedPos();
            Villager victim = new Villager(EntityType.VILLAGER, level);
            victim.setBaby(true);
            victim.moveTo(blockpos.above(), 0, 0);
            victim.setCustomName(new TextComponent("Victim"));
            victim.setCustomNameVisible(true);
            victim.ageUp(1000000000);
            level.addFreshEntity(victim);
            pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), p -> {
                p.broadcastBreakEvent(pContext.getHand());
            });
        }
        return super.useOn(pContext);
    }
    
}
