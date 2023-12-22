package com.example.items

import com.example.Betterthaumcraft
import com.example.util.isNodeStoneInThere
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.text.Text
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World
import net.minecraft.item.ItemStack

class MagicOMeter(settings: FabricItemSettings) : Item(settings){

    override fun use(world: World, player: PlayerEntity, hand: Hand): TypedActionResult<ItemStack> {
        player.sendMessage(Text.of("Nodes detecteds:"
                + isNodeStoneInThere(player.world, player.blockPos, 5).toString()), false)
        return TypedActionResult.success(ItemStack(Betterthaumcraft.magicOMeter, 1))
    }


}