package fr.silenthill99.musicalmod.init.entities.russel;

import fr.silenthill99.musicalmod.Main;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RusselRenderer extends MobRenderer<Russel, RusselModel<Russel>>
{

    public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entities/russel.png");

    public RusselRenderer(EntityRendererManager manager)
    {
        super(manager, new RusselModel<>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(Russel p_110775_1_)
    {
        return TEXTURE;
    }
}
