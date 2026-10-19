package fr.silenthill99.musicalmod.data.registries;

import fr.silenthill99.musicalmod.Main;
import fr.silenthill99.musicalmod.utils.ModSoundEvents;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.JukeboxSong;

import javax.swing.*;

public class ModJukeboxSong {
    public static final ResourceKey<JukeboxSong> STYLO = ResourceKey.create(Registries.JUKEBOX_SONG, Identifier.fromNamespaceAndPath(Main.MOD_ID, ModSoundEvents.stylo.getId().getPath()));
    public static final ResourceKey<JukeboxSong> FEEL_GOOD_INC = ResourceKey.create(Registries.JUKEBOX_SONG, Identifier.fromNamespaceAndPath(Main.MOD_ID, ModSoundEvents.feel_good_inc.getId().getPath()));
    public static final ResourceKey<JukeboxSong> DARE = ResourceKey.create(Registries.JUKEBOX_SONG, Identifier.fromNamespaceAndPath(Main.MOD_ID, ModSoundEvents.dare.getId().getPath()));
    public static final ResourceKey<JukeboxSong> CLINT_EASTWOOD = ResourceKey.create(Registries.JUKEBOX_SONG, Identifier.fromNamespaceAndPath(Main.MOD_ID, ModSoundEvents.clint_eastwood.getId().getPath()));
    public static final ResourceKey<JukeboxSong> ON_MELANCHOLY_HILL = ResourceKey.create(Registries.JUKEBOX_SONG, Identifier.fromNamespaceAndPath(Main.MOD_ID, ModSoundEvents.on_melancholy_hill.getId().getPath()));
    public static final ResourceKey<JukeboxSong> GOOD_4_U = ResourceKey.create(Registries.JUKEBOX_SONG, Identifier.fromNamespaceAndPath(Main.MOD_ID, ModSoundEvents.good_4_u.getId().getPath()));
    public static final ResourceKey<JukeboxSong> LAMOUR_NOUS_GUIDERA = ResourceKey.create(Registries.JUKEBOX_SONG, Identifier.fromNamespaceAndPath(Main.MOD_ID, ModSoundEvents.l_amour_nous_guidera.getId().getPath()));
    public static final ResourceKey<JukeboxSong> DIRTY_HARRY = ResourceKey.create(Registries.JUKEBOX_SONG, Identifier.fromNamespaceAndPath(Main.MOD_ID, ModSoundEvents.dirty_harry.getId().getPath()));
    public static final ResourceKey<JukeboxSong> YA_PAS_QUE_LES_GRANDS_QUI_REVENT = ResourceKey.create(Registries.JUKEBOX_SONG, Identifier.fromNamespaceAndPath(Main.MOD_ID, ModSoundEvents.ya_pas_que_les_grands_qui_revent.getId().getPath()));
    public static final ResourceKey<JukeboxSong> LOSE_YOURSELF = ResourceKey.create(Registries.JUKEBOX_SONG, Identifier.fromNamespaceAndPath(Main.MOD_ID,
            ModSoundEvents.lose_yourself.getId().getPath()));
    public static final ResourceKey<JukeboxSong> CHUT = create(ModSoundEvents.chut.getId().getPath());
    public static final ResourceKey<JukeboxSong> SOUS_LES_APPARENCES = create(ModSoundEvents.sous_les_apparences.getId().getPath());
    public static final ResourceKey<JukeboxSong> DIXNEUF_DEUXMILLE = create(ModSoundEvents.dixneuf_deuxmille.getId().getPath());

    public static void bootstrap(BootstrapContext<JukeboxSong> context) {
        context.register(STYLO, new JukeboxSong(ModSoundEvents.stylo, Component.translatable("item.musical_mod.stylo.desc"), 302, 1));
        context.register(FEEL_GOOD_INC, new JukeboxSong(ModSoundEvents.feel_good_inc, Component.translatable("item.musical_mod.feel_good_inc.desc"), 221, 1));
        context.register(DARE, new JukeboxSong(ModSoundEvents.feel_good_inc, Component.translatable("item.musical_mod.dare.desc"), 213, 1));
        context.register(CLINT_EASTWOOD, new JukeboxSong(ModSoundEvents.clint_eastwood, Component.translatable("item.musical_mod.clint-eastwood.desc"), 268, 1));
        context.register(ON_MELANCHOLY_HILL, new JukeboxSong(ModSoundEvents.on_melancholy_hill, Component.translatable("item.musical_mod.on_melancholy_hill.desc"), 233, 1));
        context.register(GOOD_4_U, new JukeboxSong(ModSoundEvents.good_4_u, Component.translatable("item.musical_mod.good-4-u.desc"), 178, 1));
        context.register(LAMOUR_NOUS_GUIDERA, new JukeboxSong(ModSoundEvents.l_amour_nous_guidera, Component.translatable("item.musical_mod.l-amour-nous-guidera.desc"), 172, 1));
        context.register(DIRTY_HARRY, new JukeboxSong(ModSoundEvents.dirty_harry, Component.translatable("item.musical_mod.dirty-harry.desc"), 223, 1));
        context.register(YA_PAS_QUE_LES_GRANDS_QUI_REVENT, new JukeboxSong(ModSoundEvents.ya_pas_que_les_grands_qui_revent, Component.translatable("item.musical_mod.ya_pas_que_les_grands_qui_revent.desc"), 231, 1));
        context.register(LOSE_YOURSELF, new JukeboxSong(ModSoundEvents.lose_yourself, Component.translatable("item.musical_mod.lose-yourself.desc"), 323, 1));
        context.register(CHUT, new JukeboxSong(ModSoundEvents.chut, Component.translatable("item.musical_mod.chut.desc"), 183, 1));
        context.register(SOUS_LES_APPARENCES, new JukeboxSong(ModSoundEvents.sous_les_apparences, Component.translatable("item.musical_mod.sous-les-apparences.desc"), 205, 1));
        context.register(DIXNEUF_DEUXMILLE, new JukeboxSong(ModSoundEvents.dixneuf_deuxmille, Component.translatable("item.musical_mod.19-2000.desc"), 207, 1));
    }

    private static ResourceKey<JukeboxSong> create(String name) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, Identifier.fromNamespaceAndPath(Main.MOD_ID, name));
    }
}
