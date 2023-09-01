package uz.ruzibekov.planzen.ui.screens.block.create._components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import uz.ruzibekov.planzen.ui.theme.AppColor

object CreateBlockTimeView {

    @Composable
    fun Default(titleRes: Int) {

        Column {

            Text(text = stringResource(titleRes))

            Spacer(modifier = Modifier.height(5.dp))

            Surface(
                modifier = Modifier
                    .width(100.dp)
                    .height(50.dp),
                border = BorderStroke(width = 1.dp, color = AppColor.Gray),
                shape = RoundedCornerShape(8.dp)
            ) {

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    
                    Text(text = "00:00")
                }
            }
        }
    }
}