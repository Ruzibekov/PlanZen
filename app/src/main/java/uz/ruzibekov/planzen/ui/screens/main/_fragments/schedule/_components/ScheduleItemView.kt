package uz.ruzibekov.planzen.ui.screens.main._fragments.schedule._components

import androidx.compose.foundation.BorderStroke
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
import uz.ruzibekov.planzen.ui.theme.AppColor

object ScheduleItemView {

    @Composable
    fun Default(entity: BlockEntity, /*tag: TagEntity*/) {

        Surface(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(bottom = 8.dp),
            border = BorderStroke(1.dp, AppColor.Gray),
            shape = RoundedCornerShape(8.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {

//                TagView.Default(tag){}

                Spacer(modifier = Modifier.height(5.dp))

                Text(text = entity.description)

                Text(text = "1 hours")
            }
        }
    }
}