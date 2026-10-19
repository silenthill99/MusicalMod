package fr.silenthill99.musicalmod.init.entities.stuart;

import fr.silenthill99.musicalmod.Main;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

public class StuartRenderer extends MobRenderer<Stuart, StuartRenderState, StuartModel<StuartRenderState>> {

    public static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(Main.MOD_ID, "textures/entities/dd.png");

    public StuartRenderer(EntityRendererProvider.Context context) {
        super(context, new StuartModel<>(context.bakeLayer(StuartModel.LAYER_LOCATION)), 0.7f);
    }

    @Override
    public @NonNull Identifier getTextureLocation(@NonNull StuartRenderState renderState) {
        return TEXTURE;
    }

    @Override
    public @NonNull StuartRenderState createRenderState() {
        return new StuartRenderState();
    }
}