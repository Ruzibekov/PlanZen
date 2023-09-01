package uz.ruzibekov.planzen.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import uz.ruzibekov.planzen.data.model.BlockEntity

@Dao
interface BlockDao {

    @Insert
    fun insert(entity: BlockEntity)

    @Query("SELECT * FROM blocks")
    fun getList(): List<BlockEntity>
}