package uz.ruzibekov.planzen.ui.screens.main._fragments.schedule._components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import uz.ruzibekov.planzen.R

object ScheduleEmptyView {

    @Composable
    fun Default() {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Image(
                    painter = painterResource(id = R.drawable.ic_empty_schedule),
                    contentDescription = "Schedule is empty icon",
                    modifier = Modifier.size(96.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(text = stringResource(id = R.string.schedule_is_empty))
            }
        }
    }
}