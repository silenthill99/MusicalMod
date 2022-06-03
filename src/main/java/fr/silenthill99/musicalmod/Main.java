package fr.silenthill99.musicalmod;

import fr.silenthill99.musicalmod.init.EntityTypesInit;
import fr.silenthill99.musicalmod.init.ModBlocks;
import fr.silenthill99.musicalmod.init.ModItems;
import fr.silenthill99.musicalmod.init.entities.murdoc.Murdoc;
import fr.silenthill99.musicalmod.init.entities.murdoc.MurdocRenderer;
import fr.silenthill99.musicalmod.init.entities.noodle.Noodle;
import fr.silenthill99.musicalmod.init.entities.noodle.NoodleRenderer;
import fr.silenthill99.musicalmod.init.entities.russel.Russel;
import fr.silenthill99.musicalmod.init.entities.russel.RusselRenderer;
import fr.silenthill99.musicalmod.init.entities.stuart.Stuart;
import fr.silenthill99.musicalmod.init.entities.stuart.StuartRenderer;
import fr.silenthill99.musicalmod.utils.ModSoundEvents;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Main.MOD_ID)
public class Main {
    public static final String MOD_ID = "musical_mod";

    public Main() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onEntityAttributeCreation);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);
        ModSoundEvents.SOUND_EVENTS.register(bus);
        EntityTypesInit.ENTITY_TYPE.register(bus);

    }

    private void clientSetup(FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(ModBlocks.NOODLE.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.MURDOC.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.DD.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.RUSSEL.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.CHAISE.get(), RenderType.cutout());
        RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.NOODLE.get(), NoodleRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.MURDOC.get(), MurdocRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.RUSSEL.get(), RusselRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.STUART.get(), StuartRenderer::new);
    }


    private void setup(FMLCommonSetupEvent event) {
        /*
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(EntityTypesInit.NOODLE.get(), Noodle.setAttributes().build());
            GlobalEntityTypeAttributes.put(EntityTypesInit.MURDOC.get(), Murdoc.setAttributes().build());
        });
         */

    }

    public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
        event.put(EntityTypesInit.NOODLE.get(), Noodle.setAttributes().build());
        event.put(EntityTypesInit.MURDOC.get(), Murdoc.setAttributes().build());
        event.put(EntityTypesInit.RUSSEL.get(), Russel.setAttributes().build());
        event.put(EntityTypesInit.STUART.get(), Stuart.setAttributes().build());
    }

}
