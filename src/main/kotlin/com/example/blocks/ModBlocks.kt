package com.example.blocks

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.registry.*
import net.minecraft.util.Identifier

class ModBlocks {

    companion object {
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
            return Registry.register(
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
        }

    }

}