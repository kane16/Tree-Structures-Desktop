package common.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerMoveFilter
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import common.model.Tree
import common.model.enums.TreeAction
import common.model.enums.TreeType

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
        Row(Modifier.fillMaxHeight().fillMaxWidth()) {
            customButton(isStartView, 10.dp)
            val isInsertEmpty = remember { mutableStateOf(true) }
            val isDeleteEmpty = remember { mutableStateOf(true) }
            val currentMode = remember { mutableStateOf(TreeAction.NONE ) }

            Column(
                modifier = Modifier.fillMaxHeight().fillMaxWidth(0.8f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Changed: ${chosenTree.value?.fullname}")
                createTree(Tree(null))
            }

            Column(
                modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End
            ) {
                Text("Insert node", Modifier.align(Alignment.CenterHorizontally))
                textInput(TreeAction.INSERT, isInsertEmpty, currentMode)
                Spacer(Modifier.padding(20.dp).height(16.dp))
                Text("Delete node", Modifier.align(Alignment.CenterHorizontally))
                textInput(TreeAction.REMOVE, isDeleteEmpty, currentMode)
                Spacer(Modifier.height(200.dp))
                customColorWidthButton("Execute", isInsertEmpty, isDeleteEmpty, 20.dp, 100.dp)
            }
        }
    }
}

@Composable
fun textInput(treeAction: TreeAction, isEmpty: MutableState<Boolean>, currentMode: MutableState<TreeAction>) {
    val text = remember { mutableStateOf("") }

    OutlinedTextField(
        value = text.value,
        onValueChange = {
            text.value = it.filter { c -> c.isDigit() }
            isEmpty.value = it.isEmpty()
            if(!it.isEmpty()) currentMode.value = treeAction else currentMode.value = TreeAction.NONE
        },
        label = { Text("Node value") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        modifier = Modifier.width(200.dp),
        enabled = treeAction == currentMode.value || currentMode.value == TreeAction.NONE
    )
}

@Composable
fun customColorWidthButton(
    text: String,
    isInsertEmpty: MutableState<Boolean>,
    isDeleteEmpty: MutableState<Boolean>,
    padding: Dp,
    width: Dp
) {
    val active = remember { mutableStateOf(false) }
    Button(
        onClick = {
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
            ),
        colors = ButtonDefaults.buttonColors(backgroundColor = if (!isInsertEmpty.value) Color.Green else if (!isDeleteEmpty.value) Color.Red else Color.White)
    ) {
        Text(
            text,
            color = if (active.value) LocalContentColor.current.copy(alpha = 0.60f) else LocalContentColor.current
        )
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
fun customButton(flagToSwitch: MutableState<Boolean>, padding: Dp) {
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