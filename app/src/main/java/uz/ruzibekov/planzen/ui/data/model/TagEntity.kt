package uz.ruzibekov.planzen.ui.data.model

import androidx.compose.ui.graphics.Color
import androidx.room.PrimaryKey

data class TagEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val icon: Int,
    val name: String,
    val color: Color
)