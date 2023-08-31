package uz.ruzibekov.planzen.ui.data.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import uz.ruzibekov.planzen.ui.data.model.BlockEntity
import uz.ruzibekov.planzen.ui.data.model.TagEntity
import uz.ruzibekov.planzen.ui.data.room.dao.BlockDao
import uz.ruzibekov.planzen.ui.data.room.dao.TagDao

@Database(entities = [BlockEntity::class, TagEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun blockDao(): BlockDao

    abstract fun tagDao(): TagDao

}