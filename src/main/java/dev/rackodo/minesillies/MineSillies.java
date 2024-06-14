package dev.rackodo.minesillies;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.AbstractBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
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

	public static final Block SILLY_CONTAINER = new SillyContainer(Block.Settings.create().strength((4.0f)));
	public static final BlockEntityType<SillyContainerEntity> SILLY_CONTAINER_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier("minesillies", "silly_container_entity"), BlockEntityType.Builder.create(SillyContainerEntity::new, SILLY_CONTAINER).build());

	public static final Block SILLY_DIRECTIONAL_BLOCK = new SillyDirectionalBlock(AbstractBlock.Settings.create().strength((4.0f)));

	private static final ItemGroup SILLY_GROUP = FabricItemGroup.builder()
			.icon(() -> new ItemStack(SILLY_BLOCK))
			.displayName(Text.translatable("itemGroup.minesillies.silly_group"))
			.entries((context, entries) -> {
				entries.add(SILLY_BLOCK);
				entries.add(SILLY_CONTAINER);
				entries.add(SILLY_NUMBER_HOLDER);
				entries.add(SILLY_DIRECTIONAL_BLOCK);
			})
			.build();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		Registry.register(Registries.BLOCK, new Identifier("minesillies", "silly_block"), SILLY_BLOCK);
		Registry.register(Registries.ITEM, new Identifier("minesillies", "silly_block"), new BlockItem(SILLY_BLOCK, new Item.Settings()));

		Registry.register(Registries.BLOCK, new Identifier("minesillies", "silly_container"), SILLY_CONTAINER);
		Registry.register(Registries.ITEM, new Identifier("minesillies", "silly_container"), new BlockItem(SILLY_CONTAINER, new Item.Settings()));

		Registry.register(Registries.BLOCK, new Identifier("minesillies", "silly_number_holder"), SILLY_NUMBER_HOLDER);
		Registry.register(Registries.ITEM, new Identifier("minesillies", "silly_number_holder"), new BlockItem(SILLY_NUMBER_HOLDER, new Item.Settings()));

		Registry.register(Registries.BLOCK, new Identifier("minesillies", "silly_directional_block"), SILLY_DIRECTIONAL_BLOCK);
		Registry.register(Registries.ITEM, new Identifier("minesillies", "silly_directional_block"), new BlockItem(SILLY_DIRECTIONAL_BLOCK, new Item.Settings()));

		Registry.register(Registries.ITEM_GROUP, new Identifier("minesillies", "silly_group"), SILLY_GROUP);

		LOGGER.info("Hello Fabric world!");
	}
}