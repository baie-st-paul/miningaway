package com.example

import com.example.blocks.ModBlocks
import com.example.items.MagicOMeter
import com.example.status.CursedStatusEffect
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.registry.*
import net.minecraft.util.Identifier
import org.slf4j.LoggerFactory


object Betterthaumcraft : ModInitializer {
    private val logger = LoggerFactory.getLogger("betterthaumcraft")
	val magicOMeter: MagicOMeter = MagicOMeter(FabricItemSettings())
	val cursedStatusEffect: CursedStatusEffect = CursedStatusEffect()

	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		logger.info("Hello Fabric world!")
		ModBlocks.registerAllBlocks()
		Registry.register(
			Registries.ITEM,
			Identifier(
				"betterthaumcraft",
				"magic_meter"
			),
			magicOMeter
		)

		Registry.register(
			Registries.STATUS_EFFECT,
			Identifier(
				"betterthaumcraft",
				"cursed_effect"
			),
			cursedStatusEffect
		)
	}
}

