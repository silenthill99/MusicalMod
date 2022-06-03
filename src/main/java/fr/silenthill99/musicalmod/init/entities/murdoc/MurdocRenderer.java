package fr.silenthill99.musicalmod.init.entities.murdoc;


import fr.silenthill99.musicalmod.Main;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class MurdocRenderer extends MobRenderer<Murdoc, MurdocModel<Murdoc>>
{

    public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entities/murdoc.png");

    public MurdocRenderer(EntityRendererManager manager)
    {
        super(manager, new MurdocModel<>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(Murdoc p_110775_1_)
    {
        return TEXTURE;
    }
}
