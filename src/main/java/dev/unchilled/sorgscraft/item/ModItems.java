package dev.unchilled.sorgscraft.item;

import java.util.List;

import dev.unchilled.sorgscraft.sorgscraft;
import dev.unchilled.sorgscraft.item.custom.Adderall;
import dev.unchilled.sorgscraft.item.custom.Curry;
import dev.unchilled.sorgscraft.item.custom.GapEffects;
import dev.unchilled.sorgscraft.item.custom.Milk;
import dev.unchilled.sorgscraft.item.custom.RobsHand;
import dev.unchilled.sorgscraft.item.custom.Tinder;
import dev.unchilled.sorgscraft.item.custom.Vape;
import net.minecraft.world.World;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, sorgscraft.MOD_ID);

    public static final RegistryObject<Item> TOOTH_OF_THE_GOBLIN = ITEMS.register("tooth_of_the_goblin",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SORGS_TAB)));

    public static final RegistryObject<Item> THE_GAP = ITEMS.register("the_gap",
        () -> new GapEffects(new Item.Properties().tab(ModCreativeModeTab.SORGS_TAB)));

    public static final RegistryObject<Item> GREASE_DROP = ITEMS.register("grease_drop",
    () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SORGS_TAB)));

    public static final RegistryObject<Item> AARALYNS_HOMEWORK = ITEMS.register("aaralyns_homework",
    () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SORGS_TAB)));

    public static final RegistryObject<Item> ADDERALL = ITEMS.register("adderall",
    () -> new Adderall(new Item.Properties().tab(ModCreativeModeTab.SORGS_TAB)) {
        @Override
        public void appendHoverText(ItemStack pStack, World pWorld, List<ITextComponent> tooltip, ITooltipFlag pIsAdvanced) {
        tooltip.add(new TranslationTextComponent("tooltip.item.sorgscraft.adderall"));
        tooltip.add(new StringTextComponent(""));
        tooltip.add(new TranslationTextComponent("tooltip.item.sorgscraft.adderall_effects"));
        super.appendHoverText(pStack, pWorld, tooltip, pIsAdvanced);
        }
    });

    public static final RegistryObject<Item> TINDER = ITEMS.register("tinder",
    () -> new Tinder(new Item.Properties().tab(ModCreativeModeTab.SORGS_TAB).stacksTo(1).durability(3)) {
        @Override
        public void appendHoverText(ItemStack pStack, World pLevel, List<ITextComponent> tooltip, ITooltipFlag pIsAdvanced) {
        tooltip.add(new TranslationTextComponent("tooltip.item.sorgscraft.tinder"));
        super.appendHoverText(pStack, pLevel, tooltip, pIsAdvanced);
        }
    });

    public static final RegistryObject<Item> ROBS_HAND = ITEMS.register("robs_hand",
    () -> new RobsHand(ModItemTier.ROB, 1, -2.4f, new Item.Properties().tab(ModCreativeModeTab.SORGS_TAB).stacksTo(1).durability(1000)));

    public static final RegistryObject<Item> FAITH_MILK = ITEMS.register("faith_milk",
    () -> new Milk(new Item.Properties().tab(ModCreativeModeTab.SORGS_TAB).stacksTo(64)));

    public static final RegistryObject<Item> AVA_MILK = ITEMS.register("ava_milk",
    () -> new Milk(new Item.Properties().tab(ModCreativeModeTab.SORGS_TAB).stacksTo(64)));

    public static final RegistryObject<Item> CURRY = ITEMS.register("curry",
    () -> new Curry(new Item.Properties().tab(ModCreativeModeTab.SORGS_TAB)));

    public static final RegistryObject<Item> VAPE = ITEMS.register("vape",
    () -> new Vape(new Item.Properties().tab(ModCreativeModeTab.SORGS_TAB).stacksTo(1).durability(300)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
