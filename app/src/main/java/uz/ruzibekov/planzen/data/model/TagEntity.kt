package uz.ruzibekov.planzen.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tags")
data class TagEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val icon: Int,
    val name: String,
    val argb: Int
)