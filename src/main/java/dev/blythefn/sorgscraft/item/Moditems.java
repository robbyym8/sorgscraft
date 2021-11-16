package dev.blythefn.sorgscraft.item;

import dev.blythefn.sorgscraft.sorgscraft;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
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
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SORGS_TAB)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
