package uz.ruzibekov.planzen.ui.screens.tag.create.state

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

data class CreateTagState(
    val name: MutableState<String> = mutableStateOf(""),
    val color: MutableState<Color?> = mutableStateOf(null),
    val icon: MutableState<Int?> = mutableStateOf(null)
) {
    val showColorsDialog: MutableState<Boolean> = mutableStateOf(false)
    val showIconsDialog: MutableState<Boolean> = mutableStateOf(false)
}
