package uz.ruzibekov.planzen.ui.screens.tag.create._components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import uz.ruzibekov.planzen.data.MainData
import uz.ruzibekov.planzen.ui.screens.tag.create.state.CreateTagState

object CreateTagIconsDialog {

    @Composable
    fun Default(state: CreateTagState) {

        AlertDialog(
            onDismissRequest = { state.showIconsDialog.value = false },
            confirmButton = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            text = {

                LazyVerticalGrid(
                    columns = GridCells.Adaptive(60.dp),
                    modifier = Modifier.fillMaxSize()
                ) {

                    items(MainData.icons) { icon ->

                        IconButton(
                            onClick = {
                                state.icon.value = icon
                                state.showIconsDialog.value = false
                            },
                            modifier = Modifier.padding(5.dp)
                        ) {

                            Icon(
                                painter = painterResource(id = icon),
                                modifier = Modifier.size(48.dp),
                                contentDescription = "icon",
                            )
                        }
                    }
                }
            }
        )
    }
}