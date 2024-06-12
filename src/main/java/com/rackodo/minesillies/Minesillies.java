package com.rackodo.minesillies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class Minesillies implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("minesillies");

	public static final Item ITEM_SHUGAT = new Item(new Item.Settings());
	public static final Item ITEM_MIDLEY = new Item(new Item.Settings());
	public static final Item ITEM_BLEEP = new Item(new Item.Settings());
	public static final Item ITEM_BOBBY = new Item(new Item.Settings());
	public static final Item ITEM_CONN = new Item(new Item.Settings());

	private static final ItemGroup ITEM_GROUP_SILLIES = FabricItemGroup.builder()
	.icon(() -> new ItemStack(ITEM_SHUGAT))
	.displayName(Text.translatable("itemGroup.minesillies.sillies"))
	.entries((context, entries) -> {
		entries.add(ITEM_SHUGAT);
		entries.add(ITEM_MIDLEY);
		entries.add(ITEM_BLEEP);
		entries.add(ITEM_BOBBY);
		entries.add(ITEM_CONN);
	})
	.build();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");

		Registry.register(Registries.ITEM, new Identifier("minesillies", "shugat"), ITEM_SHUGAT);
		Registry.register(Registries.ITEM, new Identifier("minesillies", "midley"), ITEM_MIDLEY);
		Registry.register(Registries.ITEM, new Identifier("minesillies", "bleep"), ITEM_BLEEP);
		Registry.register(Registries.ITEM, new Identifier("minesillies", "bobby"), ITEM_BOBBY);
		Registry.register(Registries.ITEM, new Identifier("minesillies", "conn"), ITEM_CONN);

		Registry.register(Registries.ITEM_GROUP, new Identifier("minesillies", "sillies"), ITEM_GROUP_SILLIES);
	}
}