package com.bhargav.clinicare.ui.screens.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bhargav.clinicare.ui.components.ClinicButton
import com.bhargav.clinicare.ui.components.ClinicTextField
import com.bhargav.clinicare.ui.theme.DarkGreen
import com.bhargav.clinicare.ui.theme.Green

@Composable
fun RegisterScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 124.dp, start = 42.dp, end = 42.dp)
    ) {
        Text(
            text = "\uD83D\uDC4B Hi, Welcome!",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            style = TextStyle(color = Green)
        )
        Text(
            text = "Create an account to continue",
            fontSize = 14.sp,
            style = TextStyle(color = DarkGreen)
        )
        Box(
            modifier = Modifier
                .padding(18.dp)
                .size(282.dp)
                .background(Color.LightGray)
        )

        ClinicTextField(
            label = "Email",
            onValueChanged = { email = it }
        )
        ClinicTextField(
            label = "Create password",
            onValueChanged = { password = it }
        )
        ClinicTextField(
            label = "Confirm password",
            onValueChanged = { password = it }
        )

        ClinicButton(
            text = "Create",
            color = Green,
            modifier = Modifier.clip(shape = RoundedCornerShape(12.dp))
        )

        Text(
            buildAnnotatedString {
                withStyle(style = ParagraphStyle(lineHeight = 30.sp)) {
                    append("Already an user? ")
                    withStyle(style = SpanStyle(color = DarkGreen, fontWeight = FontWeight.Bold)) {
                        append("Login ")
                    }
                    append("to continue")
                }
            }
        )


    }

}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen(navController = rememberNavController())
}