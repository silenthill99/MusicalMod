package fr.silenthill99.musicalmod.utils;

import fr.silenthill99.musicalmod.Main;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Main.MOD_ID);

    public static final RegistryObject<SoundEvent> stylo = registerSoundEvent("stylo");
    public static final RegistryObject<SoundEvent> feel_good_inc = registerSoundEvent("feel-good-inc");
    public static final RegistryObject<SoundEvent> dare = registerSoundEvent("dare");
    public static final RegistryObject<SoundEvent> clint_eastwood = registerSoundEvent("clint-eastwood");
    public static final RegistryObject<SoundEvent> on_melancholy_hill = registerSoundEvent("on-melancholy-hill");
    public static final RegistryObject<SoundEvent> good_4_u = registerSoundEvent("good-4-u");
    public static final RegistryObject<SoundEvent> l_amour_nous_guidera = registerSoundEvent("l-amour-nous-guidera");
    public static final RegistryObject<SoundEvent> dirty_harry = registerSoundEvent("dirty-harry");
    public static final RegistryObject<SoundEvent> ya_pas_que_les_grands_qui_revent = registerSoundEvent("ya-pas-que-les-grands-qui-revent");
    public static final RegistryObject<SoundEvent> lose_yourself = registerSoundEvent("lose-yourself");
    public static final RegistryObject<SoundEvent> chut = registerSoundEvent("chut");
    public static final RegistryObject<SoundEvent> sous_les_apparences = registerSoundEvent("sous-les-apparences");
    public static final RegistryObject<SoundEvent> dixneuf_deuxmille = registerSoundEvent("19-2000");

    public static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(Main.MOD_ID, name)));
    }
}
