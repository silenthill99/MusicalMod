package fr.silenthill99.musicalmod.data.models;

import fr.silenthill99.musicalmod.Main;
import fr.silenthill99.musicalmod.init.ModBlocks;
import fr.silenthill99.musicalmod.init.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import org.jspecify.annotations.NonNull;

public class ModelGenerator extends ModelProvider {
    public ModelGenerator(PackOutput output) {
        super(output, Main.MOD_ID);
    }

    @Override
    protected void registerModels(@NonNull BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        Item[] items = {
                ModItems.STYLO.get(),
                ModItems.FEEL_GOOD_INC.get(),
                ModItems.DARE.get(),
                ModItems.CLINT_EASTWOOD.get(),
                ModItems.ON_MELANCHOLY_HILL.get(),
                ModItems.GOOD_4_U.get(),
                ModItems.L_AMOUR_NOUS_GUIDERA.get(),
                ModItems.DIRTY_HARRY.get(),
                ModItems.YA_PAS_QUE_LES_GRANDS_QUI_REVENT.get(),
                ModItems.LOSE_YOURSELF.get(),
                ModItems.CHUT.get(),
                ModItems.SOUS_LES_APPARENCES.get(),
                ModItems.DIXNEUF_DEUXMILLE.get(),
        };
        itemModels.generateFlatItem(ModItems.CD.get(), ModelTemplates.FLAT_ITEM);
        for (Item item : items) {
            itemModels.generateFlatItem(item, ModItems.CD.get(), ModelTemplates.FLAT_ITEM);
        }

        blockModels.createNonTemplateHorizontalBlock(ModBlocks.MURDOC.get());
        blockModels.createNonTemplateHorizontalBlock(ModBlocks.NOODLE.get());
        blockModels.createNonTemplateHorizontalBlock(ModBlocks.DD.get());
        blockModels.createNonTemplateHorizontalBlock(ModBlocks.RUSSEL.get());
        blockModels.createNonTemplateHorizontalBlock(ModBlocks.CHAISE.get());
        blockModels.createNonTemplateHorizontalBlock(ModBlocks.CART.get());
    }
}
