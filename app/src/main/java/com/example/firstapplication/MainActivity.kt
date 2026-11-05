package com.example.firstapplication // ВАЖНО: Оставь свой package name, который у тебя был в самом начале файла!

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstapplication.ui.theme.FirstApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstApplicationTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    //Task1_Hello("Ярослав")
                    //Task1_Hello(null)
                    //Task3_StyledText()
                    //Task4_CustomButton()
                    //Task5_CircleInContainer()WaterTracker()
                    //Task6_CircleTopRight()
                    //Task6_CircleCenterStretched()
                    //Task7_ContactList()
                    //WaterTracker()
                    Task10_ShoppingCartScreen()
                }
            }
        }
    }
}

// ================= ЗАДАНИЕ 1 =================
@Composable
fun Task1_Hello(name: String?) {
    val message = if (name != null) "Привет, $name!" else "Имя не задано"
    Text(
        text = message,
        fontSize = 24.sp,
        modifier = Modifier.padding(16.dp)
    )
}

// ================= ЗАДАНИЕ 2 =================
@Preview(name = "portrait", showSystemUi = true, device = "spec:width=411dp,height=891dp,dpi=420")
@Composable
fun PreviewPortrait() {
    FirstApplicationTheme { Task1_Hello("Ярослав") }
}

@Preview(name = "landscape", showSystemUi = true, device = "spec:width=891dp,height=411dp,dpi=420,orientation=landscape")
@Composable
fun PreviewLandscape() {
    FirstApplicationTheme { Task1_Hello("Ярослав") }
}

@Preview(name = "round", showSystemUi = true, device = "spec:width=200dp,height=200dp,dpi=420,isRound=true", backgroundColor = 0xFFFFFF00)
@Composable
fun PreviewRound() {
    FirstApplicationTheme { Task1_Hello("Ярослав") }
}

// ================= ЗАДАНИЕ 3 =================
@Composable
fun Task3_StyledText() {
    Column(modifier = Modifier.padding(16.dp)) {
        // Первая строка: отступ 48.sp, 24.sp, черный цвет, зеленый фон, подчеркнута
        Text(
            text = "Заголовок",
            modifier = Modifier
                .padding(bottom = 48.dp)
                .background(Color.Green),
            color = Color.Black,
            fontSize = 24.sp,
            textDecoration = TextDecoration.Underline
        )

        // Основной текст: зеленый, 16.sp, курсив, по центру, 1 строка, многоточие
        Text(
            text = stringResource(id = R.string.long_text), // Убедись, что добавил строку в strings.xml (см. ниже)
            color = Color.Green,
            fontSize = 16.sp,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

// ================= ЗАДАНИЕ 4 =================
@Composable
fun Task4_CustomButton() {
    Button(
        onClick = { /* Действие */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(2.dp, Color.Gray),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.LightGray,
            contentColor = Color.Black
        )
    ) {
        Text(text = "Нажми на меня")
    }
}

// ================= ЗАДАНИЕ 5 =================
@Composable
fun Task5_CircleInContainer() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.Gray),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxHeight()
                .aspectRatio(1f) // Делает круг
                .background(Color.White, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "АБ", color = Color.Black, fontWeight = FontWeight.Bold)
        }
    }
}