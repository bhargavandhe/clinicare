package com.bhargav.clinicare.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bhargav.clinicare.ui.components.*
import com.bhargav.clinicare.ui.theme.ClinicGray

@Composable
fun HomeScreen(navController: NavController) {
    var searchVal by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 48.dp, start = 32.dp, end = 32.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Header()

        ClinicTextField(
            modifier = Modifier.padding(top = 24.dp),
            label = "Search",
            placeholder = "Search for doctors and hospitals",
            onValueChanged = { searchVal = it }
        )

        UpcomingAppointments()

        HospitalsNearMe()
    }
}

@Composable
fun Header() = Row(
    modifier = Modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween
) {
    Text(text = "Welcome,\nBhargav Andhe!", fontSize = 24.sp)
    Box(
        modifier = Modifier
            .size(48.dp)
            .clip(shape = CircleShape)
            .background(color = Color.LightGray)
    )
}

@Composable
fun UpcomingAppointments() {
    Text(text = "Your upcoming appointments >", fontSize = 16.sp)

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        state = rememberLazyListState(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(4) {
            AppointmentCard(
                cardData = AppointmentCardData(
                    image = "",
                    name = "Dr. Roeselien Raimond",
                    role = "Gynecologist",
                    date = "Today,",
                    time = "8:00 AM"
                ),
                isPrimary = it == 0,
                onClick = { }
            )
        }
    }
}

@Composable
fun HospitalsNearMe() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp)
    ) {
        Text(text = "Hospitals near me >")
        Text(
            text = "\uD83D\uDCCD Solapur, Maharashtra.",
            color = ClinicGray,
            style = MaterialTheme.typography.caption
        )

        repeat(4) {
            Spacer(modifier = Modifier.height(16.dp))
            HospitalViewCard(
                hospitalViewData = HospitalViewData(
                    image = "",
                    title = "CNS Hospital",
                    type = "Hospital",
                    distance = "3.9 kms",
                    openStatus = true
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}