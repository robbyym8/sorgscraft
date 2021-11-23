package dev.unchilled.sorgscraft.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.level.Level;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;

public class Tinder extends Item {
    public Tinder(Properties properties) {
        super(properties);
    }


    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()) {
            Level world = pContext.getLevel();
            BlockPos blockpos = pContext.getClickedPos();
            Villager victim = new Villager(EntityType.VILLAGER, world);
            victim.setBaby(true);
            victim.moveTo(blockpos.above(), 0, 0);
            victim.setCustomName(new TextComponent("Victim"));
            victim.setCustomNameVisible(true);
            world.addFreshEntity(victim);
            pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), p -> {
                p.broadcastBreakEvent(pContext.getHand());
            });
        }
        return super.useOn(pContext);
    }
    
}
