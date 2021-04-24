package common.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerMoveFilter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import common.model.TreeType

@Composable
fun showView() {
    val isStartView = remember { mutableStateOf(true) }
    val chosenTree: MutableState<TreeType?> = remember { mutableStateOf(null) }
    if (isStartView.value) {
        Column(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TreeType.values().forEach {
                customWidthButton(it.fullname, isStartView, chosenTree, it, 20.dp, 300.dp)
            }
        }
    } else {
        Column {
            customButton("Get back", isStartView, 10.dp)
        }
        Column(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Changed: ${chosenTree.value?.fullname}")
        }
    }
}

@Composable
fun customWidthButton(
    text: String,
    flagToSwitch: MutableState<Boolean>,
    chosenValue: MutableState<TreeType?>,
    treeType: TreeType,
    padding: Dp,
    width: Dp
) {
    val active = remember { mutableStateOf(false) }
    Button(
        onClick = {
            flagToSwitch.value = !flagToSwitch.value; chosenValue.value = treeType
        },
        Modifier
            .padding(padding)
            .width(width)
            .pointerMoveFilter(
                onEnter = {
                    active.value = true
                    true
                },
                onExit = {
                    active.value = false
                    true
                }
            )
    ) {
        Text(
            text,
            color = if (active.value) LocalContentColor.current.copy(alpha = 0.60f) else LocalContentColor.current
        )
    }
}

@Composable
fun customButton(text: String, flagToSwitch: MutableState<Boolean>, padding: Dp) {
    val active = remember { mutableStateOf(false) }
    Button(
        onClick = { flagToSwitch.value = !flagToSwitch.value },
        Modifier
            .padding(padding)
            .pointerMoveFilter(
                onEnter = {
                    active.value = true
                    true
                },
                onExit = {
                    active.value = false
                    true
                }
            )
    ) {
        Icon(
            Icons.Default.KeyboardArrowLeft,
            contentDescription = null,
            tint = if (active.value) LocalContentColor.current.copy(alpha = 0.60f) else LocalContentColor.current
        )
    }
}