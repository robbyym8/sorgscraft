package dev.unchilled.sorgscraft.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModCreativeModeTab {
    public static final ItemGroup SORGS_TAB = new ItemGroup("SorgsCraftTab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.THE_GAP.get());
        }
    };
}


