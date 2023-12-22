package com.example.screen

//import net.minecraft.client.gui.screen.ingame.HandledScreen
import net.minecraft.util.Identifier
import javax.swing.Spring.height




//class MagicrafterScreen : HandledScreen<MagicrafterScreenHandler> {
//    private val TEXTURE: Identifier = Identifier("betterthaumcraft", "textures/gui/gem_polishing_station.png")
//    protected fun drawBackground(matrices: MatrixStack?, delta: Float, mouseX: Int, mouseY: Int) {
//        RenderSystem.setShader(GameRenderer::getPositionTexProgram)
//        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f)
//        RenderSystem.setShaderTexture(0, TEXTURE)
//        val x: Int = (width - backgroundWidth) / 2
//        val y: Int = (height - backgroundHeight) / 2
//        drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight)
//        //in 1.20 or above,this method is in DrawContext class.
//    }
//
//    fun render(matrices: MatrixStack?, mouseX: Int, mouseY: Int, delta: Float) {
//        renderBackground(matrices)
//        super.render(matrices, mouseX, mouseY, delta)
//        drawMouseoverTooltip(matrices, mouseX, mouseY)
//    }
//
//    protected fun init() {
//        super.init()
//        // Center the title
//        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2
//    }
//}
//
//class MagicrafterScreenHandler {
//
//}