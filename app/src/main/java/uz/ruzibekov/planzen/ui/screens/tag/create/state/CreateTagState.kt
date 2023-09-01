package uz.ruzibekov.planzen.ui.screens.tag.create.state

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class CreateTagState(
    val name: MutableState<String> = mutableStateOf("")
)
