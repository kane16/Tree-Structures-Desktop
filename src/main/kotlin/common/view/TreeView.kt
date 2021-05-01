package common.view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import common.model.Tree

@Composable
fun createTree(tree: Tree) {
    Canvas(modifier = Modifier.fillMaxSize()){
        drawLine(Color.Black, Offset(size.width / 2, 200f), Offset(size.width / 2 - 40f, 230f))
        drawCircle(
            Color.White,
            center = Offset(size.width / 2, 200f),
            radius = 10f
        )
        drawCircle(
            Color.White,
            center = Offset(size.width / 2 - 40f, 230f),
            radius = 10f
        )
    }
}