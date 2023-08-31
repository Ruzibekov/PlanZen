package uz.ruzibekov.planzen.ui.screens.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import uz.ruzibekov.planzen.ui.theme.PlanZenTheme

abstract class BaseActivity : ComponentActivity() {

    abstract val content: @Composable () -> Unit

    abstract fun initialize()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlanZenTheme {
                content.invoke()
            }
        }

        initialize()
    }
}