package ru.nifontbus.lc4_design.screen.classes

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ClassesScreen(
    paddingValues: PaddingValues,
) {
    Scaffold(
        backgroundColor = MaterialTheme.colors.background,
        modifier = Modifier.padding(paddingValues),
    ) {

    }
}