package com.bhargav.clinicare.ui.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bhargav.clinicare.ui.components.ClinicButton
import com.bhargav.clinicare.ui.components.ClinicTextField
import com.bhargav.clinicare.ui.theme.DarkGreen
import com.bhargav.clinicare.ui.theme.Green

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        val (layout, button) = createRefs()

        Column(
            modifier = Modifier.constrainAs(layout) {
                top.linkTo(parent.top, margin = 72.dp)
            }
        ) {
            Text(
                text = "\uD83D\uDC4B Hi, Welcome back!",
                style = MaterialTheme.typography.h5,
                color = Green
            )

            Text(
                text = "Please login to continue",
                style = MaterialTheme.typography.body2,
                color = DarkGreen
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(290.dp)
                    .padding(24.dp)
                    .clip(shape = RoundedCornerShape(16.dp))
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
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
            ) {
                Text(
                    text = "Forgot password?",
                    fontWeight = FontWeight.SemiBold,
                    color = DarkGreen
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(button) {
                    bottom.linkTo(parent.bottom)
                },
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ClinicButton(
                text = "Login",
                color = Green,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .clip(shape = RoundedCornerShape(12.dp)),
                onClick = { }
            )

            Text(
                text = buildAnnotatedString {
                    withStyle(style = ParagraphStyle(lineHeight = 30.sp)) {
                        append("New user? ")
                        withStyle(
                            style = SpanStyle(
                                color = DarkGreen,
                                fontWeight = FontWeight.Bold
                            ), block = { append("Register ") }
                        )
                        append("now")
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(navController = rememberNavController())
}
