package uz.ruzibekov.planzen.ui.screens.main._fragments.tags._components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.ruzibekov.planzen.data.model.TagEntity
import uz.ruzibekov.planzen.ui.theme.AppColor

object TagItemView {

    @Composable
    fun Default(tag: TagEntity, onClick: ((TagEntity) -> Unit)? = null) {

        Surface(
            modifier = Modifier.padding(bottom = 8.dp),
            shape = RoundedCornerShape(100.dp),
            color = Color(tag.argb),
            onClick = { onClick?.invoke(tag) }
        ) {

            Row(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    painter = painterResource(id = tag.icon),
                    contentDescription = "icon",
                    modifier = Modifier.size(24.dp),
                    tint = AppColor.White
                )

                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    text = tag.name,
                    color = AppColor.White,
                    fontSize = 16.sp
                )
            }
        }
    }
}