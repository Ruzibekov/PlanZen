package uz.ruzibekov.planzen.ui.screens.main._fragments.schedule._content

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import uz.ruzibekov.planzen.ui.screens.main._fragments.schedule._components.ScheduleActionButton
import uz.ruzibekov.planzen.ui.screens.main._fragments.schedule._components.ScheduleEmptyView
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

            if (state.blocks.isNotEmpty())

                LazyColumn(modifier = Modifier.padding(paddingValues)) {
                    items(state.blocks) { block ->
                        ScheduleItemView.Default(entity = block)
                    }
                }

            else
                ScheduleEmptyView.Default()
        }
    }
}