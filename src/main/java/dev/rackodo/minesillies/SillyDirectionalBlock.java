package dev.rackodo.minesillies;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.Direction;

public class SillyDirectionalBlock extends FacingBlock {
    public static final DirectionProperty FACING = Properties.FACING;
    public static final MapCodec<SillyDirectionalBlock> CODEC = SillyDirectionalBlock.createCodec(SillyDirectionalBlock::new);

    public MapCodec<SillyDirectionalBlock> getCodec() { return CODEC; }

    public SillyDirectionalBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected BlockState rotate(BlockState state, BlockRotation rotation) {
        return (BlockState)state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(FACING, ctx.getPlayerLookDirection().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
