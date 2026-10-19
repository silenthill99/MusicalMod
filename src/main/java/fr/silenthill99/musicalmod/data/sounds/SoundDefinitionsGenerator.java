package fr.silenthill99.musicalmod.data.sounds;

import fr.silenthill99.musicalmod.Main;
import fr.silenthill99.musicalmod.utils.ModSoundEvents;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

public class SoundDefinitionsGenerator extends SoundDefinitionsProvider {
    /**
     * Creates a new instance of this data provider.
     *
     * @param output The {@linkplain PackOutput} instance provided by the data generator.
     */
    public SoundDefinitionsGenerator(PackOutput output) {
        super(output, Main.MOD_ID);
    }

    @Override
    public void registerSounds() {
        add(ModSoundEvents.stylo, SoundDefinition.definition()
                .with(sound(Identifier.fromNamespaceAndPath(Main.MOD_ID, "gorillaz-stylo")).stream()));
    }
}
