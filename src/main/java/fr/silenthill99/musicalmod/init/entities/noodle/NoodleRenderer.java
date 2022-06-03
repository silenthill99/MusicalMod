package fr.silenthill99.musicalmod.init.entities.noodle;

import fr.silenthill99.musicalmod.Main;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class NoodleRenderer extends MobRenderer<Noodle, NoodleModel<Noodle>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entities/noodle.png");

    public NoodleRenderer(EntityRendererManager manager) {
        super(manager, new NoodleModel<>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(Noodle noodle) {
        return TEXTURE;
    }
}
