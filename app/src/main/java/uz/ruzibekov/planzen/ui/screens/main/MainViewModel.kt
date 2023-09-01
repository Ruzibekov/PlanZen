package uz.ruzibekov.planzen.ui.screens.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.ruzibekov.planzen.data.room.dao.BlockDao
import uz.ruzibekov.planzen.data.room.dao.TagDao
import uz.ruzibekov.planzen.ui.screens.main.state.MainState
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

        state.tags.clear()
        state.tags.addAll(tagDao.getList())
    }
}