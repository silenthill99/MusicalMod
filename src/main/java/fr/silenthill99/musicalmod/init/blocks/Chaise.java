package fr.silenthill99.musicalmod.init.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.stream.Stream;

@SuppressWarnings({"NullableProblems"})
public class Chaise extends Block {

    public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final VoxelShape SHAPE_N = Stream.of(
            Block.box(0, 0, 0, 1, 15, 1),
            Block.box(15, 0, 0, 16, 15, 1),
            Block.box(15, 0, 15, 16, 15, 16),
            Block.box(0, 0, 15, 1, 15, 16),
            Block.box(0, 16, 15, 1, 32, 16),
            Block.box(15, 16, 15, 16, 32, 16),
            Block.box(0, 15, 0, 16, 16, 16),
            Block.box(1, 23, 15, 15, 32, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape SHAPE_S = Stream.of(
            Block.box(15, 0, 15, 16, 15, 16),
            Block.box(0, 0, 15, 1, 15, 16),
            Block.box(0, 0, 0, 1, 15, 1),
            Block.box(15, 0, 0, 16, 15, 1),
            Block.box(15, 16, 0, 16, 32, 1),
            Block.box(0, 16, 0, 1, 32, 1),
            Block.box(0, 15, 0, 16, 16, 16),
            Block.box(1, 23, 0, 15, 32, 1)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape SHAPE_E = Stream.of(
            Block.box(15, 0, 0, 16, 15, 1),
            Block.box(15, 0, 15, 16, 15, 16),
            Block.box(0, 0, 15, 1, 15, 16),
            Block.box(0, 0, 0, 1, 15, 1),
            Block.box(0, 16, 0, 1, 32, 1),
            Block.box(0, 16, 15, 1, 32, 16),
            Block.box(0, 15, 0, 16, 16, 16),
            Block.box(0, 23, 1, 1, 32, 15)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape SHAPE_O = Stream.of(
            Block.box(0, 0, 15, 1, 15, 16),
            Block.box(0, 0, 0, 1, 15, 1),
            Block.box(15, 0, 0, 16, 15, 1),
            Block.box(15, 0, 15, 16, 15, 16),
            Block.box(15, 16, 15, 16, 32, 16),
            Block.box(15, 16, 0, 16, 32, 1),
            Block.box(0, 15, 0, 16, 16, 16),
            Block.box(15, 23, 1, 16, 32, 15)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case EAST -> SHAPE_E;
            case SOUTH -> SHAPE_S;
            case WEST -> SHAPE_O;
            default -> SHAPE_N;
        };
    }

    public Chaise(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation direction) {
        return state.setValue(FACING, direction.rotate(state.getValue(FACING)));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
    }

}