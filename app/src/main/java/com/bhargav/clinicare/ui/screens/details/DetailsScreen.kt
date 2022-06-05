package com.bhargav.clinicare.ui.screens.details

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Explore
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.Verified
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
import com.bhargav.clinicare.ui.components.ClinicButton
import com.bhargav.clinicare.ui.components.ClinicHeader
import com.bhargav.clinicare.ui.components.ClinicTextField
import com.bhargav.clinicare.ui.theme.Green

@Composable
fun DetailsScreen(navController: NavController) {
    val hospitalName = "CNS Hospital"
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        ClinicHeader(
            modifier = Modifier.padding(24.dp),
            title = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(text = hospitalName, style = MaterialTheme.typography.h6)
                    Icon(
                        imageVector = Icons.Rounded.Verified,
                        contentDescription = "verified",
                        tint = Green
                    )
                }
            },
            actions = {
                Row {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Rounded.Star, contentDescription = "favorite")
                    }
                }
            }
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(260.dp)
                .background(color = Color.LightGray)
        )

        AboutSection(hospitalName, address = "Some address!", aboutHospital = "Nice hospital!")
    }
}

@Composable
fun AboutSection(hospitalName: String, address: String, aboutHospital: String) {
    var review by remember { mutableStateOf("") }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        val (layout, button) = createRefs()

        Column(
            modifier = Modifier
                .constrainAs(layout) {
                    top.linkTo(parent.top)
                }
                .verticalScroll(state = rememberScrollState())
        ) {
            Text(text = hospitalName, style = MaterialTheme.typography.h6)

            Text(
                text = address,
                style = MaterialTheme.typography.body2,
                color = Color.Black.copy(alpha = 0.5f)
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    modifier = Modifier.padding(top = 4.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Green),
                    shape = CircleShape,
                    onClick = { /*TODO*/ },
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Explore,
                        contentDescription = "",
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Directions".uppercase(),
                        style = MaterialTheme.typography.caption,
                        color = Color.White
                    )
                }

                OutlinedButton(
                    onClick = { /*TODO*/ },
                    border = BorderStroke(width = 1.dp, color = Green),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    shape = CircleShape
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Call,
                        contentDescription = "",
                        tint = Green
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Phone".uppercase(),
                        style = MaterialTheme.typography.caption,
                        color = Green
                    )
                }
            }

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                color = Color.Black.copy(alpha = 0.2f),
                thickness = 0.5.dp
            )

            Text(text = "About us", style = MaterialTheme.typography.h6)

            Text(
                text = aboutHospital,
                style = MaterialTheme.typography.body2,
                color = Color.Black.copy(alpha = 0.5f)
            )

            Spacer(modifier = Modifier.padding(vertical = 8.dp))

            Text(text = "Recent prescriptions", style = MaterialTheme.typography.h6)

            LazyRow(
                state = rememberLazyListState(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(top = 12.dp)
            ) {
                items(4) {
                    Box(
                        modifier = Modifier
                            .size(size = 120.dp)
                            .clip(shape = RoundedCornerShape(12.dp))
                            .background(color = Color.LightGray)
                    )
                }
            }

            Text(text = "Reviews", style = MaterialTheme.typography.h6)

            ClinicTextField(
                modifier = Modifier.padding(top = 24.dp),
                label = "Review",
                placeholder = "Write your review",
                onValueChanged = { review = it }
            )
        }

        ClinicButton(
            text = "Book appointment",
            modifier = Modifier
                .constrainAs(button) { bottom.linkTo(parent.bottom) }
                .fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
    DetailsScreen(navController = rememberNavController())
}