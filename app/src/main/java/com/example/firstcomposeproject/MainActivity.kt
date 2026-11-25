package com.example.firstcomposeproject

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlin.random.Random

data class Product(
    val id: Int,
    val name: String,
    val price: Int
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartScreen()
        }
    }
}

@Composable
fun ShoppingCartScreen() {
    val context = LocalContext.current

    var products by remember {
        mutableStateOf(
            listOf(
                Product(0, "Товар #1", 100),
                Product(1, "Товар #2", 150),
                Product(2, "Товар #3", 56)
            )
        )
    }
    var nextId by remember { mutableIntStateOf(3) }

    // сумма вычисляется из состояния, а не накапливается при каждой отрисовке
    val totalSum = products.sumOf { it.price }

    Column(modifier = Modifier.padding(16.dp)) {
        for (product in products) {
            Text(text = product.name + " - " + product.price + " рублей")
        }

        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Товаров на сумму: $totalSum рублей")

        AddProductSection(
            onAdd = {
                val newProduct = Product(
                    id = nextId,
                    name = "Товар #${nextId + 1}",
                    price = Random.nextInt(1, 100)
                )
                nextId++
                products = products + newProduct

                // Toast показывается только в момент добавления, а не при рекомпозиции
                if (products.sumOf { it.price } > 500) {
                    Toast.makeText(context, "Доставка бесплатная!", Toast.LENGTH_SHORT).show()
                }
            }
        )

        RemoveProductSection(
            hasProducts = products.isNotEmpty(),
            onRemove = { products = products.dropLast(1) }
        )
    }
}

@Composable
fun AddProductSection(onAdd: () -> Unit) {
    Button(onClick = onAdd) {
        Text(text = "Добавить товар")
    }
}

@Composable
fun RemoveProductSection(hasProducts: Boolean, onRemove: () -> Unit) {
    if (hasProducts) {
        Button(onClick = onRemove) {
            Text(text = "Удалить товар")
        }
    }
}