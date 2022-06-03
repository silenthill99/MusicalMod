package fr.silenthill99.musicalmod.init;

import fr.silenthill99.musicalmod.Main;
import fr.silenthill99.musicalmod.init.blocks.*;
import fr.silenthill99.musicalmod.utils.ModItemGroups;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MOD_ID);

    public static final RegistryObject<Block> NOODLE = createBlock("noodle", StatueNoodle::new);
    public static final RegistryObject<Block> MURDOC = createBlock("murdoc", StatueMurdoc::new);
    public static final RegistryObject<Block> DD = createBlock("2d", Statue2D::new);
    public static final RegistryObject<Block> RUSSEL = createBlock("russel", StatueRussel::new);
    public static final RegistryObject<Block> CHAISE = createBlock("chaise", Chaise::new);
    public static final RegistryObject<Block> CART = createBlock("cart", Cart::new);

    public static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier) {
        RegistryObject<Block> block = BLOCKS.register(name, supplier);
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(ModItemGroups.GorillazGroup)));
        return block;
    }
}
