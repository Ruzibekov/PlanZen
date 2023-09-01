package uz.ruzibekov.planzen.ui.screens.block.create.state

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import uz.ruzibekov.planzen.data.model.TagEntity

data class CreateBlockState(
    val showTagsDialog: MutableState<Boolean> = mutableStateOf(false),
    val selectedTag: MutableState<TagEntity?> = mutableStateOf(null)
)