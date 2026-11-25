package com.example.firstcomposeproject

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.*
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*

@Composable
fun TextGreenItalic() {
    Text(
        text = stringResource(R.string.compose_desc),
        color = Color.Green,
        fontSize = 16.sp,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun TextOneLine() {
    Text(
        text = stringResource(R.string.compose_desc),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun TextIndented() {
    Text(
        text = stringResource(R.string.compose_desc),
        fontSize = 24.sp,
        color = Color.Black,
        textDecoration = TextDecoration.Underline,
        style = TextStyle(textIndent = TextIndent(firstLine = 48.sp)),
        modifier = Modifier.background(Color.Green)
    )
}

@Preview(name = "green italic", showBackground = true)
@Composable
fun TextGreenItalicPreview() { TextGreenItalic() }

@Preview(name = "one line", showBackground = true)
@Composable
fun TextOneLinePreview() { TextOneLine() }

@Preview(name = "indent", showBackground = true)
@Composable
fun TextIndentedPreview() { TextIndented() }