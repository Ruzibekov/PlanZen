package uz.ruzibekov.planzen.ui.screens.block.create._components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import uz.ruzibekov.planzen.R
import uz.ruzibekov.planzen.ui.screens.block.create.listeners.CreateBlockListeners

object CreateBlockTopBarView {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Default(listeners: CreateBlockListeners) {

        TopAppBar(
            title = {
                Text(text = stringResource(id = R.string.new_block))
            },

            navigationIcon = {
                IconButton(
                    onClick = {
                        listeners.onBackStack()
                    }
                ) {

                    Icon(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "back icon"
                    )
                }
            },

            actions = {
                IconButton(
                    onClick = { listeners.createNewBlock() }
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