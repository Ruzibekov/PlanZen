package uz.ruzibekov.planzen.ui.screens.main._fragments.schedule._components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uz.ruzibekov.planzen.data.model.BlockEntity
import uz.ruzibekov.planzen.ui._components.TagView
import uz.ruzibekov.planzen.ui.theme.AppColor
import uz.ruzibekov.planzen.utils.DateFactory

object ScheduleItemView {

    @Composable
    fun Default(entity: BlockEntity) {

        Log.i("RRR", "item = $entity")

        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(bottom = 8.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Text(text = DateFactory.getFormattedTime(entity.startTimeInMillis))

            Surface(
                modifier = Modifier.padding(start = 60.dp),
                border = BorderStroke(1.dp, AppColor.Gray),
                shape = RoundedCornerShape(8.dp)
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {

                    TagView.Default(tag = entity.tag)

                    if (entity.description.isNotBlank()) {

                        Spacer(modifier = Modifier.height(5.dp))

                        Text(text = entity.description)
                    }
                }
            }

            Text(text = DateFactory.getFormattedTime(entity.endTimeInMillis))
        }
    }
}