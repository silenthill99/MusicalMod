package fr.silenthill99.musicalmod.utils;

import fr.silenthill99.musicalmod.Main;
import fr.silenthill99.musicalmod.init.ModBlocks;
import fr.silenthill99.musicalmod.init.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModItemGroups {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, Main.MOD_ID);

    public static final Supplier<CreativeModeTab> MusicalMod = CREATIVE_MODE_TABS.register("musical_mod", () ->
        CreativeModeTab
                .builder()
                .icon(() -> new ItemStack(ModItems.STYLO.get()))
                .title(Component.translatable("itemGroup.Musical_Mod"))
                .withSearchBar()
                .displayItems((_, pOutput) -> {
                    pOutput.accept(ModItems.STYLO);
                    pOutput.accept(ModItems.FEEL_GOOD_INC);
                    pOutput.accept(ModItems.DARE);
                    pOutput.accept(ModItems.CLINT_EASTWOOD);
                    pOutput.accept(ModItems.ON_MELANCHOLY_HILL);
                    pOutput.accept(ModItems.GOOD_4_U);
                    pOutput.accept(ModItems.L_AMOUR_NOUS_GUIDERA);
                    pOutput.accept(ModItems.DIRTY_HARRY);
                    pOutput.accept(ModItems.YA_PAS_QUE_LES_GRANDS_QUI_REVENT);
                    pOutput.accept(ModItems.LOSE_YOURSELF);
                    pOutput.accept(ModItems.CHUT);
                    pOutput.accept(ModItems.SOUS_LES_APPARENCES);
                    pOutput.accept(ModItems.DIXNEUF_DEUXMILLE);
                })
                .build()
    );

    public static final Supplier<CreativeModeTab> GorillazGroup = CREATIVE_MODE_TABS.register("gorillaz_statue", () ->
            CreativeModeTab
                    .builder()
                    .title(Component.translatable("itemGroup.gorillaz_statue"))
                    .icon(() -> new ItemStack(ModBlocks.NOODLE))
                    .displayItems((_, pOutput) -> {
                        pOutput.accept(ModBlocks.NOODLE);
                        pOutput.accept(ModBlocks.MURDOC);
                        pOutput.accept(ModBlocks.DD);
                        pOutput.accept(ModBlocks.RUSSEL);
                        pOutput.accept(ModBlocks.CHAISE);
                        pOutput.accept(ModBlocks.CART);
                    })
                    .build());
}
