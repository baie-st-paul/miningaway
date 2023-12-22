package com.example.blocks

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

import com.example.util.isNodeStoneInThere
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory
import net.minecraft.block.*
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityTicker
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.Inventories
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import net.minecraft.network.PacketByteBuf
import net.minecraft.screen.PropertyDelegate
import net.minecraft.screen.ScreenHandler
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.text.Text
import net.minecraft.util.collection.DefaultedList
import net.minecraft.util.shape.VoxelShape
import net.minecraft.world.BlockView

class Magicrafter(settings: Settings) : BlockWithEntity(settings), BlockEntityProvider {

    override fun onUse(
        state: BlockState?,
        world: World,
        pos: BlockPos,
        player: PlayerEntity?,
        hand: Hand?,
        hit: BlockHitResult?
    ): ActionResult {
        val numOfNodStonesAround = isNodeStoneInThere(world, pos, 5)
        val screenFactory = world.getBlockEntity(pos)
        if (!world.isClient() && numOfNodStonesAround >= 3u) {
            if (screenFactory != null && screenFactory is MagicrafterEntity) {
                player?.openHandledScreen(screenFactory)
            }
        }
        return ActionResult.SUCCESS
    }

    override fun createBlockEntity(pos: BlockPos?, state: BlockState?): BlockEntity = MagicrafterEntity(pos, state)

    override fun getRenderType(state: BlockState?): BlockRenderType {
        return BlockRenderType.MODEL
    }


}

class MagicrafterEntity(pos: BlockPos?, state: BlockState?) : BlockEntity(ModBlocks.MAGICRAFTER_ENTITY, pos, state),
    ExtendedScreenHandlerFactory, ImplementedInventory {

    var inventory = DefaultedList.ofSize(2, ItemStack.EMPTY)
    val INPUT_SLOT = 0
    val OUTPUT_SLOT = 1
    protected val propertyDelegate = PD(this)
    var progress = 0
    var maxProgress = 72

    // TODO:  maybe needed??
//    public fun MagicrafterEntity(BlockEntityType type, pos: BlockPos?, state: BlockState?) {
//        super(type, pos, state)
//    }

    override fun markDirty() {
        // TODO: do nothing??
    }

    override fun getItems(): DefaultedList<ItemStack> = inventory

    override fun createMenu(syncId: Int, playerInventory: PlayerInventory?, player: PlayerEntity?): ScreenHandler? {
        TODO("Not yet implemented")
    }

    override fun getDisplayName(): Text = Text.literal("Magicrafter")
    override fun writeScreenOpeningData(player: ServerPlayerEntity?, buf: PacketByteBuf?) {
        buf?.writeBlockPos(this.pos)
    }

    override fun writeNbt(nbt: NbtCompound?) {
        super.writeNbt(nbt)
        Inventories.writeNbt(nbt, inventory)
        nbt?.putInt("magicrafter.progress", progress)
    }

    override fun readNbt(nbt: NbtCompound?) {
        super.readNbt(nbt)
        Inventories.readNbt(nbt, inventory)
        this.progress = nbt!!.getInt("magicrafter.progress")
    }

    fun craft() {
        this.removeStack(INPUT_SLOT, 1)

        val result = ItemStack(ModBlocks.MAGIC_BOMB_ITEM)

        this.setStack(OUTPUT_SLOT, result)
    }

}

class PD(private val entity: MagicrafterEntity) : PropertyDelegate {
    override fun get(index: Int): Int {
        return when (index) {
            0 -> entity.progress
            1 -> entity.maxProgress
            else -> 0
        }
    }

    override fun set(index: Int, value: Int) {
        when (index) {
            0 -> entity.progress = value
            1 -> entity.maxProgress = value
        }
    }

    override fun size(): Int = 2

}