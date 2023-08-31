package uz.ruzibekov.planzen.ui.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import uz.ruzibekov.planzen.ui.data.model.BlockEntity

@Dao
interface BlockDao {

    @Insert
    fun insert(entity: BlockEntity)
}