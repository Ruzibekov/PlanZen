package uz.ruzibekov.planzen.ui.screens.block.create._components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import uz.ruzibekov.planzen.R
import uz.ruzibekov.planzen.ui._components.TagView
import uz.ruzibekov.planzen.ui.screens.block.create.listeners.CreateBlockListeners
import uz.ruzibekov.planzen.ui.screens.block.create.state.CreateBlockState

object CreateBlockTagsDialogView {

    @Composable
    fun Default(
        state: CreateBlockState,
        listeners: CreateBlockListeners
    ) {

        AlertDialog(
            onDismissRequest = { state.showTagsDialog.value = false },
            confirmButton = {

                Surface(
                    onClick = {
                        listeners.openCreateNewTagScreen()
                        state.showTagsDialog.value = false
                    },
                    shape = RoundedCornerShape(100.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.new_tag),
                        modifier = Modifier.padding(5.dp),
                    )
                }
            },
            modifier = Modifier.height(400.dp),
            title = {
                Text(text = stringResource(id = R.string.tags))
            },
            text = {
                LazyColumn(modifier = Modifier.fillMaxSize()) {

                    items(state.tags) { tag ->

                        TagView.Default(tag) {
                            state.selectedTag.value = it
                            state.showTagsDialog.value = false
                        }

                        Spacer(modifier = Modifier.height(5.dp))
                    }
                }
            }
        )
    }
}