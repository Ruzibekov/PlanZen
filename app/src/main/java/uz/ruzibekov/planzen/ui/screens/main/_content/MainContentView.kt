package uz.ruzibekov.planzen.ui.screens.main._content

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uz.ruzibekov.planzen.ui.screens.main.BottomNavItem
import uz.ruzibekov.planzen.ui.screens.main._components.MainBottomNavigationView
import uz.ruzibekov.planzen.ui.screens.main._fragments.ScheduleFragmentView
import uz.ruzibekov.planzen.ui.screens.main._fragments.TagsFragmentView

object MainContentView {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Default(navController: NavHostController) {

        Scaffold(
            bottomBar = {
                MainBottomNavigationView.Default(
                    navController = navController
                )
            }
        ) { paddingValues ->

            NavHost(
                modifier = Modifier.padding(paddingValues),
                navController = navController,
                startDestination = BottomNavItem.Schedule.screen_route
            ) {

                composable(BottomNavItem.Schedule.screen_route) {
                    ScheduleFragmentView.Default()
                }

                composable(BottomNavItem.Tags.screen_route) {
                    TagsFragmentView.Default()
                }
            }
        }
    }
}