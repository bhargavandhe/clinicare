package com.bhargav.clinicare.ui.screens.onBoarding

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bhargav.clinicare.ui.Routes
import com.bhargav.clinicare.ui.theme.Green

@Composable
fun OnBoardingScreen(navController: NavController) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Green)
            .padding(42.dp)
    ) {
        val (content, buttons) = createRefs()

        Column(
            modifier = Modifier.constrainAs(content) {
                top.linkTo(anchor = parent.top, margin = 380.dp)
            }
        ) {
            Text(
                text = "Welcome to\nClinicare",
                style = MaterialTheme.typography.h4,
                color = Color.White
            )

            Text(
                text = "Lorem ipsum dolor sit amet, consectetur\n" +
                        "adipiscing elit. Integer id lacus a justo\n" +
                        "congue lacinia et vel justo.",
                style = MaterialTheme.typography.body2,
                color = Color.White
            )
        }

        Column(
            modifier = Modifier
                .constrainAs(buttons) {
                    bottom.linkTo(anchor = parent.bottom)
                }
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Login or Register to continue",
                style = MaterialTheme.typography.body2,
                color = Color.White
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                shape = CircleShape,
                onClick = {
                    navController.navigate(Routes.Login.route)
                },
            ) {
                Text(
                    text = "login".uppercase(),
                    style = MaterialTheme.typography.caption,
                    color = Green
                )
            }

            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                onClick = {
                    navController.navigate(Routes.Register.route)
                },
                border = BorderStroke(width = 1.dp, color = Color.White),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                shape = CircleShape
            ) {
                Text(
                    text = "register".uppercase(),
                    style = MaterialTheme.typography.caption,
                    color = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnBoardingScreenPreview() {
    OnBoardingScreen(navController = rememberNavController())
}
