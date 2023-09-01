package uz.ruzibekov.planzen.ui.screens.main._fragments.schedule

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uz.ruzibekov.planzen.ui.screens.main._fragments.schedule._components.ScheduleActionButton
import uz.ruzibekov.planzen.ui.screens.main._fragments.schedule._components.ScheduleItemView
import uz.ruzibekov.planzen.ui.screens.main._fragments.schedule._components.ScheduleTopBarView
import uz.ruzibekov.planzen.ui.screens.main.listeners.MainListeners
import uz.ruzibekov.planzen.ui.screens.main.state.MainState

object ScheduleFragmentView {

    @Composable
    fun Default(state: MainState, listeners: MainListeners) {

        Scaffold(
            topBar = {
                ScheduleTopBarView.Default()
            },

            floatingActionButton = {
                ScheduleActionButton.Default(listeners)
            }

        ) { paddingValues ->

            LazyColumn(modifier = Modifier.padding(paddingValues)) {

                items(state.blocks) { block ->

                    ScheduleItemView.Default(
                        entity = block,
//                        tag = state.tags.first { it.id == block.tagId }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {

    val state = MainState()

    val listeners = object : MainListeners {
        override fun openCreateBlockScreen() {}
    }

    ScheduleFragmentView.Default(state, listeners)
}