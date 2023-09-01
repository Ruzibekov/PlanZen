package uz.ruzibekov.planzen.ui.screens.block.create._components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import uz.ruzibekov.planzen.R
import uz.ruzibekov.planzen.ui.screens.block.create.state.CreateBlockState
import uz.ruzibekov.planzen.ui.theme.AppColor

object CreateBlockDescriptionView {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Default(state: CreateBlockState) {

        Surface(
            border = BorderStroke(width = 1.dp, color = AppColor.Gray),
            shape = RoundedCornerShape(8.dp)
        ) {

            TextField(
                value = state.description.value,
                onValueChange = {
                    state.description.value = it
                },
                placeholder = {
                    Text(text = stringResource(id = R.string.description))
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = AppColor.White,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
            )
        }
    }
}