package fr.silenthill99.musicalmod.init.entities.russel;

import fr.silenthill99.musicalmod.Main;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

public class RusselRenderer extends MobRenderer<Russel, RusselRenderState, RusselModel<RusselRenderState>> {

    public static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(Main.MOD_ID, "textures/entities/russel.png");

    public RusselRenderer(EntityRendererProvider.Context context) {
        super(context, new RusselModel<>(context.bakeLayer(RusselModel.LAYER_LOCATION)), 0.7f);
    }

    @Override
    public @NonNull Identifier getTextureLocation(@NonNull RusselRenderState renderState) {
        return TEXTURE;
    }

    @Override
    public @NonNull RusselRenderState createRenderState() {
        return new RusselRenderState();
    }
}