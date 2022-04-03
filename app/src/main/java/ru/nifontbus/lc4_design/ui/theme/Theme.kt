package ru.nifontbus.lc4_design.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = PrimaryDark,
    primaryVariant = Purple700,
    secondary = SecondaryDark,
    secondaryVariant = SecondaryVariantDark,
    surface = SurfaceDark,
    onSurface = OnSurfaceDark,
    onBackground = OnBackgroundDark,
)

@Composable
fun LC4_DesignTheme(content: @Composable () -> Unit) {

    MaterialTheme(
        colors = DarkColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}