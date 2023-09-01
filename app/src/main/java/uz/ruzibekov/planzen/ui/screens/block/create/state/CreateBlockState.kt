package uz.ruzibekov.planzen.ui.screens.block.create.state

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimePickerState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import uz.ruzibekov.planzen.data.model.TagEntity

data class CreateBlockState @OptIn(ExperimentalMaterial3Api::class) constructor(
    val showTagsDialog: MutableState<Boolean> = mutableStateOf(false),
    val showTimePickerDialog: MutableState<Boolean> = mutableStateOf(false),

    val selectedTag: MutableState<TagEntity?> = mutableStateOf(null),
    val startTimePickerState: MutableState<TimePickerState?> = mutableStateOf(null),
    val endTimePickerState: MutableState<TimePickerState?> = mutableStateOf(null),
    val description: MutableState<String> = mutableStateOf(""),

    val tags: SnapshotStateList<TagEntity> = mutableStateListOf(),
)