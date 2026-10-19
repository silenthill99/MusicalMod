package fr.silenthill99.musicalmod;

import fr.silenthill99.musicalmod.init.EntityTypesInit;
import fr.silenthill99.musicalmod.init.entities.murdoc.MurdocModel;
import fr.silenthill99.musicalmod.init.entities.murdoc.MurdocRenderer;
import fr.silenthill99.musicalmod.init.entities.noodle.NoodleModel;
import fr.silenthill99.musicalmod.init.entities.noodle.NoodleRenderer;
import fr.silenthill99.musicalmod.init.entities.russel.RusselModel;
import fr.silenthill99.musicalmod.init.entities.russel.RusselRenderer;
import fr.silenthill99.musicalmod.init.entities.stuart.StuartModel;
import fr.silenthill99.musicalmod.init.entities.stuart.StuartRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = Main.MOD_ID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = Main.MOD_ID, value = Dist.CLIENT)
public class MainClient {

    public MainClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityTypesInit.NOODLE.get(), NoodleRenderer::new);
        event.registerEntityRenderer(EntityTypesInit.MURDOC.get(), MurdocRenderer::new);
        event.registerEntityRenderer(EntityTypesInit.RUSSEL.get(), RusselRenderer::new);
        event.registerEntityRenderer(EntityTypesInit.STUART.get(), StuartRenderer::new);
    }

    @SubscribeEvent
    static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(NoodleModel.LAYER_LOCATION, NoodleModel::createBodyLayer);
        event.registerLayerDefinition(MurdocModel.LAYER_LOCATION, MurdocModel::createBodyLayer);
        event.registerLayerDefinition(RusselModel.LAYER_LOCATION, RusselModel::createBodyLayer);
        event.registerLayerDefinition(StuartModel.LAYER_LOCATION, StuartModel::createBodyLayer);
    }
}
