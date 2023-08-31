package uz.ruzibekov.planzen.ui.screens.tag.create

import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import dagger.hilt.android.AndroidEntryPoint
import uz.ruzibekov.planzen.ui.screens.base.BaseActivity

@AndroidEntryPoint
class CreateTagActivity : BaseActivity() {

    private val viewModel: CreateTagViewModel by viewModels()

    override val content: @Composable () -> Unit = {
        Text(text = "create label")
    }

    override fun initialize() {
        viewModel.create()
    }
}