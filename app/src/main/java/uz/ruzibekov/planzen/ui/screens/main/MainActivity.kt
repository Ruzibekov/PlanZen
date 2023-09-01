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

@AndroidEntryPoint
class MainActivity : BaseActivity(), MainListeners {

    private val viewModel: MainViewModel by viewModels()

    override val content: @Composable () -> Unit = {
        val navController = rememberNavController()

        MainContentView.Default(
            navController = navController,
            listeners = this
        )
    }

    override fun initialize() {
        viewModel.fetch()
    }

    override fun openCreateBlockScreen() {
        val intent = Intent(this, CreateBlockActivity::class.java)
        startActivity(intent)
    }
}