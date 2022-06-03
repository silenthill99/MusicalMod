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

@SuppressWarnings("ALL")
public class StatueRussel extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final VoxelShape SHAPE_N = Stream.of(
            Block.box(4, 23.5, 4, 12, 31.5, 12),
            Block.box(4, 11.5, 6, 12, 23.5, 10),
            Block.box(12, 11.5, 6, 16, 23.5, 10),
            Block.box(0, 11.5, 6, 4, 23.5, 10),
            Block.box(8, -0.5, 6, 12, 11.5, 10),
            Block.box(4, -0.5, 6, 8, 11.5, 10),
            Block.box(3.5, 23, 3.5, 12.5, 32, 12.5),
            Block.box(4, 11.02, 5.5, 12, 24.03, 10.5),
            Block.box(11.5, 11, 5.5, 16.49, 24, 10.5),
            Block.box(-0.5, 11, 5.5, 4.5, 24, 10.5),
            Block.box(7.5, -1, 5.5, 12.5, 12, 10.5),
            Block.box(3.5, -1, 5.5, 8.5, 12, 10.5)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    public static final VoxelShape SHAPE_S = Stream.of(
            Block.box(3.9991666666666674, 23.5, 4, 11.999166666666667, 31.5, 12),
            Block.box(3.9991666666666674, 11.5, 6, 11.999166666666667, 23.5, 10),
            Block.box(-0.0008333333333325754, 11.5, 6, 3.9991666666666674, 23.5, 10),
            Block.box(11.999166666666667, 11.5, 6, 15.999166666666667, 23.5, 10),
            Block.box(3.9991666666666674, -0.5, 6, 7.999166666666667, 11.5, 10),
            Block.box(7.999166666666667, -0.5, 6, 11.999166666666667, 11.5, 10),
            Block.box(3.4991666666666674, 23, 3.5, 12.499166666666667, 32, 12.5),
            Block.box(3.9991666666666674, 11.02, 5.5, 11.999166666666667, 24.03, 10.5),
            Block.box(-0.490833333333331, 11, 5.5, 4.499166666666667, 24, 10.5),
            Block.box(11.499166666666667, 11, 5.5, 16.499166666666667, 24, 10.5),
            Block.box(3.4991666666666674, -1, 5.5, 8.499166666666667, 12, 10.5),
            Block.box(7.499166666666667, -1, 5.5, 12.499166666666667, 12, 10.5)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    public static final VoxelShape SHAPE_E = Stream.of(
            Block.box(3.9995833333333337, 23.5, 4.000416666666666, 11.999583333333334, 31.5, 12.000416666666666),
            Block.box(5.999583333333334, 11.5, 4.000416666666666, 9.999583333333334, 23.5, 12.000416666666666),
            Block.box(5.999583333333334, 11.5, 12.000416666666666, 9.999583333333334, 23.5, 16.000416666666666),
            Block.box(5.999583333333334, 11.5, 0.0004166666666662877, 9.999583333333334, 23.5, 4.000416666666666),
            Block.box(5.999583333333334, -0.5, 8.000416666666666, 9.999583333333334, 11.5, 12.000416666666666),
            Block.box(5.999583333333334, -0.5, 4.000416666666666, 9.999583333333334, 11.5, 8.000416666666666),
            Block.box(3.4995833333333337, 23, 3.5004166666666663, 12.499583333333334, 32, 12.500416666666666),
            Block.box(5.499583333333334, 11.02, 4.000416666666666, 10.499583333333334, 24.03, 12.000416666666666),
            Block.box(5.499583333333334, 11, 11.500416666666666, 10.499583333333334, 24, 16.490416666666665),
            Block.box(5.499583333333334, 11, -0.4995833333333337, 10.499583333333334, 24, 4.500416666666666),
            Block.box(5.499583333333334, -1, 7.500416666666666, 10.499583333333334, 12, 12.500416666666666),
            Block.box(5.499583333333334, -1, 3.5004166666666663, 10.499583333333334, 12, 8.500416666666666)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    public static final VoxelShape SHAPE_O = Stream.of(
            Block.box(3.9995833333333337, 23.5, 3.9995833333333337, 11.999583333333334, 31.5, 11.999583333333334),
            Block.box(5.999583333333334, 11.5, 3.9995833333333337, 9.999583333333334, 23.5, 11.999583333333334),
            Block.box(5.999583333333334, 11.5, -0.0004166666666662877, 9.999583333333334, 23.5, 3.9995833333333337),
            Block.box(5.999583333333334, 11.5, 11.999583333333334, 9.999583333333334, 23.5, 15.999583333333334),
            Block.box(5.999583333333334, -0.5, 3.9995833333333337, 9.999583333333334, 11.5, 7.999583333333334),
            Block.box(5.999583333333334, -0.5, 7.999583333333334, 9.999583333333334, 11.5, 11.999583333333334),
            Block.box(3.4995833333333337, 23, 3.4995833333333337, 12.499583333333334, 32, 12.499583333333334),
            Block.box(5.499583333333334, 11.02, 3.9995833333333337, 10.499583333333334, 24.03, 11.999583333333334),
            Block.box(5.499583333333334, 11, -0.4904166666666647, 10.499583333333334, 24, 4.499583333333334),
            Block.box(5.499583333333334, 11, 11.499583333333334, 10.499583333333334, 24, 16.499583333333334),
            Block.box(5.499583333333334, -1, 3.4995833333333337, 10.499583333333334, 12, 8.499583333333334),
            Block.box(5.499583333333334, -1, 7.499583333333334, 10.499583333333334, 12, 12.499583333333334)
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

    public StatueRussel() {
        super(AbstractBlock.Properties.of(Material.STONE));

        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));
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
