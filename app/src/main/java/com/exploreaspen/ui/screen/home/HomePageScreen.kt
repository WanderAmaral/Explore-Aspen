package com.exploreaspen.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.exploreaspen.data.model.Booking
import com.exploreaspen.data.model.Category
import com.exploreaspen.data.model.mock.mockBookings
import com.exploreaspen.data.model.mock.mockCategories
import com.exploreaspen.ui.components.booking.ExploreAspenBookingItem
import com.exploreaspen.ui.components.button.ExploreAspenButton
import com.exploreaspen.ui.components.calendar.ExploreAspenHorizontalCalendar
import com.exploreaspen.ui.components.category.ExploreAspenCategoryFilterChipList
import com.exploreaspen.ui.theme.BlueParagrapph
import com.exploreaspen.ui.theme.BlueTitle
import com.exploreaspen.ui.theme.GradientBlueTheme
import com.exploreaspen.ui.theme.Gray100
import com.exploreaspen.ui.theme.Typography
import np.com.bimalkafle.firebaseauthdemoapp.AuthState
import np.com.bimalkafle.firebaseauthdemoapp.AuthViewModel
import org.threeten.bp.LocalDate

@Composable
fun HomePageScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    authViewModel: AuthViewModel
) {
    val authState = authViewModel.authState.observeAsState()
    val userName = remember { mutableStateOf("") }

    LaunchedEffect(authState.value) {
        when (authState.value) {
            is AuthState.Unauthenticated -> navController.navigate("signIn")
            else -> Unit
        }
        authViewModel.fetchUserName { name -> userName.value = name }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 20.dp)
                .verticalScroll(state = rememberScrollState())
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    ExploreAspenButton(
                        modifier = modifier
                            .size(40.dp)
                            .padding(3.dp),
                        iconRes = Icons.Filled.Notifications,
                        onClick = {}
                    )
                    ExploreAspenButton(
                        modifier = modifier
                            .size(40.dp)
                            .padding(3.dp),
                        iconRes = Icons.Filled.Settings,
                        onClick = {}
                    )
                    ExploreAspenButton(
                        modifier = modifier
                            .size(40.dp)
                            .padding(3.dp),
                        iconRes = Icons.Filled.Search,
                        onClick = {},
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Column(
                        modifier = modifier
                            .fillMaxHeight()
                            .padding(horizontal = 10.dp),
                        horizontalAlignment = Alignment.End,
                    ) {
                        Text(
                            text = "Hi, Welcome",
                            style = Typography.bodyMedium,
                            color = BlueParagrapph
                        )
                        Text(text = userName.value, style = Typography.labelMedium)
                    }
                    ExploreAspenButton(
                        iconRes = Icons.Filled.Logout,
                        modifier = modifier
                            .background(
                                Color.Transparent,
                                RoundedCornerShape(60.dp)
                            )
                            .size(40.dp)
                            .padding(3.dp),
                        onClick = {
                            authViewModel.signout()
                        }
                    )
                }
            }
            Spacer(modifier = modifier.height(24.dp))
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(text = "Categories", color = BlueParagrapph, style = Typography.headlineSmall)
                TextButton(onClick = {}) {
                    Text(
                        text = "See all",
                        color = BlueParagrapph,
                        style = androidx.compose.ui.text.TextStyle(
                            textDecoration = TextDecoration.Underline
                        )
                    )
                }
            }
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp, horizontal = 30.dp)
                    .background(Gray100)
            )
            ExploreAspenCategoryFilterChipList(
                categories = mockCategories,
                onSelectedCategoryChanged = {},
                modifier = modifier.padding(horizontal = 30.dp),
            )

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(GradientBlueTheme)
            ) {
                Column {
                    ExploreAspenHorizontalCalendar(
                        daysToShow = 30,
                        onDateSelected = {},
                        startDate = LocalDate.now()
                    )

                    Box(
                        modifier = modifier
                            .padding(horizontal = 30.dp, vertical = 20.dp)
                            .fillMaxWidth()
                            .background(Color.Transparent)
                            .border(1.dp, Color.White, RoundedCornerShape(20.dp))
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 15.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.End
                            ) {
                                TextButton(onClick = { /*TODO*/ }) {
                                    Text(
                                        text = "See all",
                                        color = Color.White,
                                        style = androidx.compose.ui.text.TextStyle(
                                            textDecoration = TextDecoration.Underline
                                        )
                                    )
                                }
                            }



                            mockBookings.forEach { booking ->
                                ExploreAspenBookingItem(
                                    booking = booking
                                )
                            }


                        }
                    }
                }
            }
        }

    }
}


@Preview
@Composable
private fun HomePageScreenPreview() {
    val navController = rememberNavController()
    HomePageScreen(
        navController = navController,
        authViewModel = AuthViewModel()
    )
}
