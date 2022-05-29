package com.bhargav.clinicare.ui.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bhargav.clinicare.ui.theme.DarkGreen
import com.bhargav.clinicare.ui.theme.Green

@Composable
fun LoginScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 124.dp, start = 42.dp)
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
    }

}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(navController = rememberNavController())
}