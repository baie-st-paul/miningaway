package com.example

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.*
import net.minecraft.item.BlockItem
import net.minecraft.registry.*
import net.minecraft.util.Identifier
import org.slf4j.LoggerFactory

object Betterthaumcraft : ModInitializer {
    private val logger = LoggerFactory.getLogger("betterthaumcraft")

	val exemple : Block = Block(FabricBlockSettings.of(Material.METAL).strength(4.0f))

	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		logger.info("Hello Fabric world!")
		Registry.register(Registries.BLOCK, Identifier("betterthaumcraft", "example_block"), exemple)
		Registry.register(Registries.ITEM, Identifier("betterthaumcraft", "example_block"), BlockItem(exemple, FabricItemSettings()))
	}

}

