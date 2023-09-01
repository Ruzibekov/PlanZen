package uz.ruzibekov.planzen.ui.screens.block.create._components

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import uz.ruzibekov.planzen.ui.screens.block.create.listeners.CreateBlockListeners
import uz.ruzibekov.planzen.ui.theme.AppColor
import java.text.SimpleDateFormat
import java.util.Calendar

object CreateBlockTimeView {

    @SuppressLint("SimpleDateFormat")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Default(
        titleRes: Int,
        timePickerState: TimePickerState,
        listeners: CreateBlockListeners
    ) {

        Column {

            Text(text = stringResource(titleRes))

            Spacer(modifier = Modifier.height(5.dp))

            Surface(
                modifier = Modifier
                    .width(100.dp)
                    .height(50.dp),
                border = BorderStroke(width = 1.dp, color = AppColor.Gray),
                shape = RoundedCornerShape(8.dp),
                onClick = { listeners.showTimePickerDialog() }
            ) {

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {

                    val timeFormat = SimpleDateFormat("HH:mm")

                    val calendar = Calendar.getInstance().apply {
                        set(Calendar.HOUR_OF_DAY, timePickerState.hour)
                        set(Calendar.MINUTE, timePickerState.minute)
                    }

                    Text(text = timeFormat.format(calendar.time))
                }
            }
        }
    }
}