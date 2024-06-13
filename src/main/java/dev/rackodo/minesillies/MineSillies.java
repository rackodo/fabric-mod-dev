package dev.rackodo.minesillies;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
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

	public static final Block SILLY_NUMBER_HOLDER = new SillyNumberHolder(Block.Settings.create().strength((4.0f)));
	public static final BlockEntityType<SillyNumberHolderEntity> SILLY_NUMBER_HOLDER_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier("minesillies", "silly_number_holder_entity"), BlockEntityType.Builder.create(SillyNumberHolderEntity::new, SILLY_NUMBER_HOLDER).build());

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		Registry.register(Registries.BLOCK, new Identifier("minesillies", "silly_block"), SILLY_BLOCK);
		Registry.register(Registries.ITEM, new Identifier("minesillies", "silly_block"), new BlockItem(SILLY_BLOCK, new Item.Settings()));

		Registry.register(Registries.BLOCK, new Identifier("minesillies", "silly_number_holder"), SILLY_NUMBER_HOLDER);
		Registry.register(Registries.ITEM, new Identifier("minesillies", "silly_number_holder"), new BlockItem(SILLY_NUMBER_HOLDER, new Item.Settings()));

		LOGGER.info("Hello Fabric world!");
	}
}