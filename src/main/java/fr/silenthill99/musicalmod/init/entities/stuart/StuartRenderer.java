package fr.silenthill99.musicalmod.init.entities.stuart;

import fr.silenthill99.musicalmod.Main;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class StuartRenderer extends MobRenderer<Stuart, StuartModel<Stuart>>
{

    public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entities/dd.png");

    public StuartRenderer(EntityRendererManager manager)
    {
        super(manager, new StuartModel<>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(Stuart p_110775_1_)
    {
        return TEXTURE;
    }
}
