package dev.blythefn.sorgscraft.item.custom;

import dev.blythefn.sorgscraft.item.ModArmorMaterials;
import dev.blythefn.sorgscraft.item.Moditems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class GapEffects extends ArmorItem {
    
    public GapEffects(Properties pProperties) {
        super(ModArmorMaterials.GAP, EquipmentSlot.HEAD, pProperties);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == Moditems.THE_GAP.get()) {
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 201, 0, true, false, false));
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 201, 0, true, false, false));
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 201, 0, true, false, false));
        }
    }
}
