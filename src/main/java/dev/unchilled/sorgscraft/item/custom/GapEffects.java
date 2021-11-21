package dev.unchilled.sorgscraft.item.custom;

import dev.unchilled.sorgscraft.item.ModArmorMaterials;
import dev.unchilled.sorgscraft.item.Moditems;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GapEffects extends ArmorItem {
    
    public GapEffects(Properties pProperties) {
        super(ModArmorMaterials.GAP, EquipmentSlotType.HEAD, pProperties);
    }

    @Override
    public void onArmorTick(ItemStack stack, World level, PlayerEntity player) {
        if (player.getItemBySlot(EquipmentSlotType.HEAD).getItem() == Moditems.THE_GAP.get()) {
            player.removeEffect(Effects.CONFUSION);
            player.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 201, 0, true, false, false));
            player.addEffect(new EffectInstance(Effects.NIGHT_VISION, 201, 0, true, false, false));
            player.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 201, 0, true, false, false));
        }
    }
}
