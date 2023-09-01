package uz.ruzibekov.planzen.ui.screens.tag.create

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import dagger.hilt.android.AndroidEntryPoint
import uz.ruzibekov.planzen.ui.screens.base.BaseActivity
import uz.ruzibekov.planzen.ui.screens.tag.create._components.CreateTagColorsDialog
import uz.ruzibekov.planzen.ui.screens.tag.create._components.CreateTagIconsDialog
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

        when {
            viewModel.state.showColorsDialog.value ->
                CreateTagColorsDialog.Default(state = viewModel.state)

            viewModel.state.showIconsDialog.value ->
                CreateTagIconsDialog.Default(state = viewModel.state)
        }
    }

    override fun initialize() {}

    override fun showColorsDialog() {
        viewModel.state.showColorsDialog.value = true
    }

    override fun showIconsDialog() {
        viewModel.state.showIconsDialog.value = true
    }

    override fun createNewTag() {
        viewModel.create(){
            finish()
        }
    }

    override fun onBackStack() {
        finish()
    }
}