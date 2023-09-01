package uz.ruzibekov.planzen.ui.screens.block.create

import android.content.Intent
import androidx.activity.viewModels
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimePickerState
import androidx.compose.runtime.Composable
import dagger.hilt.android.AndroidEntryPoint
import uz.ruzibekov.planzen.ui.screens.base.BaseActivity
import uz.ruzibekov.planzen.ui.screens.block.create._components.CreateBlockTagsDialogView
import uz.ruzibekov.planzen.ui.screens.block.create._components.CreateBlockTimePickerView
import uz.ruzibekov.planzen.ui.screens.block.create._content.CreateBlockContentView
import uz.ruzibekov.planzen.ui.screens.block.create.listeners.CreateBlockListeners
import uz.ruzibekov.planzen.ui.screens.tag.create.CreateTagActivity
import java.util.Calendar

@AndroidEntryPoint
class CreateBlockActivity : BaseActivity(), CreateBlockListeners {

    private val viewModel: CreateBlockViewModel by viewModels()

    @OptIn(ExperimentalMaterial3Api::class)
    override val content: @Composable () -> Unit = {

        CreateBlockContentView.Default(
            state = viewModel.state,
            listeners = this
        )

        when {
            viewModel.state.showTagsDialog.value ->
                CreateBlockTagsDialogView.Default(state = viewModel.state, listeners = this)

            viewModel.state.showStartTimePickerDialog.value ->
                CreateBlockTimePickerView.Default(
                    state = viewModel.state.startTimePickerState
                ) {
                    hideStartTimePickerDialog()
                }

            viewModel.state.showEndTimePickerDialog.value ->
                CreateBlockTimePickerView.Default(
                    state = viewModel.state.endTimePickerState
                ) {
                    hideEndTimePickerDialog()
                }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    override fun initialize() {
        val calendar = Calendar.getInstance()

        viewModel.state.startTimePickerState.value = TimePickerState(
            initialHour = calendar[Calendar.HOUR_OF_DAY],
            initialMinute = calendar[Calendar.MINUTE],
            is24Hour = true
        )

        viewModel.state.endTimePickerState.value = TimePickerState(
            initialHour = calendar[Calendar.HOUR_OF_DAY] + 1,
            initialMinute = calendar[Calendar.MINUTE],
            is24Hour = true
        )
    }

    override fun onStart() {
        super.onStart()
        viewModel.fetch()
    }

    override fun createNewBlock() {
        viewModel.createNewBlock {
            finish()
        }
    }

    override fun showTagsDialogView() {
        viewModel.state.showTagsDialog.value = true
    }

    override fun openCreateNewTagScreen() {
        val intent = Intent(this, CreateTagActivity::class.java)
        startActivity(intent)
    }

    override fun showStartTimePickerDialog() {
        viewModel.state.showStartTimePickerDialog.value = true
    }

    override fun showEndTimePickerDialog() {
        viewModel.state.showEndTimePickerDialog.value = true
    }

    override fun hideStartTimePickerDialog() {
        viewModel.state.showStartTimePickerDialog.value = false
    }

    override fun hideEndTimePickerDialog() {
        viewModel.state.showEndTimePickerDialog.value = false
    }

    override fun onBackStack() {
        finish()
    }

}