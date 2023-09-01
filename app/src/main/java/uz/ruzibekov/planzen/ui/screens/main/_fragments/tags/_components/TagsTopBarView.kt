package uz.ruzibekov.planzen.ui.screens.main._fragments.tags._components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import uz.ruzibekov.planzen.R

object TagsTopBarView {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Default() {

        TopAppBar(
            title = {
                Text(text = stringResource(id = R.string.tags))
            }
        )
    }
}