package dev.blythefn.sorgscraft.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab SORGS_TAB = new CreativeModeTab("SorgsCraftTab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Moditems.THE_GAP.get());
        }
    };
}


