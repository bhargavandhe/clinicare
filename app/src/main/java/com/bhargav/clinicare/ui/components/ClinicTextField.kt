package com.bhargav.clinicare.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ClinicTextField(
    label: String,
    modifier: Modifier = Modifier,
    value: String = "",
    placeholder: String = "",
    enabled: Boolean = true,
    singleLine: Boolean = true,
    errorText: String = "",
    trailingIcon: @Composable () -> Unit = { },
    keyboardType: KeyboardType = KeyboardType.Text,
    gutterBottom: Dp = 16.dp,
    onValueChanged: (String) -> Unit = {},
) {
    var textFieldValue = value
    Column {
        TextField(
            modifier = modifier
                .fillMaxWidth()
                .height(64.dp),
            value = textFieldValue,
            textStyle = MaterialTheme.typography.body2,
            enabled = enabled,
            label = { Text(text = label) },
            placeholder = { Text(text = placeholder) },
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            onValueChange = {
                textFieldValue = it
                onValueChanged(it)
            },
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = MaterialTheme.colors.primary
            ),
            trailingIcon = { trailingIcon() },
            singleLine = singleLine,
            visualTransformation = if (keyboardType == KeyboardType.Password) PasswordVisualTransformation() else VisualTransformation.None
        )
        AnimatedVisibility(errorText != "") {
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = errorText,
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.error
            )
        }
    }
    Spacer(modifier = Modifier.height(gutterBottom))
}
