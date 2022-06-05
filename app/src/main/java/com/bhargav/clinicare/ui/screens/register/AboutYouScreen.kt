package com.bhargav.clinicare.ui.screens.register

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bhargav.clinicare.model.Gender
import com.bhargav.clinicare.model.User
import com.bhargav.clinicare.ui.components.ClinicButton
import com.bhargav.clinicare.ui.components.ClinicTextField
import com.bhargav.clinicare.ui.theme.Green
import com.google.gson.Gson

private const val TAG = "AboutYouScreen"

@Composable
fun AboutYouScreen(navController: NavController, navArgs: Bundle?) {

    val decoded = Uri.decode(navArgs?.getString("credentials"))
    val credentials = Gson().fromJson<Map<String, String>>(decoded, Map::class.java)

    val email = credentials["email"]!!
    val password = credentials["password"]!!

    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var birthday by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        val (layout, button) = createRefs()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .constrainAs(layout) {
                    top.linkTo(parent.top, margin = 72.dp)
                }
        ) {
            Text(
                text = "About you",
                style = MaterialTheme.typography.h5,
                color = Green
            )
            Text(
                text = "Enter your basic details",
                style = MaterialTheme.typography.body2
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(48.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(152.dp)
                        .clip(shape = CircleShape)
                        .background(color = Color.LightGray)
                        .clickable { }
                )
            }

            ClinicTextField(
                label = "Name",
                value = name,
                onValueChanged = { name = it }
            )

            ClinicTextField(
                label = "Phone",
                value = phone,
                onValueChanged = { phone = it }
            )

            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Column(modifier = Modifier.weight(1f)) {
                    ClinicTextField(
                        label = "Gender",
                        value = gender,
                        onValueChanged = { gender = it }
                    )
                }

                Column(modifier = Modifier.weight(1f)) {
                    ClinicTextField(
                        label = "Birthday",
                        value = birthday,
                        onValueChanged = { birthday = it }
                    )
                }
            }

            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Column(modifier = Modifier.weight(1f)) {
                    ClinicTextField(
                        label = "Height",
                        value = height,
                        onValueChanged = { height = it }
                    )
                }

                Column(modifier = Modifier.weight(1f)) {
                    ClinicTextField(
                        label = "Weight",
                        value = weight,
                        onValueChanged = { weight = it }
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .constrainAs(button) {
                    bottom.linkTo(parent.bottom)
                }
        ) {
            ClinicButton(
                text = "Next",
                color = Green,
                modifier = Modifier.clip(shape = RoundedCornerShape(16.dp)),
                onClick = {
                    val user = User(
                        name = name,
                        email = email,
                        phone = phone,
                        gender = Gender.MALE,
                        birthday = birthday,
                        height = height.toLongOrNull() ?: 0L,
                        weight = weight.toLongOrNull() ?: 0L,
                    )
                    Log.d(TAG, "AboutYouScreen: $user")
                }
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
    AboutYouScreen(navController = rememberNavController(), navArgs = null)
}
