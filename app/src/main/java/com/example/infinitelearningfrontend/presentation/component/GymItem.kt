package com.example.infinitelearningfrontend.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.infinitelearningfrontend.modele.Gym
import com.example.infinitelearningfrontend.R
import com.example.infinitelearningfrontend.ui.theme.InfiniteLearningFrontEndTheme


@Composable
fun GymItem(
    gym: Gym,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.clickable {
            onItemClicked(gym.id)
        }
    ) {
        Image(
            painter = painterResource(id = gym.photo),
            contentDescription = gym.name, modifier = Modifier
                .clip(CircleShape)
                .size(80.dp)
        )
        Text(
            text = gym.name,
            style = MaterialTheme.typography.titleMedium,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            modifier = Modifier.width(80.dp),
            maxLines = 1
        )
        Text(
            text = gym.alamat,
            color = MaterialTheme.colorScheme.primary,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.width(80.dp),
            maxLines = 1
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun GymItemHorizontalPreview() {
    InfiniteLearningFrontEndTheme {
        GymItem(
            gym = Gym(1, "Gym Kuat", "Citapen", R.drawable.no_profile),
            onItemClicked = { gymId ->
                println("Gym Id : $gymId")
            }
        )
    }
}