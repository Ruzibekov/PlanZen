package uz.ruzibekov.planzen.ui.data.room.converters

import android.graphics.Color
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.graphics.toColor
import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun fromArgb(value: Int): Color {
        return value.toColor()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun colorToArgb(color: Color): Int {
        return color.toArgb()
    }

}