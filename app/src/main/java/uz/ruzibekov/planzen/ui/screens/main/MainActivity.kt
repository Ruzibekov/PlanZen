package uz.ruzibekov.planzen.ui.screens.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import uz.ruzibekov.planzen.ui.screens.base.BaseActivity
import uz.ruzibekov.planzen.ui.screens.main._content.MainContentView
import uz.ruzibekov.planzen.ui.theme.PlanZenTheme

class MainActivity : BaseActivity() {



    override val content: @Composable () -> Unit = {

        val navController = rememberNavController()
        MainContentView.Default(navController)
    }

    override fun initialize() {}
}