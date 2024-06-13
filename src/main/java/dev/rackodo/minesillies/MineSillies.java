package dev.rackodo.minesillies;

import net.fabricmc.api.ModInitializer;

import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.minecraft.block.Block;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class MineSillies implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("minesillies");

	public static final Block SILLY_BLOCK = new SillyBlock(Block.Settings.create().strength((4.0f)));

	public static final Block SILLY_CONTAINER = new SillyContainer(Block.Settings.create().strength((4.0f)));
	public static final BlockEntityType<SillyContainerEntity> SILLY_CONTAINER_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier("minesillies", "silly_container_entity"), BlockEntityType.Builder.create(SillyContainerEntity::new, SILLY_CONTAINER).build());
	
	public static final ChestBlock SILLY_CHEST = new ChestBlock(Settings.create(), Supplier<new BlockEntityType<? extends ChestBlockEntity>> entityTSupplier);
	public static final BlockEntityType<SillyChestEntity> SILLY_CHEST_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier("minesillies", "silly_chest_entity"), BlockEntityType.Builder.create(SillyChestEntity::new, SILLY_CHEST).build());


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		Registry.register(Registries.BLOCK, new Identifier("minesillies", "silly_block"), SILLY_BLOCK);
		Registry.register(Registries.ITEM, new Identifier("minesillies", "silly_block"), new BlockItem(SILLY_BLOCK, new Item.Settings()));

		Registry.register(Registries.BLOCK, new Identifier("minesillies", "silly_container"), SILLY_CONTAINER);
		Registry.register(Registries.ITEM, new Identifier("minesillies", "silly_container"), new BlockItem(SILLY_CONTAINER, new Item.Settings()));

		Registry.register(Registries.BLOCK, new Identifier("minesillies", "silly_chest"), SILLY_CHEST);
		Registry.register(Registries.ITEM, new Identifier("minesillies", "silly_chest"), new BlockItem(SILLY_CHEST, new Item.Settings()));

		LOGGER.info("Hello Fabric world!");
	}
}