package com.example.ibarsgenshinfood.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Cart : Screen("cart")
    object Profile : Screen("profile")
    object DetailMenu : Screen("home/{menuId}") {
        fun createRoute(menuId: Int) = "home/$menuId"
    }
}