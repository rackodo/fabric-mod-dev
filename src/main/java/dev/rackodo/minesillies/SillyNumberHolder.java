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

public class SillyNumberHolder extends Block implements BlockEntityProvider {
	public SillyNumberHolder(Settings settings) {
		super(settings);
	}

	@Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new SillyNumberHolderEntity(pos, state);
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
		if (!world.isClient) {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof SillyNumberHolderEntity) {
				SillyNumberHolderEntity sillyNumberHolderEntity = (SillyNumberHolderEntity) blockEntity;
				sillyNumberHolderEntity.number++;
				player.sendMessage(Text.literal("Number is " + sillyNumberHolderEntity.number), false);

				return ActionResult.SUCCESS;
			}
		}

		return ActionResult.PASS;
	}
}
