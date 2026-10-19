package fr.silenthill99.musicalmod.init;

import fr.silenthill99.musicalmod.Main;
import fr.silenthill99.musicalmod.data.registries.ModJukeboxSong;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = net.neoforged.neoforge.registries.DeferredRegister.createItems(Main.MOD_ID);

    public static final DeferredItem<Item> STYLO = ITEMS.registerItem("stylo", (properties) -> new Item(properties.jukeboxPlayable(ModJukeboxSong.STYLO).stacksTo(1)));
    public static final DeferredItem<Item> FEEL_GOOD_INC = ITEMS.registerItem("feel_good_inc", (properties) -> new Item(properties.jukeboxPlayable(ModJukeboxSong.FEEL_GOOD_INC).stacksTo(1)));
    public static final DeferredItem<Item> DARE = ITEMS.registerItem("dare", properties -> new Item(properties.jukeboxPlayable(ModJukeboxSong.DARE).stacksTo(1)));
    public static final DeferredItem<Item> CLINT_EASTWOOD = ITEMS.registerItem("clint-eastwood", properties -> new Item(properties.jukeboxPlayable(ModJukeboxSong.CLINT_EASTWOOD).stacksTo(1)));
    public static final DeferredItem<Item> ON_MELANCHOLY_HILL = ITEMS.registerItem("on_melancholy_hill", properties -> new Item(properties.jukeboxPlayable(ModJukeboxSong.ON_MELANCHOLY_HILL).stacksTo(1)));
    public static final DeferredItem<Item> GOOD_4_U = ITEMS.registerItem("good-4-u", properties -> new Item(properties.jukeboxPlayable(ModJukeboxSong.GOOD_4_U).stacksTo(1)));
    public static final DeferredItem<Item> L_AMOUR_NOUS_GUIDERA = ITEMS.registerItem("l-amour-nous-guidera", properties -> new Item(properties.jukeboxPlayable(ModJukeboxSong.LAMOUR_NOUS_GUIDERA).stacksTo(1)));
    public static final DeferredItem<Item> DIRTY_HARRY = ITEMS.registerItem("dirty-harry", properties -> new Item(properties.jukeboxPlayable(ModJukeboxSong.DIRTY_HARRY).stacksTo(1)));
    public static final DeferredItem<Item> YA_PAS_QUE_LES_GRANDS_QUI_REVENT = ITEMS.registerItem("ya_pas_que_les_grands_qui_revent", properties -> new Item(properties.jukeboxPlayable(ModJukeboxSong.YA_PAS_QUE_LES_GRANDS_QUI_REVENT).stacksTo(1)));
    public static final DeferredItem<Item> LOSE_YOURSELF = ITEMS.registerItem("lose-yourself", properties -> new Item(properties.jukeboxPlayable(ModJukeboxSong.LOSE_YOURSELF).stacksTo(1)));
    public static final DeferredItem<Item> CHUT = ITEMS.registerItem("chut", properties -> new Item(properties.jukeboxPlayable(ModJukeboxSong.CHUT).stacksTo(1)));
    public static final DeferredItem<Item> SOUS_LES_APPARENCES = ITEMS.registerItem("sous-les-apparences", properties -> new Item(properties.jukeboxPlayable(ModJukeboxSong.SOUS_LES_APPARENCES).stacksTo(1)));
    public static final DeferredItem<Item> DIXNEUF_DEUXMILLE = ITEMS.registerItem("19-2000", properties -> new Item(properties.jukeboxPlayable(ModJukeboxSong.DIXNEUF_DEUXMILLE).stacksTo(1)));

    public static final DeferredItem<Item> CD = ITEMS.registerItem("cd", Item::new);

//    public static final DeferredItem<SpawnEggItem> NOODLE_SPAWN_EGG = ITEMS.registerItem("noodle_spawn_egg", () -> new SpawnEggItem(EntityTypesInit.NOODLE, 0x990099, 0x0000FF, new Item.Properties().tab(ModItemGroups.GorillazGroup)));
//    public static final DeferredItem<SpawnEggItem> NOODLE_SPAWN_EGG = ITEMS.registerItem("noodle_spawn_egg", properties -> new SpawnEggItem(properties.spawnEgg(EntityTypesInit.NOODLE.get()).tab(ModItemGroups.GorillazGroup)));
//    public static final DeferredItem<SpawnEggItem> MURDOC_SPAWN_EGG = ITEMS.registerItem("murdoc_spawn_egg", () -> new SpawnEggItem(EntityTypesInit.MURDOC, 0x009900, 0x000000, new Item.Properties().tab(ModItemGroups.GorillazGroup)));
//    public static final DeferredItem<ForgeSpawnEggItem> RUSSEL_SPAWN_EGG = ITEMS.registerItem("russel_spawn_egg", () -> new ForgeSpawnEggItem(EntityTypesInit.RUSSEL, 0x663300, 0xffffff, new Item.Properties().tab(ModItemGroups.GorillazGroup)));
//    public static final DeferredItem<ForgeSpawnEggItem> STUART_SPAWN_EGG = ITEMS.registerItem("stuart_spawn_egg", () -> new ForgeSpawnEggItem(EntityTypesInit.STUART, 0xffffff, 0x3300ff, new Item.Properties().tab(ModItemGroups.GorillazGroup)));
}
