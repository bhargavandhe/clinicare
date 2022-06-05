package com.bhargav.clinicare.ui

import android.net.Uri
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.bhargav.clinicare.ui.screens.login.LoginScreen
import com.bhargav.clinicare.ui.screens.onBoarding.OnBoardingScreen
import com.bhargav.clinicare.ui.screens.register.AboutYouScreen
import com.bhargav.clinicare.ui.screens.register.RegisterScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.firebase.auth.FirebaseAuth
import com.google.gson.Gson

sealed class Routes(open val route: String) {
    object OnBoarding : Routes("on-boarding")
    object Login : Routes("login")
    object Register : Routes("register")
    object AboutYou : Routes("about-you/{credentials}") {
        fun passEmailAndPassword(email: String, password: String) =
            "about-you/${Uri.encode(Gson().toJson(mapOf("email" to email, "password" to password)))}"
    }

    object Home : Routes("home")
}

@ExperimentalAnimationApi
@Composable
fun Navigation(navHostController: NavHostController) {

    var startDestination = Routes.OnBoarding.route
    if (FirebaseAuth.getInstance().currentUser != null) startDestination = Routes.Home.route

    AnimatedNavHost(navController = navHostController, startDestination = startDestination) {

        // on boarding
        composable(
            route = Routes.OnBoarding.route,
            content = { OnBoardingScreen(navController = navHostController) }
        )

        // login screen
        composable(
            route = Routes.Login.route,
            content = { LoginScreen(navController = navHostController) }
        )

        // register
        composable(
            route = Routes.Register.route,
            content = { RegisterScreen(navController = navHostController) }
        )

        // about you
        composable(
            route = Routes.AboutYou.route,
            arguments = listOf(
                navArgument("credentials") {
                    type = NavType.StringType
                }
            ),
            content = { AboutYouScreen(navController = navHostController, navArgs = it.arguments) }
        )
    }
}
