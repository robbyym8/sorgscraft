package dev.unchilled.sorgscraft.item;

import java.util.function.Supplier;

import net.minecraft.util.LazyValue;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public enum ModItemTier implements IItemTier {

    ROB(3, 500, 8.0F, -5.0F, 10, () -> {
        return Ingredient.of(Moditems.TINDER.get());
    });

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyValue<Ingredient> repairIngredient;

    ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
        this.level = harvestLevel;
        this.uses = maxUses;
        this.speed = efficiency;
        this.damage = attackDamage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = new LazyValue<>(repairIngredient);
    }

    @Override
    public int getUses() {
        return level;
    }

    @Override
    public float getSpeed() {
        return uses;
    }

    @Override
    public float getAttackDamageBonus() {
        return speed;
    }

    @Override
    public int getLevel() {
        return (int) damage;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredient.get();
    }
    
}
