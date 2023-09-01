package uz.ruzibekov.planzen.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "blocks")
data class BlockEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val tag: TagEntity,
    val startTimeInMillis: Long,
    val endTimeInMillis: Long,
    val description: String
)
