package uz.ruzibekov.planzen.ui.screens.main._fragments.schedule

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uz.ruzibekov.planzen.ui.screens.main._fragments.schedule._components.ScheduleActionButton
import uz.ruzibekov.planzen.ui.screens.main._fragments.schedule._components.ScheduleItemView
import uz.ruzibekov.planzen.ui.screens.main._fragments.schedule._components.ScheduleTopBarView
import uz.ruzibekov.planzen.ui.screens.main.listeners.MainListeners

object ScheduleFragmentView {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Default(listeners: MainListeners) {

        Scaffold(
            topBar = {
                ScheduleTopBarView.Default()
            },

            floatingActionButton = {
                ScheduleActionButton.Default(listeners)
            }

        ) { paddingValues ->

            LazyColumn(modifier = Modifier.padding(paddingValues)) {

                items(15) {

                    ScheduleItemView.Default()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {

    val listeners = object : MainListeners{
        override fun openCreateBlockScreen() {}
    }

    ScheduleFragmentView.Default(listeners)
}