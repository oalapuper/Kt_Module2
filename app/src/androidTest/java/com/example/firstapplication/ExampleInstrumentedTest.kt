package com.example.firstapplication

import androidx.activity.ComponentActivity
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.Rule
import org.junit.Test

class WaterTrackerTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun testWaterTrackerLogic() {
        // Запускаем функцию в тестовом окружении
        composeTestRule.setContent {
            MaterialTheme {
                WaterTracker()
            }
        }

        // 1. Проверка кнопки добавления жидкости
        composeTestRule.onNodeWithText("+250 мл").performClick()
        composeTestRule.onNodeWithText("250 мл").assertExists() // Проверяем, что счетчик обновился

        // 2. Проверка кнопки "Завершить день"
        repeat(5) { composeTestRule.onNodeWithText("+250 мл").performClick() } // Доводим до 1500
        composeTestRule.onNodeWithText("Завершить день").performClick()

        // 3. Проверка вывода текста с количеством дней
        composeTestRule.onNodeWithText("Дней подряд с нормой (1500 мл): 1").assertExists()
    }
}