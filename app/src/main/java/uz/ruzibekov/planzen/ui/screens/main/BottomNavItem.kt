package uz.ruzibekov.planzen.ui.screens.main

import uz.ruzibekov.planzen.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){

    object Schedule : BottomNavItem("Расписание", R.drawable.ic_schedule,"schedule-screen")
    object Tags: BottomNavItem("Метки", R.drawable.ic_tag,"tags-screen")
}