package uz.ruzibekov.planzen.ui.screens.block.create._content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.ruzibekov.planzen.R
import uz.ruzibekov.planzen.ui.screens.block.create._components.CreateBlockDescriptionView
import uz.ruzibekov.planzen.ui.screens.block.create._components.CreateBlockTagView
import uz.ruzibekov.planzen.ui.screens.block.create._components.CreateBlockTimeView
import uz.ruzibekov.planzen.ui.screens.block.create._components.CreateBlockTopBarView
import uz.ruzibekov.planzen.ui.screens.block.create.listeners.CreateBlockListeners
import uz.ruzibekov.planzen.ui.screens.block.create.state.CreateBlockState

object CreateBlockContentView {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Default(
        state: CreateBlockState,
        listeners: CreateBlockListeners
    ) {

        Scaffold(
            topBar = {
                CreateBlockTopBarView.Default(listeners)
            }

        ) { paddingValues ->

            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(horizontal = 20.dp)
            ) {

                CreateBlockTagView.Default(
                    state = state,
                    listeners = listeners
                )

                Spacer(modifier = Modifier.height(15.dp))

                Row {
                    CreateBlockTimeView.Default(
                        titleRes = R.string.start
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    CreateBlockTimeView.Default(
                        titleRes = R.string.start
                    )
                }

                Spacer(modifier = Modifier.height(15.dp))

                CreateBlockDescriptionView.Default()
            }
        }
    }
}

@Preview
@Composable
fun Preview() {

    val state = CreateBlockState()

    val listeners = object : CreateBlockListeners {
        override fun createNewBlock() {}
        override fun showTagsDialogView() {}
        override fun openCreateNewTagScreen() {}
    }

    CreateBlockContentView.Default(state, listeners)
}