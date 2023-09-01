package uz.ruzibekov.planzen.ui.screens.block.create._components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TimePicker
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uz.ruzibekov.planzen.ui.screens.block.create.listeners.CreateBlockListeners
import uz.ruzibekov.planzen.ui.screens.block.create.state.CreateBlockState

object CreateBlockTimePickerView {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Default(state: CreateBlockState, listeners: CreateBlockListeners) {
        state.startTimePickerState.value?.let { timePickerState ->

            AlertDialog(
                onDismissRequest = { state.showTimePickerDialog.value = false },
                confirmButton = {
                    Surface(
                        shape = RoundedCornerShape(100.dp),
                        onClick = {
                            listeners.hideTimePickerDialog()
                        }
                    ) {
                        
                        Text(
                            text = "Ok",
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                        )
                    }
                },
                text = {
                    TimePicker(state = timePickerState)
                }
            )
        }
    }
}