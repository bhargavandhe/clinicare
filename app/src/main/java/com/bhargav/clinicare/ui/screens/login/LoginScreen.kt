package com.bhargav.clinicare.ui.screens.login

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
import com.bhargav.clinicare.ui.components.ClinicTextField
import com.bhargav.clinicare.ui.theme.DarkGreen
import com.bhargav.clinicare.ui.theme.Green
import com.bhargav.pocket.commons.components.ClinicButton

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 124.dp, start = 42.dp, end = 42.dp)
    ) {
        Text(
            text = "\uD83D\uDC4B Hi, Welcome back!",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            style = TextStyle(color = Green)
        )
        Text(
            text = "Please login to continue",
            fontSize = 14.sp,
            style = TextStyle(color = DarkGreen)
        )
        Box(
            modifier = Modifier
                .padding(top = 20.dp)
                .padding(28.dp)
                .size(290.dp)
                .background(Color.LightGray)
        )

        ClinicTextField(
            label = "Email",
            onValueChanged = { email = it }
        )
        ClinicTextField(
            label = "Password",
            onValueChanged = { password = it }
        )
        Row(
            Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End,

        ) {
            Text(
                text = "Forgot password?",
                style = TextStyle(color = DarkGreen)
            )

        }
        
        ClinicButton(
            text = "Login",
            color = Green,
            modifier = Modifier.clip(shape = RoundedCornerShape(12.dp))
        )

        Text(
            buildAnnotatedString {
                withStyle(style = ParagraphStyle(lineHeight = 30.sp)) {
                    append("New user? ")
                    withStyle(style = SpanStyle(color = DarkGreen, fontWeight = FontWeight.Bold)) {
                        append("Register ")
                    }
                    append("now")
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(navController = rememberNavController())
}
