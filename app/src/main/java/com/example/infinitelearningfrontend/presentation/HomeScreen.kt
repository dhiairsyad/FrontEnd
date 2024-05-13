package com.example.infinitelearningfrontend.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.infinitelearningfrontend.Data.DataDummy
import com.example.infinitelearningfrontend.Navigation.Screen
import com.example.infinitelearningfrontend.modele.Gym
import com.example.infinitelearningfrontend.modele.Member
import com.example.infinitelearningfrontend.presentation.component.GymItem
import com.example.infinitelearningfrontend.presentation.component.MemberItem

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    members: List<Member> = DataDummy.datamembers,
    gyms: List<Gym> = DataDummy.datagym,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        item {
            LazyRow(
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = modifier
            ) {
                items(gyms, key = { it.id }) {
                    GymItem(gym = it) { gymId ->
                        navController.navigate(Screen.Detail.route + "/$gymId")
                    }
                }
            }
        }
        items(members, key = { it.id }) {
            MemberItem(member = it, modifier = Modifier.padding(horizontal = 16.dp))
        }
    }
}
