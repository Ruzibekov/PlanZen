package uz.ruzibekov.planzen.ui.screens.tag.create._content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.ruzibekov.planzen.R
import uz.ruzibekov.planzen.ui.screens.tag.create._components.CreateTagNameView
import uz.ruzibekov.planzen.ui.screens.tag.create._components.CreateTagTopBarView
import uz.ruzibekov.planzen.ui.screens.tag.create.listeners.CreateTagListeners
import uz.ruzibekov.planzen.ui.screens.tag.create.state.CreateTagState
import uz.ruzibekov.planzen.ui.theme.AppColor

object CreateTagContentView {

    @Composable
    fun Default(state: CreateTagState, listeners: CreateTagListeners) {

        Scaffold(
            topBar = {
                CreateTagTopBarView.Default(listeners = listeners)
            }
        ) { paddingValues ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(20.dp)
            ) {

                CreateTagNameView.Default(state = state)

                Spacer(modifier = Modifier.height(20.dp))

                Row {

                    Item(
                        icon = R.drawable.ic_palette,
                        containerColor = AppColor.Black
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    Item(
                        icon = R.drawable.ic_palette,
                        containerColor = AppColor.Black
                    )
                }
            }
        }
    }

    @Composable
    private fun Item(icon: Int, containerColor: Color) {
        Surface(
            shape = CircleShape,
            color = containerColor
        ) {

            Icon(
                painter = painterResource(id = icon),
                contentDescription = "icon",
                modifier = Modifier
                    .padding(20.dp)
                    .size(24.dp),
                tint = AppColor.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    val state = CreateTagState()
    val listeners = object : CreateTagListeners {
        override fun createNewTag() {}
    }
    CreateTagContentView.Default(state = state, listeners = listeners)
}