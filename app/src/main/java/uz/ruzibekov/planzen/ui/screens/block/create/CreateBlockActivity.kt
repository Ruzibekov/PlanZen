package uz.ruzibekov.planzen.ui.screens.block.create

import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import dagger.hilt.android.AndroidEntryPoint
import uz.ruzibekov.planzen.ui.screens.base.BaseActivity

@AndroidEntryPoint
class CreateBlockActivity : BaseActivity() {

    private val viewModel: CreateBlockViewModel by viewModels()

    override val content: @Composable () -> Unit = {

        Text(
            text = "Hello world",
        )
    }

    override fun initialize() {
        viewModel.create()
    }

}