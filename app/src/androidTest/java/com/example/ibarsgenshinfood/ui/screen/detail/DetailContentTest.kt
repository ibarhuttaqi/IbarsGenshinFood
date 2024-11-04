package com.example.ibarsgenshinfood.ui.screen.detail

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.printToLog
import com.example.ibarsgenshinfood.R
import com.example.ibarsgenshinfood.model.Menu
import com.example.ibarsgenshinfood.model.OrderMenu
import com.example.ibarsgenshinfood.onNodeWithStringId
import com.example.ibarsgenshinfood.ui.theme.IbarsGenshinFoodTheme
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DetailContentTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private val fakeOrderMenu = OrderMenu(
        menu = Menu(4, "Baklava", 7500, "A complex, famous type of Liyue cuisine. This dish is a rare and exquisite mix of both land and sea, combining countless delicious delicacies in one flavor-filled pot. Each mouthful is a moment to remember — it's even irresistible enough to entice the adepti down from their celestial abode.", "Increases all party members' ATK by 372 and CRIT Rate by 12% for 300s.", R.drawable.icon_3_stars, R.drawable.item_delicious_baklava),
        count = 0
    )

    @Before
    fun setUp() {
        composeTestRule.setContent {
            IbarsGenshinFoodTheme {
                DetailContent(
                    fakeOrderMenu.menu.image,
                    fakeOrderMenu.menu.name,
                    fakeOrderMenu.menu.price,
                    fakeOrderMenu.count,
                    fakeOrderMenu.menu.description,
                    fakeOrderMenu.menu.effect,
                    fakeOrderMenu.menu.quality,
                    onBackClick = {},
                    onAddToCart = {}
                )
            }
        }
        composeTestRule.onRoot().printToLog("currentLabelExists")
    }

    @Test
    fun detailContent_isDisplayed() {
        composeTestRule.onNodeWithText(fakeOrderMenu.menu.name).assertIsDisplayed()
        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(
                R.string.price,
                fakeOrderMenu.menu.price
            )
        ).assertIsDisplayed()
    }

    @Test
    fun increaseProduct_buttonEnabled() {
        composeTestRule.onNodeWithContentDescription("Order Button").assertIsNotEnabled()
//        composeTestRule.onNodeWithText(composeTestRule.activity.getString(R.string.plus_symbol))
//            .performClick()
        composeTestRule.onNodeWithStringId(R.string.plus_symbol).performClick()
        composeTestRule.onNodeWithContentDescription("Order Button").assertIsEnabled()
    }

    @Test
    fun increaseProduct_correctCounter() {
        composeTestRule.onNodeWithStringId(R.string.plus_symbol).performClick().performClick()
        // cara ini bisa akan tetapi jika error tidak akan menampilkan data saat ini yang muncul di layar
//        composeTestRule.onNodeWithText("2").assertIsDisplayed()
        // cara ini lebih baik dgn menambahkan modifier testTag pada text yang bersangkutan, karena menyimpan value text saat ini, jika gagal maka kita mengetahui valuenya berapa utk mempermudah perbaikan testing kedepannya
        composeTestRule.onNodeWithTag("count").assert(hasText("2"))
    }

    @Test
    fun decreaseProduct_stillZero() {
        composeTestRule.onNodeWithStringId(R.string.minus_symbol).performClick()
        composeTestRule.onNodeWithTag("count").assert(hasText("0"))
    }
}