package com.example

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.text.Text
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class ExBlock(settings: Settings) : Block(settings) {

    public override fun onUse(
            state: BlockState,
            world: World,
            pos: BlockPos,
            player: PlayerEntity,
            hand: Hand,
            hit: BlockHitResult
    ): ActionResult {
        if (!world.isClient) {
            player.sendMessage(Text.of("Hello, world!"), false)
        }
        return ActionResult.SUCCESS
    }
}
