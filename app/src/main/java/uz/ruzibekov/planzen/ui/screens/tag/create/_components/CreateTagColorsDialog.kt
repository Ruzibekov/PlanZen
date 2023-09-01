package uz.ruzibekov.planzen.ui.screens.tag.create._components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import uz.ruzibekov.planzen.ui.screens.tag.create.state.CreateTagState
import uz.ruzibekov.planzen.ui.theme.AppColor

object CreateTagColorsDialog {

    @Composable
    fun Default(state: CreateTagState) {

        AlertDialog(
            onDismissRequest = { state.showColorsDialog.value = false },
            confirmButton = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            text = {
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(60.dp),
                    modifier = Modifier.fillMaxSize()
                ) {

                    items(AppColor.getTagColors()) { color ->

                        Box(
                            modifier = Modifier
                                .padding(4.dp)
                                .size(60.dp)
                                .clip(CircleShape)
                                .background(color)
                                .clickable {
                                    state.color.value = color
                                    state.showColorsDialog.value = false
                                }
                        )
                    }
                }
            }
        )
    }
}