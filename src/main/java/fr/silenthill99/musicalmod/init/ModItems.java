package fr.silenthill99.musicalmod.init;

import fr.silenthill99.musicalmod.Main;
import fr.silenthill99.musicalmod.utils.ModItemGroups;
import fr.silenthill99.musicalmod.utils.ModSoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.MusicDiscItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MOD_ID);

    public static final RegistryObject<Item> STYLO = ITEMS.register("stylo", () -> new MusicDiscItem(1, ModSoundEvents.stylo, new Item.Properties().tab(ModItemGroups.MusicalMod).stacksTo(1)));
    public static final RegistryObject<Item> FEEL_GOOD_INC = ITEMS.register("feel_good_inc", () -> new MusicDiscItem(1, ModSoundEvents.feel_good_inc, new Item.Properties().tab(ModItemGroups.MusicalMod).stacksTo(1)));
    public static final RegistryObject<Item> DARE = ITEMS.register("dare", () -> new MusicDiscItem(1, ModSoundEvents.dare, new Item.Properties().tab(ModItemGroups.MusicalMod).stacksTo(1)));
    public static final RegistryObject<Item> CLINT_EASTWOOD = ITEMS.register("clint-eastwood", () -> new MusicDiscItem(1, ModSoundEvents.clint_eastwood, new Item.Properties().tab(ModItemGroups.MusicalMod).stacksTo(1)));
    public static final RegistryObject<Item> ON_MELANCHOLY_HILL = ITEMS.register("on_melancholy_hill", () -> new MusicDiscItem(1, ModSoundEvents.on_melancholy_hill, new Item.Properties().tab(ModItemGroups.MusicalMod).stacksTo(1)));
    public static final RegistryObject<Item> GOOD_4_U = ITEMS.register("good-4-u", () -> new MusicDiscItem(1, ModSoundEvents.good_4_u, new Item.Properties().tab(ModItemGroups.MusicalMod).stacksTo(1)));
    public static final RegistryObject<Item> L_AMOUR_NOUS_GUIDERA = ITEMS.register("l-amour-nous-guidera", () -> new MusicDiscItem(1, ModSoundEvents.l_amour_nous_guidera, new Item.Properties().tab(ModItemGroups.MusicalMod).stacksTo(1)));
    public static final RegistryObject<Item> DIRTY_HARRY = ITEMS.register("dirty-harry", () -> new MusicDiscItem(1, ModSoundEvents.dirty_harry, new Item.Properties().tab(ModItemGroups.MusicalMod).stacksTo(1)));
    public static final RegistryObject<Item> YA_PAS_QUE_LES_GRANDS_QUI_REVENT = ITEMS.register("ya_pas_que_les_grands_qui_revent", () -> new MusicDiscItem(1, ModSoundEvents.ya_pas_que_les_grands_qui_revent, new Item.Properties().tab(ModItemGroups.MusicalMod).stacksTo(1)));
    public static final RegistryObject<Item> LOSE_YOURSELF = ITEMS.register("lose-yourself", () -> new MusicDiscItem(1, ModSoundEvents.lose_yourself, new Item.Properties().stacksTo(1).tab(ModItemGroups.MusicalMod)));
    public static final RegistryObject<Item> CHUT = ITEMS.register("chut", () -> new MusicDiscItem(1, ModSoundEvents.chut, new Item.Properties().stacksTo(1).tab(ModItemGroups.MusicalMod)));
    public static final RegistryObject<Item> SOUS_LES_APPARENCES = ITEMS.register("sous-les-apparences", () -> new MusicDiscItem(1, ModSoundEvents.sous_les_apparences, new Item.Properties().stacksTo(1).tab(ModItemGroups.MusicalMod)));
    public static final RegistryObject<Item> DIXNEUF_DEUXMILLE = ITEMS.register("19-2000", () -> new MusicDiscItem(1, ModSoundEvents.dixneuf_deuxmille, new Item.Properties().tab(ModItemGroups.MusicalMod).stacksTo(1)));

    public static final RegistryObject<ForgeSpawnEggItem> NOODLE_SPAWN_EGG = ITEMS.register("noodle_spawn_egg", () -> new ForgeSpawnEggItem(EntityTypesInit.NOODLE, 0x990099, 0x0000FF, new Item.Properties().tab(ModItemGroups.GorillazGroup)));
    public static final RegistryObject<ForgeSpawnEggItem> MURDOC_SPAWN_EGG = ITEMS.register("murdoc_spawn_egg", () -> new ForgeSpawnEggItem(EntityTypesInit.MURDOC, 0x009900, 0x000000, new Item.Properties().tab(ModItemGroups.GorillazGroup)));
    public static final RegistryObject<ForgeSpawnEggItem> RUSSEL_SPAWN_EGG = ITEMS.register("russel_spawn_egg", () -> new ForgeSpawnEggItem(EntityTypesInit.RUSSEL, 0x663300, 0xffffff, new Item.Properties().tab(ModItemGroups.GorillazGroup)));
    public static final RegistryObject<ForgeSpawnEggItem> STUART_SPAWN_EGG = ITEMS.register("stuart_spawn_egg", () -> new ForgeSpawnEggItem(EntityTypesInit.STUART, 0xffffff, 0x3300ff, new Item.Properties().tab(ModItemGroups.GorillazGroup)));
}
