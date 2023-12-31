package uz.ruzibekov.planzen.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import uz.ruzibekov.planzen.data.model.TagEntity

@Dao
interface TagDao {

    @Insert
    suspend fun insert(vararg tagEntity: TagEntity)

    @Query("SELECT * FROM tags")
    suspend fun getList(): List<TagEntity>

}