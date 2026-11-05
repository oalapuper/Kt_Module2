package com.example.firstapplication // Твой package name

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// ================= ЗАДАНИЕ 6 =================
@Composable
fun Task6_CircleTopRight() {
    Box(
        modifier = Modifier
            .size(240.dp, 120.dp)
            .background(Color.Black)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.circle),
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .align(Alignment.TopEnd)
        )
    }
}

@Composable
fun Task6_CircleCenterStretched() {
    Box(
        modifier = Modifier
            .size(240.dp, 120.dp)
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.circle),
            contentDescription = null,
            tint = Color.Magenta, // Фиолетовый цвет
            modifier = Modifier.fillMaxSize()
        )
    }
}

// ================= ЗАДАНИЕ 7 =================
@Composable
fun Task7_ContactList() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // Три контакта в столбик
        ContactCard("Евгений", "+7 495 495 95 95", "г. Москва, 3-я улица Строителей, д. 25, кв. 12")
        Spacer(modifier = Modifier.height(8.dp))
        ContactCard("Борис", "+7 495 000 00 00", "г. Иваново, ул. Крупской, д. 4")
        Spacer(modifier = Modifier.height(8.dp))
        ContactCard("Анна", "+7 999 111 22 33", "г. Москва, Большая Никитская, д. 40")

        Spacer(modifier = Modifier.height(24.dp))

        // Один контакт в Row с иконкой звезды
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Имя: Евгений")
                Text(text = "Телефон: +7 495 495 95 95")
                Text(text = "Адрес: г. Москва, 3-я улица Строителей, д. 25, кв. 12")
            }
            Icon(imageVector = Icons.Default.Star, contentDescription = "Избранное", tint = Color(0xFFFFA500))
        }
    }
}

@Composable
fun ContactCard(name: String, phone: String, address: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Имя: $name")
        Text(text = "Телефон: $phone")
        Text(text = "Адрес: $address")
    }
}

// ================= ЗАДАНИЕ 8 =================
@Composable
fun WaterTracker() {
    // ИСПРАВЛЕНО: добавили remember и mutableIntStateOf
    var waterCount by remember { mutableIntStateOf(0) }
    var streakDays by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Трекер воды",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF415f91) // primaryColor
        )

        Spacer(modifier = Modifier.height(48.dp))

        // ИСПРАВЛЕНО: добавили вывод счетчика
        Text(
            text = "$waterCount мл",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF565f71) // secondaryColor
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF415f91)),
            onClick = { waterCount += 250 } // ИСПРАВЛЕНО: += вместо =
        ) {
            Text(
                text = "+250 мл",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White // buttonTextColor
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // ДОБАВЛЕНО: кнопка завершения дня
        Button(
            onClick = {
                if (waterCount >= 1500) {
                    streakDays += 1
                } else {
                    streakDays = 0
                }
                waterCount = 0
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text(text = "Завершить день")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // ДОБАВЛЕНО: вывод дней подряд
        Text(
            text = "Дней подряд с нормой (1500 мл): $streakDays",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium
        )
    }
}