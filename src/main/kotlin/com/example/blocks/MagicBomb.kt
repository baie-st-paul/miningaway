package com.example.blocks

import com.example.Betterthaumcraft
import com.example.status.CursedStatusEffect
import jdk.jshell.Snippet.Status
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffectUtil
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.text.Text
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import java.util.logging.Logger
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Effect

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
            cursePlayerInZone(world, pos, 100.0)

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

    private fun cursePlayerInZone(world: World, pos: BlockPos, range: Double) {
        val player = world.getClosestPlayer(pos.x.toDouble(), pos.y.toDouble(), pos.z.toDouble(), range, false)

        if (player != null) {

            player.addStatusEffect(StatusEffectInstance(Betterthaumcraft.cursedStatusEffect, 1000, 1))
            println("got here")
        }

    }
}