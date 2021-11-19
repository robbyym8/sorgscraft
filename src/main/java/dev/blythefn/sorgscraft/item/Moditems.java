package dev.blythefn.sorgscraft.item;

import java.util.List;

import dev.blythefn.sorgscraft.sorgscraft;
import dev.blythefn.sorgscraft.item.custom.Adderall;
import dev.blythefn.sorgscraft.item.custom.GapEffects;
import dev.blythefn.sorgscraft.item.custom.Milk;
import dev.blythefn.sorgscraft.item.custom.RobsHand;
import dev.blythefn.sorgscraft.item.custom.Tinder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Moditems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, sorgscraft.MOD_ID);

    public static final RegistryObject<Item> TOOTH_OF_THE_GOBLIN = ITEMS.register("tooth_of_the_goblin",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SORGS_TAB)));

    public static final RegistryObject<Item> THE_GAP = ITEMS.register("the_gap",
        () -> new GapEffects(new Item.Properties().tab(ModCreativeModeTab.SORGS_TAB)) {
                @Override
                public void appendHoverText(ItemStack pStack, Level pLevel, List<net.minecraft.network.chat.Component> tooltip, TooltipFlag pIsAdvanced) {
                super.appendHoverText(pStack, pLevel, tooltip, pIsAdvanced);
                tooltip.add(new TranslatableComponent("tooltip.item.sorgscraft.the_gap"));
                tooltip.add(new TextComponent(""));
                tooltip.add(new TranslatableComponent("tooltip.item.sorgscraft.the_gap_effects"));
                }
        });

    public static final RegistryObject<Item> GREASE_DROP = ITEMS.register("grease_drop",
    () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SORGS_TAB)));

    public static final RegistryObject<Item> AARALYNS_HOMEWORK = ITEMS.register("aaralyns_homework",
    () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SORGS_TAB)));

    public static final RegistryObject<Item> ADDERALL = ITEMS.register("adderall",
    () -> new Adderall(new Item.Properties().tab(ModCreativeModeTab.SORGS_TAB)) {
        @Override
        public void appendHoverText(ItemStack pStack, Level pLevel, List<net.minecraft.network.chat.Component> tooltip, TooltipFlag pIsAdvanced) {
        super.appendHoverText(pStack, pLevel, tooltip, pIsAdvanced);
        tooltip.add(new TranslatableComponent("tooltip.item.sorgscraft.adderall"));
        tooltip.add(new TextComponent(""));
        tooltip.add(new TranslatableComponent("tooltip.item.sorgscraft.adderall_effects"));
        }
    });

    public static final RegistryObject<Item> TINDER = ITEMS.register("tinder",
    () -> new Tinder(new Item.Properties().tab(ModCreativeModeTab.SORGS_TAB).stacksTo(1).durability(3)) {
        @Override
        public void appendHoverText(ItemStack pStack, Level pLevel, List<net.minecraft.network.chat.Component> tooltip, TooltipFlag pIsAdvanced) {
        super.appendHoverText(pStack, pLevel, tooltip, pIsAdvanced);
        tooltip.add(new TranslatableComponent("tooltip.item.sorgscraft.tinder"));
        }
    });

    public static final RegistryObject<Item> ROBS_HAND = ITEMS.register("robs_hand",
    () -> new RobsHand(ModItemTier.ROB, 1, -2.4f, new Item.Properties().tab(ModCreativeModeTab.SORGS_TAB).stacksTo(1).durability(1000)));

    public static final RegistryObject<Item> FAITH_MILK = ITEMS.register("faith_milk",
    () -> new Milk(new Item.Properties().tab(ModCreativeModeTab.SORGS_TAB).stacksTo(16)));

    public static final RegistryObject<Item> AVA_MILK = ITEMS.register("ava_milk",
    () -> new Milk(new Item.Properties().tab(ModCreativeModeTab.SORGS_TAB).stacksTo(16)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
