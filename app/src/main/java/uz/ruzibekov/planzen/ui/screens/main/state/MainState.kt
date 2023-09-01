package uz.ruzibekov.planzen.ui.screens.main.state

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import uz.ruzibekov.planzen.data.model.BlockEntity
import uz.ruzibekov.planzen.data.model.TagEntity

data class MainState (
    val blocks: SnapshotStateList<BlockEntity> = mutableStateListOf(),
    val tags: SnapshotStateList<TagEntity> = mutableStateListOf(),
)