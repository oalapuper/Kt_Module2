package com.example.firstapplication

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlin.random.Random

data class Product(val id: Int, val name: String, val price: Int)

@Composable
fun Task10_ShoppingCartScreen() {
    var products by remember { mutableStateOf(listOf<Product>()) }
    val totalSum = products.sumOf { it.price }
    val productSize = products.size
    val context = LocalContext.current

    Column(modifier = Modifier.padding(16.dp)) {
        products.forEach { product ->
            Text(text = "${product.name} - ${product.price} рублей")
        }

        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Товаров на сумму: $totalSum рублей")
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val newProduct = Product(
                    id = products.size,
                    name = "Товар #${products.size + 1}",
                    price = Random.nextInt(50, 200)
                )
                products = products + newProduct

                // Проверка на бесплатную доставку
                if (products.sumOf { it.price } > 500) {
                    Toast.makeText(context, "Доставка бесплатная!", Toast.LENGTH_SHORT).show()
                }
            }
        ) {
            Text("Добавить товар")
        }

        // Кнопка удаления появляется только если есть товары
        if (productSize > 0) {
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { products = products.dropLast(1) },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
            ) {
                Text("Удалить товар")
            }
        }
    }
}