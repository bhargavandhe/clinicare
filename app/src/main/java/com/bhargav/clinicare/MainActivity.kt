package com.bhargav.clinicare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.compose.rememberNavController
import com.bhargav.clinicare.ui.Navigation
import com.bhargav.clinicare.ui.theme.ClinicareTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClinicareTheme {
                val navHostController = rememberAnimatedNavController()
                Navigation(navHostController = navHostController)
            }
        }
    }
}
