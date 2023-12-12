package com.example.blocks

import net.minecraft.block.BlockState
import net.minecraft.block.BlockWithEntity
import net.minecraft.block.entity.BlockEntity
import net.minecraft.util.math.BlockPos

class NodeStone(settings: Settings) : BlockWithEntity(settings) {
    override fun createBlockEntity(pos: BlockPos?, state: BlockState?): BlockEntity {
        return NodeStoneEntity(pos, state)
    }

}

class NodeStoneEntity(pos: BlockPos?, state: BlockState?) : BlockEntity(ModBlocks.NODE_STONE_ENTITY, pos, state) {

}