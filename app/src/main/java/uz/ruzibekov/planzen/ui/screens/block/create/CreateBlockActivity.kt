package uz.ruzibekov.planzen.ui.screens.block.create

import android.content.Intent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import dagger.hilt.android.AndroidEntryPoint
import uz.ruzibekov.planzen.ui.screens.base.BaseActivity
import uz.ruzibekov.planzen.ui.screens.block.create._components.CreateBlockTagsDialogView
import uz.ruzibekov.planzen.ui.screens.block.create._content.CreateBlockContentView
import uz.ruzibekov.planzen.ui.screens.block.create.listeners.CreateBlockListeners
import uz.ruzibekov.planzen.ui.screens.tag.create.CreateTagActivity

@AndroidEntryPoint
class CreateBlockActivity : BaseActivity(), CreateBlockListeners {

    private val viewModel: CreateBlockViewModel by viewModels()

    override val content: @Composable () -> Unit = {

        CreateBlockContentView.Default(
            state = viewModel.state,
            listeners = this
        )

        when {

            viewModel.state.showTagsDialog.value -> {
                CreateBlockTagsDialogView.Default(
                    state = viewModel.state,
                    listeners = this
                )
            }
        }
    }

    override fun initialize() {
        viewModel.create()
    }

    override fun createNewBlock() {
//        TODO("Not yet implemented")
    }

    override fun showTagsDialogView() {
        viewModel.state.showTagsDialog.value = true
    }

    override fun openCreateNewTagScreen() {
        val intent = Intent(this, CreateTagActivity::class.java)
        startActivity(intent)
    }

}