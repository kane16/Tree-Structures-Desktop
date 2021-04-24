import androidx.compose.desktop.Window
import androidx.compose.material.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntSize
import common.view.showView

fun main() = Window(title = "Tree structures", IntSize(1024, 768)) {

    val backgroundDark = Color(0xFF2B2B2B)
    val backgroundMedium = Color(0xFF3C3F41)
    val backgroundLight = Color(0xFF4E5254)

    val material: Colors = darkColors(
        background = backgroundDark,
        surface = backgroundMedium,
        primary = Color.White
    )

    MaterialTheme(
        colors = material
    ) {
        Surface {
            showView()
        }
    }


}
