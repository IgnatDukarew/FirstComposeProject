package com.example.firstcomposeproject

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class WaterTrackerTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private fun launch() {
        composeTestRule.setContent { WaterTracker() }
    }

    @Test
    fun addButton_existsAndIncreasesCounter() {
        launch()
        composeTestRule.onNodeWithText("0 мл").assertExists()
        composeTestRule.onNodeWithText("+250 мл")
            .assertExists()
            .assertHasClickAction()
            .performClick()
        composeTestRule.onNodeWithText("250 мл").assertExists()
        composeTestRule.onNodeWithText("+250 мл").performClick()
        composeTestRule.onNodeWithText("500 мл").assertExists()
    }

    @Test
    fun finishDayButton_existsAndResetsCounter() {
        launch()
        composeTestRule.onNodeWithText("+250 мл").performClick()
        composeTestRule.onNodeWithText("250 мл").assertExists()
        composeTestRule.onNodeWithText("Завершить день")
            .assertExists()
            .assertHasClickAction()
            .performClick()
        composeTestRule.onNodeWithText("0 мл").assertExists()
    }

    @Test
    fun streakText_isDisplayedAndUpdates() {
        launch()
        composeTestRule.onNodeWithText("Дней подряд: 0").assertExists()

        repeat(6) { composeTestRule.onNodeWithText("+250 мл").performClick() }
        composeTestRule.onNodeWithText("1500 мл").assertExists()
        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithText("Дней подряд: 1").assertExists()

        composeTestRule.onNodeWithText("+250 мл").performClick()
        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithText("Дней подряд: 0").assertExists()
    }
}