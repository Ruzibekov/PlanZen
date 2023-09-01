package uz.ruzibekov.planzen.ui.screens.block.create

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.ruzibekov.planzen.data.model.BlockEntity
import uz.ruzibekov.planzen.data.room.dao.BlockDao
import uz.ruzibekov.planzen.data.room.dao.TagDao
import uz.ruzibekov.planzen.ui.screens.block.create.state.CreateBlockState
import uz.ruzibekov.planzen.utils.DateFactory
import javax.inject.Inject

@HiltViewModel
class CreateBlockViewModel @Inject constructor(
    private val blockDao: BlockDao,
    private val tagDao: TagDao
) : ViewModel() {

    @OptIn(ExperimentalMaterial3Api::class)
    val state = CreateBlockState()

    private val scope = CoroutineScope(Dispatchers.IO)

    fun fetch() = scope.launch {
        state.tags.clear()
        state.tags.addAll(tagDao.getList())
    }

    @OptIn(ExperimentalMaterial3Api::class)
    fun createNewBlock(onSuccess: () -> Unit) = scope.launch {
        if (state.selectedTag.value != null && state.startTimePickerState.value != null && state.endTimePickerState.value != null) {

            val startTime = DateFactory.getTimeInMillis(state.startTimePickerState.value!!)
            val endTime = DateFactory.getTimeInMillis(state.endTimePickerState.value!!)

            val entity = BlockEntity(
                tag = state.selectedTag.value!!,
                startTimeInMillis = startTime,
                endTimeInMillis = endTime,
                description = state.description.value
            )

            blockDao.insert(entity)

            onSuccess()
        }
    }
}