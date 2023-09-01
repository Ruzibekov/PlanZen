package uz.ruzibekov.planzen.ui.screens.main

import android.content.Intent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import uz.ruzibekov.planzen.ui.screens.base.BaseActivity
import uz.ruzibekov.planzen.ui.screens.block.create.CreateBlockActivity
import uz.ruzibekov.planzen.ui.screens.main._content.MainContentView
import uz.ruzibekov.planzen.ui.screens.main.listeners.MainListeners
import uz.ruzibekov.planzen.ui.screens.tag.create.CreateTagActivity

@AndroidEntryPoint
class MainActivity : BaseActivity(), MainListeners {

    private val viewModel: MainViewModel by viewModels()

    override val content: @Composable () -> Unit = {
        val navController = rememberNavController()

        MainContentView.Default(
            navController = navController,
            state = viewModel.state,
            listeners = this
        )
    }

    override fun initialize() {}

    override fun onStart() {
        super.onStart()
        viewModel.fetch()
    }

    override fun openCreateBlockScreen() {
        val intent = Intent(this, CreateBlockActivity::class.java)
        startActivity(intent)
    }

    override fun openCreateTagScreen() {
        val intent = Intent(this, CreateTagActivity::class.java)
        startActivity(intent)
    }
}