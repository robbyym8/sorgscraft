package dev.blythefn.sorgscraft.item;

import java.util.function.Supplier;

import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public enum ModItemTier implements Tier {

    ROB(3, 500, 8.0F, -5.0F, 10, () -> {
        return Ingredient.of(Moditems.TINDER.get());
    });

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
        this.level = harvestLevel;
        this.uses = maxUses;
        this.speed = efficiency;
        this.damage = attackDamage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
    }

    @Override
    public int getUses() {
        // TODO Auto-generated method stub
        return level;
    }

    @Override
    public float getSpeed() {
        // TODO Auto-generated method stub
        return uses;
    }

    @Override
    public float getAttackDamageBonus() {
        // TODO Auto-generated method stub
        return speed;
    }

    @Override
    public int getLevel() {
        // TODO Auto-generated method stub
        return (int) damage;
    }

    @Override
    public int getEnchantmentValue() {
        // TODO Auto-generated method stub
        return enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        // TODO Auto-generated method stub
        return repairIngredient.get();
    }
    
}
