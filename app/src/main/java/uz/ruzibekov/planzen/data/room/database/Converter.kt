package uz.ruzibekov.planzen.data.room.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import uz.ruzibekov.planzen.data.model.TagEntity

class Converter {
    companion object {

        @TypeConverter
        @JvmStatic
        fun fromTagEntity(value: TagEntity): String {
            return Gson().toJson(value)
        }

        @TypeConverter
        @JvmStatic
        fun toBigDecimal(value: String): TagEntity {
            return Gson().fromJson(value, TagEntity::class.java)
        }
    }
}