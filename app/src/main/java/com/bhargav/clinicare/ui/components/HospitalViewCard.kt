package com.bhargav.clinicare.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

data class HospitalViewData(
    val image: String,
    val title: String,
    val type: String,
    val distance: String,
    val openStatus: Boolean
)

@Composable
fun HospitalViewCard(hospitalViewData: HospitalViewData) {
    ConstraintLayout(
        modifier = Modifier
            .size(height = 200.dp, width = 326.dp)
            .clip(shape = RoundedCornerShape(size = 16.dp))
            .background(color = Color.LightGray)
    ) {
        val base = createRef()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                .constrainAs(base) { bottom.linkTo(parent.bottom) }
                .background(color = Color.White)
                .padding(horizontal = 20.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = hospitalViewData.title, style = MaterialTheme.typography.body1)
                Text(text = hospitalViewData.type, style = MaterialTheme.typography.caption)
            }

            Column {
                Text(text = hospitalViewData.distance, style = MaterialTheme.typography.body2)
                Text(
                    text = if (hospitalViewData.openStatus) "Open now" else "Closed",
                    style = MaterialTheme.typography.caption,
                    color = if (hospitalViewData.openStatus) Color.Green else Color.Red
                )
            }
        }
    }
}

@Preview
@Composable
fun HospitalViewPreview() {
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