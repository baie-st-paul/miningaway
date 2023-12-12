package com.example

import com.example.blocks.MagicBomb
import com.example.blocks.ModBlocks
import com.example.items.MagicOMeter
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.*
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.registry.*
import net.minecraft.util.Identifier
import org.slf4j.LoggerFactory


object Betterthaumcraft : ModInitializer {
    private val logger = LoggerFactory.getLogger("betterthaumcraft")

	private val magicBomb: MagicBomb = MagicBomb(FabricBlockSettings.of(Material.METAL).strength(4.0f))
	private val magicOMeter: MagicOMeter = MagicOMeter(FabricItemSettings())

	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		logger.info("Hello Fabric world!")
		Registry.register(
			Registries.BLOCK,
			Identifier(
				"betterthaumcraft",
				"magic_bomb"
			),
			magicBomb,
		)
		Registry.register(
			Registries.ITEM,
			Identifier(
				"betterthaumcraft",
				"magic_bomb"
			),
			BlockItem(
				magicBomb,
				FabricItemSettings()
			),
		)
		Registry.register(
			Registries.ITEM,
			Identifier(
				"betterthaumcraft",
				"magic_meter"
			),
			magicOMeter
		)
	}
}

