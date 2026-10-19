package fr.silenthill99.musicalmod;

import fr.silenthill99.musicalmod.init.EntityTypesInit;
import fr.silenthill99.musicalmod.init.ModBlocks;
import fr.silenthill99.musicalmod.init.ModItems;
import fr.silenthill99.musicalmod.init.entities.murdoc.Murdoc;
import fr.silenthill99.musicalmod.init.entities.noodle.Noodle;
import fr.silenthill99.musicalmod.init.entities.russel.Russel;
import fr.silenthill99.musicalmod.init.entities.stuart.Stuart;
import fr.silenthill99.musicalmod.utils.ModItemGroups;
import fr.silenthill99.musicalmod.utils.ModSoundEvents;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@Mod(Main.MOD_ID)
public class Main {
    public static final String MOD_ID = "musical_mod";

    public Main(IEventBus modBus) {
        modBus.addListener(this::setup);
        modBus.addListener(this::onEntityAttributeCreation);

        ModItems.ITEMS.register(modBus);
        ModBlocks.BLOCKS.register(modBus);
        ModSoundEvents.SOUND_EVENTS.register(modBus);
        EntityTypesInit.ENTITY_TYPE.register(modBus);
        ModItemGroups.CREATIVE_MODE_TABS.register(modBus);
    }

    private void setup(FMLCommonSetupEvent event) {

    }

    private void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
        event.put(EntityTypesInit.NOODLE.get(), Noodle.setAttributes().build());
        event.put(EntityTypesInit.MURDOC.get(), Murdoc.setAttributes().build());
        event.put(EntityTypesInit.RUSSEL.get(), Russel.setAttributes().build());
        event.put(EntityTypesInit.STUART.get(), Stuart.setAttributes().build());
    }

}