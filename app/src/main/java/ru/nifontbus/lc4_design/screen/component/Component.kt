package ru.nifontbus.lc4_design.screen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.WatchLater
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import ru.nifontbus.lc4_design.ui.theme.DarkGray

@Composable
fun IconClock() {
    Icon(
        imageVector = Icons.Outlined.WatchLater,
        contentDescription = "clock",
        tint = MaterialTheme.colors.onBackground,
        modifier = Modifier
            .size(20.dp)
            .padding(end = 4.dp)
    )
}

@Composable
fun CircleIcon(image: ImageVector, modifier: Modifier) {
    Box(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .size(50.dp)
                .clip(CircleShape)
                .background(DarkGray)
        ) {
            Icon(
                imageVector = image,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(30.dp),
                tint = MaterialTheme.colors.primary
            )
        }
    }
}

@Composable
fun ColorIcon(
    image: ImageVector, modifier: Modifier,
    background: Color,
    tint: Color
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(MaterialTheme.colors.surface)
            .size(40.dp)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .clip(CircleShape)
                .background(background)
                .size(34.dp)
        ) {
            Icon(
                imageVector = image,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(28.dp),
                tint = tint
            )
        }
    }
}

@Composable
fun surfaceBrush() = Brush.linearGradient(
    colors = listOf(
        MaterialTheme.colors.secondary,
        MaterialTheme.colors.secondaryVariant
    )
)