package uz.ruzibekov.planzen.ui.screens.block.create._content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import uz.ruzibekov.planzen.R

object CreateBlockContentView {

    @Composable
    fun Default() {

        Column(
            Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {

            Row {
                Icon(
                    painter = painterResource(R.drawable.ic_close),
                    contentDescription = "Close"
                )
                
                Text(text = "")
            }
        }

    }
}