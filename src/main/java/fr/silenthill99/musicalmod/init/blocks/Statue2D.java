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
public class Statue2D extends Block {
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
            Block.box(4, 23.5, 4, 12, 31.5, 12),
            Block.box(4, 11.5, 6, 12, 23.5, 10),
            Block.box(0, 11.5, 6, 4, 23.5, 10),
            Block.box(12, 11.5, 6, 16, 23.5, 10),
            Block.box(4, -0.5, 6, 8, 11.5, 10),
            Block.box(8, -0.5, 6, 12, 11.5, 10),
            Block.box(3.5, 23, 3.5, 12.5, 32, 12.5),
            Block.box(4, 11.02, 5.5, 12, 24.03, 10.5),
            Block.box(-0.48999999999999844, 11, 5.5, 4.5, 24, 10.5),
            Block.box(11.5, 11, 5.5, 16.5, 24, 10.5),
            Block.box(3.5, -1, 5.5, 8.5, 12, 10.5),
            Block.box(7.5, -1, 5.5, 12.5, 12, 10.5)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    public static final VoxelShape SHAPE_E = Stream.of(
            Block.box(4, 23.5, 4, 12, 31.5, 12),
            Block.box(6, 11.5, 4, 10, 23.5, 12),
            Block.box(6, 11.5, 12, 10, 23.5, 16),
            Block.box(6, 11.5, 0, 10, 23.5, 4),
            Block.box(6, -0.5, 8, 10, 11.5, 12),
            Block.box(6, -0.5, 4, 10, 11.5, 8),
            Block.box(3.5, 23, 3.5, 12.5, 32, 12.5),
            Block.box(5.5, 11.02, 4, 10.5, 24.03, 12),
            Block.box(5.5, 11, 11.5, 10.5, 24, 16.49),
            Block.box(5.5, 11, -0.5, 10.5, 24, 4.5),
            Block.box(5.5, -1, 7.5, 10.5, 12, 12.5),
            Block.box(5.5, -1, 3.5, 10.5, 12, 8.5)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    public static final VoxelShape SHAPE_O = Stream.of(
            Block.box(4, 23.5, 4, 12, 31.5, 12),
            Block.box(6, 11.5, 4, 10, 23.5, 12),
            Block.box(6, 11.5, 0, 10, 23.5, 4),
            Block.box(6, 11.5, 12, 10, 23.5, 16),
            Block.box(6, -0.5, 4, 10, 11.5, 8),
            Block.box(6, -0.5, 8, 10, 11.5, 12),
            Block.box(3.5, 23, 3.5, 12.5, 32, 12.5),
            Block.box(5.5, 11.02, 4, 10.5, 24.03, 12),
            Block.box(5.5, 11, -0.48999999999999844, 10.5, 24, 4.5),
            Block.box(5.5, 11, 11.5, 10.5, 24, 16.5),
            Block.box(5.5, -1, 3.5, 10.5, 12, 8.5),
            Block.box(5.5, -1, 7.5, 10.5, 12, 12.5)
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
    public Statue2D() {
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
