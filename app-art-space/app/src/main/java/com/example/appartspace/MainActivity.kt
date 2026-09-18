package com.example.appartspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.mutableIntStateOf


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSapceLayout()
                }
            }
        }
    }
}
@Composable
fun ArtSapceLayout(modifier: Modifier = Modifier) {
    var currentArtwork by remember { mutableIntStateOf(1) }

    val imageResource = when (currentArtwork) {
        1 -> R.drawable.nacimientovenus
        2 -> R.drawable.nocheestrellada
        else -> R.drawable.elgrito
    }

    val titleResource = when (currentArtwork) {
        1 -> R.string.artwork_title_1
        2 -> R.string.artwork_title_2
        else -> R.string.artwork_title_3
    }

    val artistResource = when (currentArtwork) {
        1 -> R.string.artwork_artist_1
        2 -> R.string.artwork_artist_2
        else -> R.string.artwork_artist_3
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ArtworkWall(imageResource = imageResource)

        Spacer(modifier = Modifier.height(32.dp))

        DescripcionArte(
            title = titleResource,
            artist = artistResource
        )

        Spacer(modifier = Modifier.height(25.dp))

        DisplayController(
            onPreviousClick = {
                currentArtwork = if (currentArtwork > 1) currentArtwork - 1 else 3
            },
            onNextClick = {
                currentArtwork = if (currentArtwork < 3) currentArtwork + 1 else 1
            }
        )
    }
}

@Composable
fun ArtworkWall(
    @DrawableRes imageResource: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shadowElevation = 8.dp,
        border = BorderStroke(2.dp, Color.Gray)
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = null,
            modifier = Modifier.padding(16.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun DescripcionArte(
    @StringRes title: Int,
    @StringRes artist: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = Color(0xFFECEFF1)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = stringResource(id = title),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(id = artist),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
fun DisplayController(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = onPreviousClick,
            modifier = Modifier.width(130.dp)
        ) {
            Text(text = stringResource(id = R.string.previous_button))
        }
        Button(
            onClick = onNextClick,
            modifier = Modifier.width(130.dp)
        ) {
            Text(text = stringResource(id = R.string.next_button))
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ArtSapcePreview() {
    MaterialTheme {
        ArtSapceLayout()
    }
}