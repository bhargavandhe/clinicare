package com.bhargav.clinicare.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.bhargav.clinicare.ui.theme.DarkGreen

data class AppointmentCardData(
    val image: String,
    val name: String,
    val role: String,
    val date: String,
    val time: String
)

@Composable
fun AppointmentCard(
    cardData: AppointmentCardData,
    isPrimary: Boolean,
    onClick: () -> Unit = {}
) {
    ConstraintLayout(
        modifier = Modifier
            .size(height = 200.dp, width = 180.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .clickable { onClick.invoke() }
            .background(color = if (isPrimary) DarkGreen else Color(0xFFE9E9E9))
            .padding(24.dp)
    ) {
        val (content, time) = createRefs()
        val primaryText = if (isPrimary) Color.White else Color(0xFF525252)

        Column(modifier = Modifier.constrainAs(content) { top.linkTo(parent.top) }) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(shape = CircleShape)
                    .background(color = Color.LightGray)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = cardData.name,
                style = MaterialTheme.typography.body2,
                color = primaryText
            )


            Text(
                text = cardData.role,
                style = MaterialTheme.typography.caption,
                color = primaryText.copy(alpha = 0.6f)
            )
        }

        Column(
            modifier = Modifier.constrainAs(time) { bottom.linkTo(parent.bottom) }
        ) {
            Text(
                text = cardData.date,
                style = MaterialTheme.typography.body2,
                color = primaryText
            )

            Text(
                text = cardData.time,
                style = MaterialTheme.typography.body2,
                color = primaryText
            )
        }
    }
}

@Preview
@Composable
fun AppointmentCardPreview() {
    AppointmentCard(
        isPrimary = true,
        cardData = AppointmentCardData(
            image = "",
            name = "Dr. Roeselien Raimond",
            role = "Gynecologist",
            date = "Today,",
            time = "8:00 AM"
        )
    )
}