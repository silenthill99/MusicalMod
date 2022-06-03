package fr.silenthill99.musicalmod.init.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

import javax.annotation.Nullable;
import java.util.stream.Stream;

@SuppressWarnings({"NullableProblems", "deprecation"})
public class Chaise extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final VoxelShape SHAPE_N = Stream.of(
            Block.box(0, 0, 0, 1, 15, 1),
            Block.box(15, 0, 0, 16, 15, 1),
            Block.box(15, 0, 15, 16, 15, 16),
            Block.box(0, 0, 15, 1, 15, 16),
            Block.box(0, 16, 15, 1, 32, 16),
            Block.box(15, 16, 15, 16, 32, 16),
            Block.box(0, 15, 0, 16, 16, 16),
            Block.box(1, 23, 15, 15, 32, 16)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();
    public static final VoxelShape SHAPE_S = Stream.of(
            Block.box(15, 0, 15, 16, 15, 16),
            Block.box(0, 0, 15, 1, 15, 16),
            Block.box(0, 0, 0, 1, 15, 1),
            Block.box(15, 0, 0, 16, 15, 1),
            Block.box(15, 16, 0, 16, 32, 1),
            Block.box(0, 16, 0, 1, 32, 1),
            Block.box(0, 15, 0, 16, 16, 16),
            Block.box(1, 23, 0, 15, 32, 1)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();
    public static final VoxelShape SHAPE_E = Stream.of(
            Block.box(15, 0, 0, 16, 15, 1),
            Block.box(15, 0, 15, 16, 15, 16),
            Block.box(0, 0, 15, 1, 15, 16),
            Block.box(0, 0, 0, 1, 15, 1),
            Block.box(0, 16, 0, 1, 32, 1),
            Block.box(0, 16, 15, 1, 32, 16),
            Block.box(0, 15, 0, 16, 16, 16),
            Block.box(0, 23, 1, 1, 32, 15)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();
    public static final VoxelShape SHAPE_O = Stream.of(
            Block.box(0, 0, 15, 1, 15, 16),
            Block.box(0, 0, 0, 1, 15, 1),
            Block.box(15, 0, 0, 16, 15, 1),
            Block.box(15, 0, 15, 16, 15, 16),
            Block.box(15, 16, 15, 16, 32, 16),
            Block.box(15, 16, 0, 16, 32, 1),
            Block.box(0, 15, 0, 16, 16, 16),
            Block.box(15, 23, 1, 16, 32, 15)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn_, BlockPos pos, ISelectionContext context) {
        switch (state.getValue(FACING)){
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_O;
            default:
                return SHAPE_N;
        }
    }

    public Chaise() {
        super(AbstractBlock.Properties.of(Material.STONE));
    }

    @Override
    public BlockState rotate(BlockState state, IWorld world, BlockPos pos, Rotation direction) {
        return state.setValue(FACING, direction.rotate(state.getValue(FACING)));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
    }

}
