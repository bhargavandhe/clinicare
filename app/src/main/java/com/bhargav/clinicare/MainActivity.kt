package com.bhargav.clinicare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import com.bhargav.clinicare.ui.Navigation
import com.bhargav.clinicare.ui.theme.ClinicareTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.firebase.FirebaseApp

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirebaseApp.initializeApp(this)
            ClinicareTheme {
                val systemUiController = rememberSystemUiController()
                systemUiController.setStatusBarColor(color = MaterialTheme.colors.primary)

                val navHostController = rememberAnimatedNavController()
                Navigation(navHostController = navHostController)
            }
        }
    }
}
