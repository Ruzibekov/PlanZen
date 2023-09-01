package uz.ruzibekov.planzen.ui.screens.block.create

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.ruzibekov.planzen.data.model.BlockEntity
import uz.ruzibekov.planzen.data.room.dao.BlockDao
import uz.ruzibekov.planzen.ui.screens.block.create.state.CreateBlockState
import javax.inject.Inject

@HiltViewModel
class CreateBlockViewModel @Inject constructor(
    private val dao: BlockDao
) : ViewModel() {

    val state = CreateBlockState()

    private val scope = CoroutineScope(Dispatchers.IO)

    fun create() = scope.launch {

        val entity = BlockEntity(
            tagId = 0,
            startTimeInMillis = 1000L,
            endTimeInMillis = 2000L,
            description = "test description"
        )

        dao.insert(entity)
    }
}