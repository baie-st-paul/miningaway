package com.example.blocks

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.AbstractBlock.Settings
import net.minecraft.block.Block
import net.minecraft.block.Material
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemGroups
import net.minecraft.registry.*
import net.minecraft.util.Identifier

class ModBlocks {

    companion object {

        val MAGIC_BOMB_BLOCK = Block(FabricBlockSettings.of(Material.METAL).strength(4f))
        val MAGICRAFTER = Block(FabricBlockSettings.of(Material.WOOD).strength(2f))

        fun registerAllBlocks() {
            registerBlock("magic_bomb", MAGIC_BOMB_BLOCK, ItemGroups.BUILDING_BLOCKS)
        }

        fun registerBlock(name: String, block: Block, group: ItemGroup): Block {
            registerBlockItem(name, block, group)
            return Registry.register(
                Registries.BLOCK,
                Identifier(
                    "betterthaumcraft",
                    name
                ),
                block,
            )
        }

        fun registerBlockItem(name: String, block: Block, group: ItemGroup): Item {
            val item = Registry.register(
                Registries.ITEM,
                Identifier(
                    "betterthaumcraft",
                    name
                ),
                BlockItem(
                    block,
                    FabricItemSettings()
                ),
            )
            ItemGroupEvents.modifyEntriesEvent(group)
                .register { content -> content.add(item) }
            return item

        }

    }

}