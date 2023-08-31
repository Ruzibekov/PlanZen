package uz.ruzibekov.planzen.ui.screens.block.create

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.ruzibekov.planzen.R
import uz.ruzibekov.planzen.ui.data.model.BlockEntity
import uz.ruzibekov.planzen.ui.data.model.TagEntity
import uz.ruzibekov.planzen.ui.data.room.dao.BlockDao
import javax.inject.Inject

@HiltViewModel
class CreateBlockViewModel @Inject constructor(
    val dao: BlockDao
) : ViewModel() {


    val scope = CoroutineScope(Dispatchers.IO)

    fun create() = scope.launch {

        val color = Color(0xFF000000)

        val tagEntity = TagEntity(
            icon = R.drawable.ic_tag,
            name = "Tag test",
            color = color
        )

        val entity = BlockEntity(
            tag = tagEntity,
            startTimeInMillis = 1000L,
            endTimeInMillis = 2000L,
            description = "test description"
        )

        dao.insert(entity)
    }
}