package fr.silenthill99.musicalmod.init.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
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
public class Cart extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public static final VoxelShape SHAPE_N = Stream.of(
            Block.box(0, 0, 1, 1, 3, 4),
            Block.box(0, 0, 12, 1, 3, 15),
            Block.box(15, 0, 12, 16, 3, 15),
            Block.box(15, 0, 1, 16, 3, 4),
            Block.box(1, 1, 2, 15, 2, 3),
            Block.box(1, 1, 13, 15, 2, 14),
            Block.box(1, 2, 0, 15, 3, 16),
            Block.box(1, 3, 0, 15, 8, 1),
            Block.box(1, 3, 15, 15, 8, 16),
            Block.box(14, 3, 1, 15, 8, 15),
            Block.box(1, 3, 1, 2, 8, 15)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    public static final VoxelShape SHAPE_S = Stream.of(
            Block.box(15, 0, 12, 16, 3, 15),
            Block.box(15, 0, 1, 16, 3, 4),
            Block.box(0, 0, 1, 1, 3, 4),
            Block.box(0, 0, 12, 1, 3, 15),
            Block.box(1, 1, 13, 15, 2, 14),
            Block.box(1, 1, 2, 15, 2, 3),
            Block.box(1, 2, 0, 15, 3, 16),
            Block.box(1, 3, 15, 15, 8, 16),
            Block.box(1, 3, 0, 15, 8, 1),
            Block.box(1, 3, 1, 2, 8, 15),
            Block.box(14, 3, 1, 15, 8, 15)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    public static final VoxelShape SHAPE_E = Stream.of(
            Block.box(12, 0, 0, 15, 3, 1),
            Block.box(1, 0, 0, 4, 3, 1),
            Block.box(1, 0, 15, 4, 3, 16),
            Block.box(12, 0, 15, 15, 3, 16),
            Block.box(13, 1, 1, 14, 2, 15),
            Block.box(2, 1, 1, 3, 2, 15),
            Block.box(0, 2, 1, 16, 3, 15),
            Block.box(15, 3, 1, 16, 8, 15),
            Block.box(0, 3, 1, 1, 8, 15),
            Block.box(1, 3, 14, 15, 8, 15),
            Block.box(1, 3, 1, 15, 8, 2)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    public static final VoxelShape SHAPE_O = Stream.of(
            Block.box(1, 0, 15, 4, 3, 16),
            Block.box(12, 0, 15, 15, 3, 16),
            Block.box(12, 0, 0, 15, 3, 1),
            Block.box(1, 0, 0, 4, 3, 1),
            Block.box(2, 1, 1, 3, 2, 15),
            Block.box(13, 1, 1, 14, 2, 15),
            Block.box(0, 2, 1, 16, 3, 15),
            Block.box(0, 3, 1, 1, 8, 15),
            Block.box(15, 3, 1, 16, 8, 15),
            Block.box(1, 3, 1, 15, 8, 2),
            Block.box(1, 3, 14, 15, 8, 15)
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

    public Cart() {
        super(AbstractBlock.Properties.of(Material.STONE));

        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
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
