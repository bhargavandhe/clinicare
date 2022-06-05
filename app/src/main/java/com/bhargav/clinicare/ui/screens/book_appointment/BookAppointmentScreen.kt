package com.bhargav.clinicare.ui.screens.book_appointment

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bhargav.clinicare.ui.components.ClinicHeader

@Composable
fun BookAppointmentScreen(navController: NavController) {
    val name = "Bhargav"

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            ClinicHeader(title = { Text("Book appointment", style = MaterialTheme.typography.h6) })

            Text(text = "Hello, $name", style = MaterialTheme.typography.h5)
            Text(text = "Choose a date and time for your appointment!")

            Box(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
                    .height(100.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .clickable { }
                    .border(
                        width = 0.5.dp,
                        color = Color.Black.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(16.dp)
                    )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp, horizontal = 24.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(text = "CNS Hospital", style = MaterialTheme.typography.h6)
                        Text(text = "24th May, 2022", style = MaterialTheme.typography.body2)
                        Text(text = "Friday . 04:00 PM", style = MaterialTheme.typography.caption)
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Rounded.Call, contentDescription = "call")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BookAppointmentPreview() {
    BookAppointmentScreen(navController = rememberNavController())
}