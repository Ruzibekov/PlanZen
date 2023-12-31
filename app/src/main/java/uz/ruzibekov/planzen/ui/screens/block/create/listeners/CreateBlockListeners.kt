package uz.ruzibekov.planzen.ui.screens.block.create.listeners

interface CreateBlockListeners {

    fun createNewBlock()

    fun showTagsDialogView()

    fun openCreateNewTagScreen()

    fun showStartTimePickerDialog()

    fun showEndTimePickerDialog()

    fun hideStartTimePickerDialog()

    fun hideEndTimePickerDialog()

    fun onBackStack()
}