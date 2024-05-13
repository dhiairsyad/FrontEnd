package com.example.infinitelearningfrontend.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.infinitelearningfrontend.Data.DataDummy
import com.example.infinitelearningfrontend.modele.Gallery
import com.example.infinitelearningfrontend.ui.theme.InfiniteLearningFrontEndTheme


@Composable
fun GalleryScreen(
    modifier: Modifier = Modifier,
    galleries: List<Gallery> = DataDummy.datagallery,
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(160.dp),
        verticalItemSpacing = 4.dp,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(galleries, key = { it.id }) {
            Image(
                painter = painterResource(id = it.photo),
                contentDescription = it.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            )
        }
    }g
}

@Preview(showSystemUi = true)
@Composable
private fun GalleryScreenPreview() {
    InfiniteLearningFrontEndTheme {
        GalleryScreen(galleries = DataDummy.datagallery)
    }
}