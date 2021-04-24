import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import model.TreeType

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

@Composable
fun showView() {
    var isStartView by remember { mutableStateOf(true) }
    var chosenTree by remember { mutableStateOf("") }
    if (isStartView) {
        Column(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TreeType.values().forEach {
                Button(
                    onClick = { isStartView = false; chosenTree = it.fullname },
                    Modifier.width(300.dp).padding(20.dp)
                )
                { Text(it.fullname) }
            }
        }
    } else {
        Column(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Changed: $chosenTree")
        }
    }
}
