package uz.ruzibekov.planzen.ui.screens.tag.create

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.ruzibekov.planzen.R
import uz.ruzibekov.planzen.data.model.TagEntity
import uz.ruzibekov.planzen.data.room.dao.TagDao
import uz.ruzibekov.planzen.ui.screens.tag.create.state.CreateTagState
import javax.inject.Inject

@HiltViewModel
class CreateTagViewModel @Inject constructor(
    private val dao: TagDao
) : ViewModel() {

    val state = CreateTagState()

    private val scope = CoroutineScope(Dispatchers.IO)

    fun create() = scope.launch {

        val color = Color(0xFFF44336)

        val tagEntity = TagEntity(
            icon = R.drawable.ic_tag,
            name = "Tag test",
            argb = color.toArgb()
        )

        dao.insert(tagEntity)
    }
}