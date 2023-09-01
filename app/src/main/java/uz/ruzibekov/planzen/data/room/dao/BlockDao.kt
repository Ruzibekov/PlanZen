package uz.ruzibekov.planzen.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import uz.ruzibekov.planzen.data.model.BlockEntity

@Dao
interface BlockDao {

    @Insert
    suspend fun insert(entity: BlockEntity)

    @Query("SELECT * FROM blocks")
    suspend fun getList(): List<BlockEntity>
}