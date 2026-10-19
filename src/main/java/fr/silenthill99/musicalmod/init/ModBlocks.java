package fr.silenthill99.musicalmod.init;

import fr.silenthill99.musicalmod.Main;
import fr.silenthill99.musicalmod.init.blocks.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = net.neoforged.neoforge.registries.DeferredRegister.createBlocks(Main.MOD_ID);

    public static final DeferredBlock<Block> NOODLE = createBlock("noodle", StatueNoodle::new);
    public static final DeferredBlock<Block> MURDOC = createBlock("murdoc", StatueMurdoc::new);
    public static final DeferredBlock<Block> DD = createBlock("2d", Statue2D::new);
    public static final DeferredBlock<Block> RUSSEL = createBlock("russel", StatueRussel::new);
    public static final DeferredBlock<Block> CHAISE = createBlock("chaise", Chaise::new);
    public static final DeferredBlock<Block> CART = createBlock("cart", Cart::new);

    public static <T extends Block> DeferredBlock<T> createBlock(String name, Function<BlockBehaviour.Properties, ? extends T> function) {
        DeferredBlock<T> block = BLOCKS.registerBlock(name, function);
        ModItems.ITEMS.registerItem(name, properties -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
        return block;
    }
}
