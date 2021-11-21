package dev.unchilled.sorgscraft;

import dev.unchilled.sorgscraft.block.ModBlocks;
import dev.unchilled.sorgscraft.item.Moditems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(sorgscraft.MOD_ID)
public class sorgscraft
{
    public static final String MOD_ID = "sorgscraft";

    public sorgscraft() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        Moditems.register(eventBus);
        ModBlocks.register(eventBus);

        eventBus.addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
    }
}
