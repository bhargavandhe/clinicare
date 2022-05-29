package com.bhargav.clinicare.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.bhargav.clinicare.ui.screens.login.LoginScreen
import com.bhargav.clinicare.ui.screens.register.RegisterScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

sealed class Routes(open val route: String) {
    object Login : Routes("login")
    object Register : Routes("register")
}

@ExperimentalAnimationApi
@Composable
fun Navigation(navHostController: NavHostController) {

    AnimatedNavHost(navController = navHostController, startDestination = Routes.Login.route) {

        // login screen
        composable(
            route = Routes.Login.route,
            content = { LoginScreen(navController = navHostController) }
        )

        // register
        composable(
            route = Routes.Register.route,
            content = { RegisterScreen(navController = navHostController) },
        )
    }

}
