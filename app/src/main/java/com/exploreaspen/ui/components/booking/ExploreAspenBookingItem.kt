package com.exploreaspen.ui.components.booking

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.exploreaspen.data.model.Booking
import com.exploreaspen.ui.theme.Typography

@Composable
fun ExploreAspenBookingItem(modifier: Modifier = Modifier, booking: Booking) {
    Column(modifier = Modifier.fillMaxWidth()) {
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth().padding(vertical = 10.dp),
            color = Color.White
        )
        Row(modifier = modifier) {
            Text(
                text = "${booking.date}  -", style = Typography.bodyMedium,
                color = Color.White,
                modifier = modifier.padding(horizontal = 5.dp)
            )
            Text(
                text = booking.dayOfWeek, style = Typography.bodyMedium,
                color = Color.White,
            )
        }
        Row() {

            Text(
                text = booking.time,
                style = Typography.bodyLarge,
                color = Color.White,
                modifier = modifier.padding(horizontal = 5.dp)
            )
            Text(
                text = booking.doctorName, style = Typography.bodyLarge,
                color = Color.White,
            )
        }

    }
}


@Preview
@Composable
private fun ExploreAspenBookingItemPreview() {
    ExploreAspenBookingItem(
        booking = Booking(
            id = "1",
            date = "2024-12-30",
            dayOfWeek = "Monday",
            time = "10:00 am",
            doctorName = "Dr. John Doe"
        ),
    )
}


