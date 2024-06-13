package dev.rackodo.minesillies;

import org.jetbrains.annotations.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;

public class SillyNumberHolderEntity extends BlockEntity {
	public int number = 7;

	public SillyNumberHolderEntity(BlockPos pos, BlockState state) {
		super(MineSillies.SILLY_NUMBER_HOLDER_ENTITY, pos, state);
	}

	// Serialise the BlockEntity
	@Override
	public void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup wrapper) {
		nbt.putInt("number", number);

		super.writeNbt(nbt, wrapper);
	}

	// Deserialise the BlockEntity
	@Override
	public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup wrapper) {
		super.readNbt(nbt, wrapper);

		number = nbt.getInt("number");
	}

	@Nullable
	@Override
	public Packet<ClientPlayPacketListener> toUpdatePacket() {
		return BlockEntityUpdateS2CPacket.create(this);
	}
	
	@Override
	public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup wrapper) {
		return createNbt(wrapper);
	}

}
