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
import java.util.Calendar
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

    fun create() = scope.launch {

        val entity = BlockEntity(
            tagId = 0,
            startTimeInMillis = 1000L,
            endTimeInMillis = 2000L,
            description = "test description"
        )

        blockDao.insert(entity)
    }

    @OptIn(ExperimentalMaterial3Api::class)
    fun createNewBlock(onSuccess: () -> Unit) = scope.launch {
        if (state.selectedTag.value != null) {

            val startCalendar = Calendar.getInstance().apply {

                val timeState = state.startTimePickerState.value!!

                set(
                    Calendar.HOUR_OF_DAY,
                    timeState.hour,
                    timeState.minute
                )
            }

            val endCalendar = Calendar.getInstance().apply {

                val timeState = state.endTimePickerState.value!!

                set(
                    Calendar.HOUR_OF_DAY,
                    timeState.hour,
                    timeState.minute
                )
            }

            val entity = BlockEntity(
                tagId = state.selectedTag.value!!.id,
                startTimeInMillis = startCalendar.timeInMillis,
                endTimeInMillis = endCalendar.timeInMillis,
                description = state.description.value
            )

            blockDao.insert(entity)

            onSuccess()
        }
    }
}