package dev.rackodo.minesillies;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class SillyContainer extends Block implements BlockEntityProvider {
	public SillyContainer(Settings settings) {
		super(settings);
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
		return VoxelShapes.cuboid(0.0625f, 0f, 0.0625f, 0.9375f, 0.875f, 0.9375f);
	}

	@Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new SillyContainerEntity(pos, state);
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
		if (!world.isClient) {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof SillyContainerEntity) {
				SillyContainerEntity sillyContainerEntity = (SillyContainerEntity) blockEntity;
				sillyContainerEntity.number++;
				player.sendMessage(Text.literal("Number is " + sillyContainerEntity.number), false);

				return ActionResult.SUCCESS;
			}
		}

		return ActionResult.PASS;
	}
}
