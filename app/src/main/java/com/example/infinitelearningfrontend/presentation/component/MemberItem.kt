package com.example.infinitelearningfrontend.presentation.component

import androidx.compose.foundation.Image
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.infinitelearningfrontend.R
import com.example.infinitelearningfrontend.modele.Member
import com.example.infinitelearningfrontend.ui.theme.InfiniteLearningFrontEndTheme

@Composable
fun MemberItem(
    member: Member,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = member.photo),
            contentDescription = member.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(80.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = member.name, style = MaterialTheme.typography.titleMedium)
            Row {
                Text(text = " ${member.status}")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MemberItemPreview() {
    InfiniteLearningFrontEndTheme {
        MemberItem(
            member = Member(
                1,
                "Nama Member",
                "Membership",
                R.drawable.no_profile,
            )
        )
    }
}