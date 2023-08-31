package uz.ruzibekov.planzen.ui.screens.label.create

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.ruzibekov.planzen.R
import uz.ruzibekov.planzen.ui.data.model.TagEntity
import javax.inject.Inject

@HiltViewModel
class CreateLabelViewModel @Inject constructor() : ViewModel() {

    fun create(){
        val color = Color(0xFFF44336)

        val tagEntity = TagEntity(
            icon = R.drawable.ic_tag,
            name = "Tag test",
            argb = color.toArgb()
        )
    }
}