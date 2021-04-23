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

    MaterialTheme {
        showView()
    }


}

@Composable
fun showView() {
    var isStartView by remember { mutableStateOf(true) }
    if (isStartView) {
        Column(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TreeType.values().forEach {
                Button(onClick = {
                    isStartView = false
                }, Modifier.width(300.dp).padding(20.dp)) {
                    Text(it.fullname)
                }
            }
        }
    } else {
        Text("Changed")
    }
}
