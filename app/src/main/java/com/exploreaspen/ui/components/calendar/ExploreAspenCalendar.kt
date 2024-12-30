package com.exploreaspen.ui.components.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.exploreaspen.ui.theme.GradientBlueTheme
import com.exploreaspen.ui.theme.Gray100
import com.exploreaspen.ui.theme.Typography
import com.exploreaspen.ui.theme.White
import org.threeten.bp.LocalDate

@Composable
fun ExploreAspenHorizontalCalendar(
    startDate: LocalDate,
    daysToShow: Int,
    onDateSelected: (LocalDate) -> Unit
) {
    Column(modifier = Modifier.background(GradientBlueTheme).padding(horizontal = 30.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = "Upcoming Schedule", color = Color.White, style = Typography.headlineSmall)
            TextButton(onClick = { /*TODO*/ }) {
                Text(
                    text = "Month", color = Color.White, style = androidx.compose.ui.text.TextStyle(
                        textDecoration = TextDecoration.Underline, fontSize = 12.sp
                    )
                )
            }

        }
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 5.dp),
            color = Color.White
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 2.dp, bottom = 15.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            items(daysToShow) { dayOffset ->
                val date = startDate.plusDays(dayOffset.toLong())
                Box(
                    modifier = Modifier
                        .width(42.dp)
                        .height(64.dp)
                        .background(Color.Transparent)
                        .border(1.dp, Color.White, RoundedCornerShape(24.dp))
                        .padding(7.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {

                        Text(text = date.dayOfMonth.toString().uppercase(), color = Color.White, style = Typography.headlineMedium)
                        Text(text = date.dayOfWeek.name.take(3), color = Color.White, style = Typography.bodySmall)
                        //Text(text = "3", color = Color.White, style = Typography.headlineSmall)
                       // Text(text = "Thu".uppercase(), color = Color.White)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun ExploreAspenHorizontalCalendarPreview() {
    ExploreAspenHorizontalCalendar(daysToShow = 10, startDate = LocalDate.now()) {

    }
}