package fr.silenthill99.musicalmod.init.entities.noodle;

import fr.silenthill99.musicalmod.Main;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

public class NoodleRenderer extends MobRenderer<Noodle, NoodleRenderState, NoodleModel<NoodleRenderState>> {

    public static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(Main.MOD_ID, "textures/entities/noodle.png");

    public NoodleRenderer(EntityRendererProvider.Context context) {
        super(context, new NoodleModel<>(context.bakeLayer(NoodleModel.LAYER_LOCATION)), 0.7f);
    }

    @Override
    public @NonNull Identifier getTextureLocation(@NonNull NoodleRenderState renderState) {
        return TEXTURE;
    }

    @Override
    public @NonNull NoodleRenderState createRenderState() {
        return new NoodleRenderState();
    }
}