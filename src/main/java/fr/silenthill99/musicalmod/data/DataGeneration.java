package fr.silenthill99.musicalmod.data;

import fr.silenthill99.musicalmod.Main;
import fr.silenthill99.musicalmod.data.models.ModelGenerator;
import fr.silenthill99.musicalmod.data.registries.ModJukeboxSong;
import fr.silenthill99.musicalmod.data.sounds.SoundDefinitionsGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = Main.MOD_ID)
public class DataGeneration {
    @SubscribeEvent
    public static void gaherData(final GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();

        generator.addProvider(true, new ModelGenerator(packOutput));
        generator.addProvider(true, new SoundDefinitionsGenerator(packOutput));

        event.createDatapackRegistryObjects(new RegistrySetBuilder()
                .add(Registries.JUKEBOX_SONG, ModJukeboxSong::bootstrap));
    }
}
