package com.example.blocks

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.text.Text
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class MagicBomb(settings: FabricBlockSettings) : Block(settings)  {

    override fun onUse(
        state: BlockState,
        world: World,
        pos: BlockPos,
        player: PlayerEntity,
        hand: Hand,
        hit: BlockHitResult
    ): ActionResult {
        if (!world.isClient) {
            player.sendMessage(Text.of("Bye Bye"), false)
            world.createExplosion(
                null,
                pos.x.toDouble(),
                pos.y.toDouble(),
                pos.z.toDouble(),
                100f,
                true,
                World.ExplosionSourceType.BLOCK
            )
        }
        return ActionResult.SUCCESS
    }
}