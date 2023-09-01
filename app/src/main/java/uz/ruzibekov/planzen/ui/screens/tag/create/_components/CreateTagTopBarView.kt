package uz.ruzibekov.planzen.ui.screens.tag.create._components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import uz.ruzibekov.planzen.R
import uz.ruzibekov.planzen.ui.screens.tag.create.listeners.CreateTagListeners

object CreateTagTopBarView {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Default(listeners: CreateTagListeners) {

        TopAppBar(
            title = {
                Text(text = stringResource(id = R.string.new_tag))
            },

            navigationIcon = {
                IconButton(
                    onClick = { listeners.onBackStack() }
                ) {

                    Icon(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "back icon"
                    )
                }
            },

            actions = {
                IconButton(
                    onClick = { listeners.createNewTag() }
                ) {

                    Icon(
                        painter = painterResource(id = R.drawable.ic_done),
                        contentDescription = "back icon"
                    )
                }
            }
        )
    }
}