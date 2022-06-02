package com.bhargav.clinicare.ui.screens.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bhargav.clinicare.ui.Routes
import com.bhargav.clinicare.ui.components.ClinicTextField
import com.bhargav.clinicare.ui.theme.DarkGreen
import com.bhargav.clinicare.ui.theme.Green
import com.bhargav.pocket.commons.components.ClinicButton

@Composable
fun AboutYouScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var birthday by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 124.dp, start = 42.dp, end = 42.dp)
    ) {
        Text(
            text = "About you",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            style = TextStyle(color = Green)
        )
        Text(
            text = "Enter your basic details",
            fontSize = 14.sp,
            style = TextStyle(color = Color.Black)
        )
        Box(
            modifier = Modifier
                .padding(4.dp)
                .size(250.dp)
        )

        ClinicTextField(
            label = "Name",
            onValueChanged = { name = it }
        )
        ClinicTextField(
            label = "Phone",
            onValueChanged = { phone = it }
        )

        Row() {

            Column(
                Modifier
                    .padding(1.dp)
                    .size(57.dp)
                    .weight(1f)
            ) {
                ClinicTextField(
                    label = "Gender",
                    onValueChanged = { gender = it }

                )
            }

            Column(
                Modifier
                    .padding(1.dp)
                    .size(57.dp)
                    .weight(1f)

            ) {
                ClinicTextField(
                    label = "Birthday",
                    onValueChanged = { birthday = it }
                )
            }
        }






        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 80.dp, start = 3.dp, end = 3.dp)
        ) {

            ClinicButton(
                text = "Next",
                color = Green,
                modifier = Modifier.clip(shape = RoundedCornerShape(12.dp))
            )
            Text(
                text = "Your data is safe and secure with us.",
                modifier = Modifier
                    .size(300.dp)
                    .padding(8.dp),
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                style = TextStyle(color = Color.Black)
            )
        }


    }

}


@Preview(showBackground = true)
@Composable
fun AboutYouScreenPreview() {
    AboutYouScreen(navController = rememberNavController())
}
