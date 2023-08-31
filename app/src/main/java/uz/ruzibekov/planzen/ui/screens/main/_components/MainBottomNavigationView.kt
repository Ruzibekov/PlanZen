package uz.ruzibekov.planzen.ui.screens.main._components

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import uz.ruzibekov.planzen.R
import uz.ruzibekov.planzen.ui.screens.main.BottomNavItem

object MainBottomNavigationView {

    @Composable
    fun Default(navController: NavHostController) {

        val items = listOf(
            BottomNavItem.Schedule,
            BottomNavItem.Tags,
        )

        BottomAppBar(containerColor = colorResource(id = R.color.teal_200)) {

            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            items.forEach { item ->

                NavigationBarItem(
                    selected = currentRoute == item.screen_route,
                    onClick = {
                        navController.navigate(item.screen_route) {

                            navController.graph.startDestinationRoute?.let { screen_route ->
                                popUpTo(screen_route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    label = {
                        Text(
                            text = item.title,
                            fontSize = 9.sp
                        )
                    },
                    icon = {
                        Icon(
                            painterResource(id = item.icon),
                            contentDescription = item.title
                        )
                    },
                    alwaysShowLabel = true
                )
            }
        }
    }
}