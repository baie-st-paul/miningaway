package com.example.blocks

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.entity.FabricBlockEntityTypeBuilder
import net.minecraft.block.Block
import net.minecraft.block.Material
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemGroups
import net.minecraft.registry.*
import net.minecraft.util.Identifier

class ModBlocks {

    companion object {

        private val MAGIC_BOMB_BLOCK = Registry.register(
            Registries.BLOCK,
            Identifier(
                "betterthaumcraft",
                "magic_bomb"
            ),
            MagicBomb(FabricBlockSettings.of(Material.METAL).strength(4f)))
        val MAGIC_BOMB_ITEM: BlockItem = Registry.register(
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
        private val MAGICRAFTER = Magicrafter(FabricBlockSettings.of(Material.WOOD).strength(2f).nonOpaque())
        private val NODE_STONE = NodeStone(FabricBlockSettings.of(Material.METAL).strength(3f).nonOpaque())
        val NODE_STONE_ENTITY: BlockEntityType<NodeStoneEntity> = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier("betterthaumcraft", "node_stone"),
            FabricBlockEntityTypeBuilder
                .create(::NodeStoneEntity, NODE_STONE)
                .build()
        )
        val MAGICRAFTER_ENTITY: BlockEntityType<MagicrafterEntity> = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier("betterthaumcraft", "magicrafter"),
            FabricBlockEntityTypeBuilder.create(::MagicrafterEntity, MAGICRAFTER)
                .build()
        )

        fun registerAllBlocks() {
//            registerBlock("magic_bomb", MAGIC_BOMB_BLOCK, ItemGroups.COMBAT)
            registerBlock("magicrafter", MAGICRAFTER, ItemGroups.FUNCTIONAL)
            registerBlock("node_stone", NODE_STONE, ItemGroups.BUILDING_BLOCKS)
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register { content ->
                    content.add(MAGIC_BOMB_ITEM)
                }

        }

        private fun registerBlock(name: String, block: Block, group: ItemGroup): Block {
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

        private fun registerBlockItem(name: String, block: Block, group: ItemGroup): Item {
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
                .register { content ->
                    content.add(item)
                }
            return item

        }

    }

}