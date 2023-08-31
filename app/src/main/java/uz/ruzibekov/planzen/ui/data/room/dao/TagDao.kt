package uz.ruzibekov.planzen.ui.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import uz.ruzibekov.planzen.ui.data.model.TagEntity

@Dao
interface TagDao {

    @Insert
    fun insert(tagEntity: TagEntity)


}