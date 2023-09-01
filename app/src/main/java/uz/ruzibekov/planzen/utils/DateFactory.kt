package uz.ruzibekov.planzen.utils

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimePickerState
import java.text.SimpleDateFormat
import java.util.Calendar

object DateFactory {

    @SuppressLint("SimpleDateFormat")
    fun getFormattedTime(timeInMillis: Long): String {

        val calendar = Calendar.getInstance().apply {
            setTimeInMillis(timeInMillis)
        }

        val timeFormat = SimpleDateFormat("HH:mm")
        return timeFormat.format(calendar.time)
    }

    @OptIn(ExperimentalMaterial3Api::class)
    fun getTimeInMillis(state: TimePickerState): Long {

        val calendar = Calendar.getInstance().apply {

            set(
                Calendar.HOUR_OF_DAY,
                state.hour,
            )

            set(
                Calendar.MINUTE,
                state.minute,
            )
        }

        return calendar.timeInMillis
    }
}