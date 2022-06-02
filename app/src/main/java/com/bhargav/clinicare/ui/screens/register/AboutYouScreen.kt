package com.bhargav.clinicare.ui.screens.register

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bhargav.clinicare.ui.components.ClinicButton
import com.bhargav.clinicare.ui.components.ClinicTextField
import com.bhargav.clinicare.ui.theme.Green

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

        ClinicTextField(
            label = "Name",
            onValueChanged = { name = it }
        )
        ClinicTextField(
            label = "Phone",
            onValueChanged = { phone = it }
        )

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                ClinicTextField(
                    label = "Gender",
                    onValueChanged = { gender = it }
                )
            }

            Column(modifier = Modifier.weight(1f)) {
                ClinicTextField(
                    label = "Birthday",
                    onValueChanged = { birthday = it }
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 54.dp)
        ) {

            ClinicButton(
                text = "Next",
                color = Green,
                modifier = Modifier.clip(shape = RoundedCornerShape(16.dp))
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Outlined.Lock, contentDescription = "lock")
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Your data is safe and secure with us.",
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AboutYouScreenPreview() {
    AboutYouScreen(navController = rememberNavController())
}
