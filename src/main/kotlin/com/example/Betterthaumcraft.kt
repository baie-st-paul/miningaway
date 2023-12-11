package com.example

import com.example.blocks.MagicBomb
import com.example.blocks.ModBlocks
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.*
import net.minecraft.item.BlockItem
import net.minecraft.item.ItemGroups
import net.minecraft.registry.*
import net.minecraft.util.Identifier
import org.slf4j.LoggerFactory


object Betterthaumcraft : ModInitializer {
    private val logger = LoggerFactory.getLogger("betterthaumcraft")

	//private val exemple : ExBlock = ExBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f))

	private val MAGIC_BOMB_BLOCK : MagicBomb = MagicBomb(FabricBlockSettings.of(Material.METAL).strength(4f))
	//val MAGICRAFTER = Block(FabricBlockSettings.of(Material.WOOD).strength(2f))


	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		logger.info("Hello Fabric world!")
//		ModBlocks.registerAllBlocks()

		/*
		Registry.register(
				Registries.BLOCK,
				Identifier(
						"betterthaumcraft",
						"example_block"
				),
				exemple,
		)
		Registry.register(
				Registries.ITEM,
				Identifier(
						"betterthaumcraft",
						"example_block"
				),
				BlockItem(
						exemple,
						FabricItemSettings()
				),
		)

*/
		Registry.register(
			Registries.BLOCK,
			Identifier(
				"betterthaumcraft",
				"magic_bomb"
			),
			MAGIC_BOMB_BLOCK,
		)

		val item = Registry.register(
			Registries.ITEM,
			Identifier(
				"betterthaumcraft",
				"magic_bomb"
			),
			BlockItem(
				MAGIC_BOMB_BLOCK,
				FabricItemSettings()
			),
		)
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
			.register { content -> content.add(item) }

	}

}

