package fr.silenthill99.musicalmod.utils;

import fr.silenthill99.musicalmod.Main;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, Main.MOD_ID);

    public static final DeferredHolder<SoundEvent, SoundEvent> stylo = registerSoundEvent("stylo");
    public static final DeferredHolder<SoundEvent, SoundEvent> feel_good_inc = registerSoundEvent("feel-good-inc");
    public static final DeferredHolder<SoundEvent, SoundEvent> dare = registerSoundEvent("dare");
    public static final DeferredHolder<SoundEvent, SoundEvent> clint_eastwood = registerSoundEvent("clint-eastwood");
    public static final DeferredHolder<SoundEvent, SoundEvent> on_melancholy_hill = registerSoundEvent("on-melancholy-hill");
    public static final DeferredHolder<SoundEvent, SoundEvent> good_4_u = registerSoundEvent("good-4-u");
    public static final DeferredHolder<SoundEvent, SoundEvent> l_amour_nous_guidera = registerSoundEvent("l-amour-nous-guidera");
    public static final DeferredHolder<SoundEvent, SoundEvent> dirty_harry = registerSoundEvent("dirty-harry");
    public static final DeferredHolder<SoundEvent, SoundEvent> ya_pas_que_les_grands_qui_revent = registerSoundEvent("ya-pas-que-les-grands-qui-revent");
    public static final DeferredHolder<SoundEvent, SoundEvent> lose_yourself = registerSoundEvent("lose-yourself");
    public static final DeferredHolder<SoundEvent, SoundEvent> chut = registerSoundEvent("chut");
    public static final DeferredHolder<SoundEvent, SoundEvent> sous_les_apparences = registerSoundEvent("sous-les-apparences");
    public static final DeferredHolder<SoundEvent, SoundEvent> dixneuf_deuxmille = registerSoundEvent("19-2000");

    public static DeferredHolder<SoundEvent, SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath(Main.MOD_ID, name)));
    }
}
