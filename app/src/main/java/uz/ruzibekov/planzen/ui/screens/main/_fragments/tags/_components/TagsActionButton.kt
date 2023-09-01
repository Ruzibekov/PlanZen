package uz.ruzibekov.planzen.ui.screens.main._fragments.tags._components

import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import uz.ruzibekov.planzen.R
import uz.ruzibekov.planzen.ui.screens.main.listeners.MainListeners

object TagsActionButton {

    @Composable
    fun Default(listeners: MainListeners) {

        FloatingActionButton(
            onClick = {
                listeners.openCreateTagScreen()
            }
        ) {

            Icon(
                painter = painterResource(id = R.drawable.ic_add),
                contentDescription = "icon add"
            )
        }
    }
}