package uz.ruzibekov.planzen.ui.data.model

import androidx.room.PrimaryKey

data class BlockEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val tag: TagEntity,
    val startTimeInMillis: Long,
    val endTimeInMillis: Long,
    val description: String
)
