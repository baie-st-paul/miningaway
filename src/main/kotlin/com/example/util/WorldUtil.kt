package com.example.util

import com.example.blocks.ModBlocks
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

fun isNodeStoneInThere(world: World, pos: BlockPos, range: Int): UInt {
    val range = 5
    var count = 0u
    for (x in pos.x-range..pos.x+range) {
        for (y in pos.y-range..pos.y+range) {
            for (z in pos.z-range..pos.z+range) {
                if (world.getBlockEntity(BlockPos(x, y, z), ModBlocks.NODE_STONE_ENTITY).isPresent()) {
                    count += 1u
                }
            }
        }
    }

    return count
}