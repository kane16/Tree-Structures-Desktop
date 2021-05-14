package common.view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import binarytree.model.BinaryTree
import binarytree.model.Node
import common.model.Tree
import org.jetbrains.skija.TextLine
import org.jetbrains.skija.Typeface
import java.awt.Font

@Composable
fun createTree(tree: MutableState<BinaryTree>) {
    Text("Current tree: ${tree.value}")
    Canvas(modifier = Modifier.fillMaxSize()){
        drawLine(Color.Black, Offset(size.width / 2, 200f), Offset(size.width / 2 - 300f, 300f))
        drawCircle(
            Color.White,
            center = Offset(size.width / 2, 200f),
            radius = 40f
        )
        drawCircle(
            Color.White,
            center = Offset(size.width / 2 - 300f, 300f),
            radius = 40f
        )
        val paint = Paint().asFrameworkPaint()
        paint.apply {
            isAntiAlias = true
        }

        drawIntoCanvas {
            it.nativeCanvas.drawTextLine(TextLine.make("22", org.jetbrains.skija.Font(Typeface.makeDefault(), 40f)), size.width / 2 - 20f, 200f + 12f, paint)
            it.nativeCanvas.drawTextLine(TextLine.make("1", org.jetbrains.skija.Font(Typeface.makeDefault(), 40f)), size.width / 2 - 310f, 300f + 12f, paint)
        }
    }
}