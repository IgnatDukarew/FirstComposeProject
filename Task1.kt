package com.example.firstcomposeproject

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Hello(name: String?, modifier: Modifier = Modifier) {
    Text(
        text = if (name != null) "Привет, $name!" else "Имя не задано",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun HelloPreview() {
    Hello("Анна")
}