package com.bhargav.clinicare.ui.screens.login

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bhargav.clinicare.data.Repository
import com.bhargav.clinicare.ui.Routes
import com.bhargav.clinicare.ui.components.ClinicButton
import com.bhargav.clinicare.ui.components.ClinicTextField
import com.bhargav.clinicare.ui.theme.DarkGreen
import com.bhargav.clinicare.ui.theme.Green
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

private const val TAG = "LoginScreen"
private const val NO_SUCH_EMAIL =
    "There is no user record corresponding to this identifier. The user may have been deleted."
private const val INVALID_PASSWORD = "The password is invalid or the user does not have a password."

@Composable
fun LoginScreen(navController: NavController) {

    val viewModel: LoginViewModel = viewModel()
    val scope = rememberCoroutineScope()

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
                value = viewModel.email,
                onValueChanged = { viewModel.email = it },
                errorText = viewModel.emailError
            )

            ClinicTextField(
                label = "Password",
                value = viewModel.password,
                onValueChanged = { viewModel.password = it },
                errorText = viewModel.passwordError
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
            ) {
                Text(
                    text = "Forgot password?",
                    style = MaterialTheme.typography.body2,
                    color = DarkGreen,
                    fontWeight = FontWeight.SemiBold
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
                onClick = {
                    if (viewModel.email != "" && viewModel.password != "")
                        scope.launch {
                            val auth = FirebaseAuth.getInstance()
                            auth.signInWithEmailAndPassword(viewModel.email.trim(), viewModel.password)
                                .addOnSuccessListener {
                                    Log.d(TAG, "LoginScreen: Success")
                                    Repository.getInstance().init()
                                    navController.navigate(Routes.Home.route)
                                }.addOnFailureListener {
                                    when (it.message) {
                                        NO_SUCH_EMAIL -> viewModel.emailError = "Email not registered!"
                                        INVALID_PASSWORD -> viewModel.passwordError = "Invalid password!"
                                        else -> Log.d(TAG, "LoginScreen: ${it.message}")
                                    }
                                }
                        }
                }
            )

            Text(
                text = buildAnnotatedString {
                    withStyle(style = ParagraphStyle(lineHeight = 30.sp)) {
                        append("New user? ")
                        withStyle(
                            style = SpanStyle(
                                color = DarkGreen,
                                fontWeight = FontWeight.SemiBold
                            ), block = { append("Register ") }
                        )
                        append("now")
                    }
                },
                style = MaterialTheme.typography.body2,
                modifier = Modifier.clickable {
                    navController.navigate(Routes.Register.route)
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
