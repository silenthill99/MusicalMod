package fr.silenthill99.musicalmod.init.blocks;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
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

@SuppressWarnings({"NullableProblems", "deprecation"})
public class Cart extends Block {

    public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;

    public static final VoxelShape SHAPE_N = Stream.of(
            Shapes.box(0, 0, 0.0625, 0.0625, 0.1875, 0.25),
            Shapes.box(0, 0, 0.75, 0.0625, 0.1875, 0.9375),
            Shapes.box(0.9375, 0, 0.75, 1, 0.1875, 0.9375),
            Shapes.box(0.9375, 0, 0.0625, 1, 0.1875, 0.25),
            Shapes.box(0.0625, 0.0625, 0.125, 0.9375, 0.125, 0.1875),
            Shapes.box(0.0625, 0.0625, 0.8125, 0.9375, 0.125, 0.875),
            Shapes.box(0.0625, 0.125, 0, 0.9375, 0.1875, 1),
            Shapes.box(0.0625, 0.1875, 0, 0.9375, 0.5, 0.0625),
            Shapes.box(0.0625, 0.1875, 0.9375, 0.9375, 0.5, 1),
            Shapes.box(0.875, 0.1875, 0.0625, 0.9375, 0.5, 0.9375),
            Shapes.box(0.0625, 0.1875, 0.0625, 0.125, 0.5, 0.9375)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

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
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

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
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

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


    public Cart(BlockBehaviour.Properties properties) {
        super(properties);

        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
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
