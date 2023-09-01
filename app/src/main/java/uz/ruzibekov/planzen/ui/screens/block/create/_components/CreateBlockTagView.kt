package uz.ruzibekov.planzen.ui.screens.block.create._components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import uz.ruzibekov.planzen.R
import uz.ruzibekov.planzen.ui.screens.block.create.listeners.CreateBlockListeners
import uz.ruzibekov.planzen.ui.screens.block.create.state.CreateBlockState
import uz.ruzibekov.planzen.ui.theme.AppColor

object CreateBlockTagView {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Default(
        state: CreateBlockState,
        listeners: CreateBlockListeners
    ) {

        val tag = state.selectedTag.value

        Surface(
            onClick = { listeners.showTagsDialogView() },
            shape = RoundedCornerShape(100.dp),
            border = BorderStroke(width = 1.dp, color = if (tag == null) AppColor.Gray else Color.Transparent),
            color = if (tag == null) Color.Transparent else Color(tag.argb)
        ) {

            Row(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    painter = painterResource(id = tag?.icon ?: R.drawable.ic_add),
                    contentDescription = "add icon",
                    tint = if (tag == null) AppColor.Black else AppColor.White
                )

                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    text = tag?.name ?: stringResource(R.string.start),
                    color = if (tag == null) AppColor.Black else AppColor.White
                )
            }
        }
    }
}