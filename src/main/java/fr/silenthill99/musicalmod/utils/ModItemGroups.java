package fr.silenthill99.musicalmod.utils;

import fr.silenthill99.musicalmod.init.ModBlocks;
import fr.silenthill99.musicalmod.init.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroups {

    public static final ItemGroup MusicalMod = new ItemGroup("Musical_Mod") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.STYLO.get());
        }

        @Override
        public boolean hasSearchBar() {
            return true;
        }
    };
    public static final ItemGroup GorillazGroup = new ItemGroup("gorillaz_statue") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.NOODLE.get());
        }
    };
}
