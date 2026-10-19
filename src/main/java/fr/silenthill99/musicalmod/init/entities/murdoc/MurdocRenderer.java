package fr.silenthill99.musicalmod.init.entities.murdoc;


import fr.silenthill99.musicalmod.Main;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

public class MurdocRenderer extends MobRenderer<Murdoc, MurdocRenderState, MurdocModel<MurdocRenderState>>
{

    public static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(Main.MOD_ID, "textures/entities/murdoc.png");

    public MurdocRenderer(EntityRendererProvider.Context context) {
        super(context, new MurdocModel<>(context.bakeLayer(MurdocModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public @NonNull Identifier getTextureLocation(@NonNull MurdocRenderState renderState) {
        return TEXTURE;
    }

    @Override
    public @NonNull MurdocRenderState createRenderState() {
        return new MurdocRenderState();
    }
}
