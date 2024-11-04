package com.example.ibarsgenshinfood

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollToIndex
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.ibarsgenshinfood.model.MenuDataSource
import com.example.ibarsgenshinfood.ui.navigation.Screen
import com.example.ibarsgenshinfood.ui.theme.IbarsGenshinFoodTheme
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class IbarsGenshinFoodAppTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private lateinit var navController: TestNavHostController

    @Before
    fun setUp() {
        composeTestRule.setContent {
            IbarsGenshinFoodTheme {
                navController = TestNavHostController(LocalContext.current)
                navController.navigatorProvider.addNavigator(ComposeNavigator())
                IbarsGenshinFoodApp(navController = navController)
            }
        }
    }

    @Test
    fun navHost_verifyStartDestination() {
        // tanpa menggunakan file ScreenAssertion
//        val currentRoute = navController.currentBackStackEntry?.destination?.route
//        assertEquals(Screen.Home.route, currentRoute)

        // menggunakan file ScreenAssertion
        navController.assertCurrentRouteName(Screen.Home.route)
    }

    @Test
    fun navHost_clickItem_navigatesToDetailWithData() {
        composeTestRule.onNodeWithTag("MenuList").performScrollToIndex(10)
        composeTestRule.onNodeWithText(MenuDataSource.dummyMenus[10].name).performClick()
        navController.assertCurrentRouteName(Screen.DetailMenu.route)
        composeTestRule.onNodeWithText(MenuDataSource.dummyMenus[10].name).assertIsDisplayed()
    }

    @Test
    fun navHost_bottomNavigation_working() {
        composeTestRule.onNodeWithStringId(R.string.menu_cart).performClick()
        navController.assertCurrentRouteName(Screen.Cart.route)
        composeTestRule.onNodeWithStringId(R.string.menu_profile).performClick()
        navController.assertCurrentRouteName(Screen.Profile.route)
        composeTestRule.onNodeWithStringId(R.string.menu_home).performClick()
        navController.assertCurrentRouteName(Screen.Home.route)
    }

    @Test
    fun navHost_clickItem_navigatesBack() {
        composeTestRule.onNodeWithTag("MenuList").performScrollToIndex(10)
        composeTestRule.onNodeWithText(MenuDataSource.dummyMenus[10].name).performClick()
        navController.assertCurrentRouteName(Screen.DetailMenu.route)
        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.back)).performClick()
        navController.assertCurrentRouteName(Screen.Home.route)
    }

    @Test
    fun navHost_checkout_rightBackStack() {
        composeTestRule.onNodeWithText(MenuDataSource.dummyMenus[4].name).performClick()
        navController.assertCurrentRouteName(Screen.DetailMenu.route)
        composeTestRule.onNodeWithStringId(R.string.plus_symbol).performClick()
        composeTestRule.onNodeWithContentDescription("Order Button").performClick()
        navController.assertCurrentRouteName(Screen.Cart.route)
        composeTestRule.onNodeWithStringId(R.string.menu_home).performClick()
        navController.assertCurrentRouteName(Screen.Home.route)
    }
}