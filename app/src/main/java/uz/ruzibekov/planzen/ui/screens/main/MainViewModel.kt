package uz.ruzibekov.planzen.ui.screens.main

import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.ruzibekov.planzen.R
import uz.ruzibekov.planzen.data.model.TagEntity
import uz.ruzibekov.planzen.data.room.dao.BlockDao
import uz.ruzibekov.planzen.data.room.dao.TagDao
import uz.ruzibekov.planzen.ui.screens.main.state.MainState
import uz.ruzibekov.planzen.ui.theme.AppColor
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val blockDao: BlockDao,
    private val tagDao: TagDao,
) : ViewModel() {

    val state = MainState()

    private val scope = CoroutineScope(Dispatchers.IO)

    fun fetch() = scope.launch {

        state.blocks.clear()
        state.blocks.addAll(blockDao.getList())

        if (tagDao.getList().isEmpty())
            createDefaultTags()

        val tags = tagDao.getList()
        state.tags.clear()
        state.tags.addAll(tags)
    }

    private suspend fun createDefaultTags() {
        tagDao.insert(

            TagEntity(
                icon = R.drawable.ic_car,
                name = "В пути",
                argb = AppColor.Orange.toArgb()
            ),

            TagEntity(
                icon = R.drawable.ic_eat,
                name = "Еда",
                argb = AppColor.DarkOrange.toArgb()
            ),

            TagEntity(
                icon = R.drawable.ic_laptop,
                name = "Интернет",
                argb = AppColor.Orange.toArgb()
            ),

            TagEntity(
                icon = R.drawable.ic_love,
                name = "Личное",
                argb = AppColor.Red.toArgb()
            ),
            TagEntity(
                icon = R.drawable.ic_education,
                name = "Обучение",
                argb = AppColor.Primary.toArgb()
            ),
            TagEntity(
                icon = R.drawable.ic_coffee,
                name = "Перерыв",
                argb = AppColor.Broken.toArgb()
            ),
            TagEntity(
                icon = R.drawable.ic_work,
                name = "Работа",
                argb = AppColor.Purple.toArgb()
            ),
            TagEntity(
                icon = R.drawable.ic_sleep,
                name = "Сон",
                argb = AppColor.Blue.toArgb()
            ),
            TagEntity(
                icon = R.drawable.ic_tv,
                name = "TV",
                argb = AppColor.Orange.toArgb()
            ),
            TagEntity(
                icon = R.drawable.ic_workout,
                name = "Тренировка",
                argb = AppColor.Green.toArgb()
            ),
            TagEntity(
                icon = R.drawable.ic_book,
                name = "Четение",
                argb = AppColor.Primary.toArgb()
            )
        )
    }
}