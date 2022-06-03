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
public class StatueNoodle extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public static final VoxelShape SHAPE_N = Stream.of(
            Block.box(3.999999999999999, 23.5, 3.9999999999999982, 12, 31.5, 12),
            Block.box(3.999999999999999, 11.5, 5.999999999999998, 12, 23.5, 10),
            Block.box(12, 11.5, 5.999999999999998, 15, 23.5, 10),
            Block.box(0.9999999999999991, 11.5, 5.999999999999998, 3.999999999999999, 23.5, 10),
            Block.box(3.999999999999999, -0.5, 5.999999999999998, 8, 11.5, 10),
            Block.box(8, -0.5, 5.999999999999998, 12, 11.5, 10),
            Block.box(3.499999999999999, 23, 3.4999999999999982, 12.5, 32, 12.5),
            Block.box(3.999999999999999, 11.02, 5.49, 12, 24.03, 10.490000000000002),
            Block.box(11.5, 11, 5.499999999999998, 15.5, 24, 10.5),
            Block.box(0.4999999999999991, 11, 5.499999999999998, 4.499999999999999, 24, 10.5),
            Block.box(7.499999999999999, -1, 5.499999999999998, 12.5, 12, 10.5),
            Block.box(3.499999999999999, -1, 5.499999999999998, 8.5, 12, 10.5)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    public static final VoxelShape SHAPE_S = Stream.of(
            Block.box(3.999999999999999, 23.5, 3.998333333333333, 12, 31.5, 11.998333333333335),
            Block.box(3.999999999999999, 11.5, 5.998333333333333, 12, 23.5, 9.998333333333335),
            Block.box(0.9999999999999991, 11.5, 5.998333333333333, 3.999999999999999, 23.5, 9.998333333333335),
            Block.box(12, 11.5, 5.998333333333333, 15, 23.5, 9.998333333333335),
            Block.box(8, -0.5, 5.998333333333333, 12, 11.5, 9.998333333333335),
            Block.box(3.999999999999999, -0.5, 5.998333333333333, 8, 11.5, 9.998333333333335),
            Block.box(3.499999999999999, 23, 3.498333333333333, 12.5, 32, 12.498333333333335),
            Block.box(3.999999999999999, 11.02, 5.508333333333331, 12, 24.03, 10.508333333333333),
            Block.box(0.4999999999999991, 11, 5.498333333333333, 4.499999999999999, 24, 10.498333333333335),
            Block.box(11.5, 11, 5.498333333333333, 15.5, 24, 10.498333333333335),
            Block.box(3.499999999999999, -1, 5.498333333333333, 8.5, 12, 10.498333333333335),
            Block.box(7.499999999999999, -1, 5.498333333333333, 12.5, 12, 10.498333333333335)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    public static final VoxelShape SHAPE_E = Stream.of(
            Block.box(3.9991666666666665, 23.5, 3.9991666666666656, 11.999166666666667, 31.5, 11.999166666666667),
            Block.box(5.9991666666666665, 11.5, 3.9991666666666656, 9.999166666666667, 23.5, 11.999166666666667),
            Block.box(5.9991666666666665, 11.5, 11.999166666666667, 9.999166666666667, 23.5, 14.999166666666667),
            Block.box(5.9991666666666665, 11.5, 0.9991666666666656, 9.999166666666667, 23.5, 3.9991666666666656),
            Block.box(5.9991666666666665, -0.5, 3.9991666666666656, 9.999166666666667, 11.5, 7.9991666666666665),
            Block.box(5.9991666666666665, -0.5, 7.9991666666666665, 9.999166666666667, 11.5, 11.999166666666667),
            Block.box(3.4991666666666665, 23, 3.4991666666666656, 12.499166666666667, 32, 12.499166666666667),
            Block.box(5.5091666666666645, 11.02, 3.9991666666666656, 10.509166666666665, 24.03, 11.999166666666667),
            Block.box(5.4991666666666665, 11, 11.499166666666667, 10.499166666666667, 24, 15.499166666666667),
            Block.box(5.4991666666666665, 11, 0.49916666666666565, 10.499166666666667, 24, 4.499166666666666),
            Block.box(5.4991666666666665, -1, 7.499166666666666, 10.499166666666667, 12, 12.499166666666667),
            Block.box(5.4991666666666665, -1, 3.4991666666666656, 10.499166666666667, 12, 8.499166666666667)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    public static final VoxelShape SHAPE_O = Stream.of(
            Block.box(4.000833333333332, 23.5, 3.9991666666666656, 12.000833333333333, 31.5, 11.999166666666667),
            Block.box(6.000833333333332, 11.5, 3.9991666666666656, 10.000833333333333, 23.5, 11.999166666666667),
            Block.box(6.000833333333332, 11.5, 0.9991666666666656, 10.000833333333333, 23.5, 3.9991666666666656),
            Block.box(6.000833333333332, 11.5, 11.999166666666667, 10.000833333333333, 23.5, 14.999166666666667),
            Block.box(6.000833333333332, -0.5, 7.9991666666666665, 10.000833333333333, 11.5, 11.999166666666667),
            Block.box(6.000833333333332, -0.5, 3.9991666666666656, 10.000833333333333, 11.5, 7.9991666666666665),
            Block.box(3.5008333333333317, 23, 3.4991666666666656, 12.500833333333333, 32, 12.499166666666667),
            Block.box(5.490833333333334, 11.02, 3.9991666666666656, 10.490833333333335, 24.03, 11.999166666666667),
            Block.box(5.500833333333332, 11, 0.49916666666666565, 10.500833333333333, 24, 4.499166666666666),
            Block.box(5.500833333333332, 11, 11.499166666666667, 10.500833333333333, 24, 15.499166666666667),
            Block.box(5.500833333333332, -1, 3.4991666666666656, 10.500833333333333, 12, 8.499166666666667),
            Block.box(5.500833333333332, -1, 7.499166666666666, 10.500833333333333, 12, 12.499166666666667)
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

    public StatueNoodle() {
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
