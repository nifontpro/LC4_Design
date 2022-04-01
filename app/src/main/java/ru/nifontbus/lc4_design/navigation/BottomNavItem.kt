package ru.nifontbus.lc4_design.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.EditCalendar
import androidx.compose.material.icons.outlined.FactCheck
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector,
) {

    object EventItem : BottomNavItem(
        name = "Home",
        route = Route.HOME,
        icon = Icons.Outlined.Home
    )

    object ClassesItem : BottomNavItem(
        name = "Classes",
        route = Route.CLASSES,
        icon = Icons.Outlined.EditCalendar,
    )

    object GroupItem : BottomNavItem(
        name = "Groups",
        route = Route.GROUP,
        icon = Icons.Outlined.FactCheck,
    )

    object StarItem : BottomNavItem(
        name = "Star",
        route = Route.STAR,
        icon = Icons.Outlined.StarBorder,
    )
}
