package uz.ruzibekov.planzen.ui.screens.tag.create

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import dagger.hilt.android.AndroidEntryPoint
import uz.ruzibekov.planzen.ui.screens.base.BaseActivity
import uz.ruzibekov.planzen.ui.screens.tag.create._content.CreateTagContentView
import uz.ruzibekov.planzen.ui.screens.tag.create.listeners.CreateTagListeners

@AndroidEntryPoint
class CreateTagActivity : BaseActivity(), CreateTagListeners {

    private val viewModel: CreateTagViewModel by viewModels()

    override val content: @Composable () -> Unit = {

        CreateTagContentView.Default(
            state = viewModel.state,
            listeners = this
        )
    }

    override fun initialize() {}

    override fun createNewTag() {
//        TODO("Not yet implemented")
    }
}