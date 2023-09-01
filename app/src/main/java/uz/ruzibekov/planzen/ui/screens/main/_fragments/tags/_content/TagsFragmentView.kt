package uz.ruzibekov.planzen.ui.screens.main._fragments.tags._content

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uz.ruzibekov.planzen.ui.screens.main._fragments.tags._components.TagItemView
import uz.ruzibekov.planzen.ui.screens.main._fragments.tags._components.TagsActionButton
import uz.ruzibekov.planzen.ui.screens.main._fragments.tags._components.TagsTopBarView
import uz.ruzibekov.planzen.ui.screens.main.listeners.MainListeners
import uz.ruzibekov.planzen.ui.screens.main.state.MainState

object TagsFragmentView {

    @Composable
    fun Default(state: MainState, listeners: MainListeners) {

        Scaffold(
            topBar = {
                TagsTopBarView.Default()
            },

            floatingActionButton = {
                TagsActionButton.Default(listeners)
            }

        ) { paddingValues ->

            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(paddingValues),
                contentPadding = PaddingValues(20.dp)
            ) {

                items(state.tags) { tag ->
                    TagItemView.Default(tag) {
                        //todo click
                    }
                }
            }
        }
    }
}