package com.example.firstcomposeproject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Contact(
    val name: String,
    val patronymic: String,
    val surname: String,
    val phone: String,
    val address: String
)

val sampleContacts = listOf(
    Contact("Евгений", "Андреевич", "Лукашин", "+7 495 495 95 95", "г. Москва, 3-я улица Строителей, д. 25, кв. 12"),
    Contact("Василий", "Егорович", "Кузякин", "---", "Ивановская область, дер. Крутово, д. 4"),
    Contact("Людмила", "Прокофьевна", "Калугина", "+7 495 788 78 78", "Москва, Большая Никитская, д. 43, кв. 290")
)

@Composable
fun ContactColumn(contact: Contact, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text("Имя: ${contact.name}")
        Text("Отчество: ${contact.patronymic}")
        Text("Фамилия: ${contact.surname}")
        Text("Мобильный телефон: ${contact.phone}")
        Text("Адрес: ${contact.address}")
    }
}

@Composable
fun ContactList(contacts: List<Contact>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        contacts.forEach { c ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Имя: ${c.name}")
                Text("Отчество: ${c.patronymic}")
                Text("Фамилия: ${c.surname}")
                Text("Мобильный телефон: ${c.phone}")
                Text("Адрес: ${c.address}")
            }
        }
    }
}

@Composable
fun ContactRow(contact: Contact) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.LightGray)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Имя: ${contact.name}")
            Text("Отчество: ${contact.patronymic}")
            Text("Фамилия: ${contact.surname}")
            Text("Мобильный телефон: ${contact.phone}")
            Text("Адрес: ${contact.address}")
        }
        Text(
            text = "★",
            fontSize = 28.sp,
            color = Color(0xFFFF9800)
        )
    }
}

@Preview(name = "ContactColumnPreview", showSystemUi = true)
@Composable
fun ContactColumnPreview() { ContactColumn(sampleContacts[0]) }

@Preview(name = "ListPreview", showSystemUi = true)
@Composable
fun ListPreview() { ContactList(sampleContacts) }

@Preview(name = "ContactRowPreview", showSystemUi = true)
@Composable
fun ContactRowPreview() { ContactRow(sampleContacts[0]) }