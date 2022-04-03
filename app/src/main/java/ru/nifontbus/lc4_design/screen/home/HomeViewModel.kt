package ru.nifontbus.lc4_design.screen.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    val state = mutableStateOf(ScreenState())
}

data class ScreenState(
    val userName: String = "Mike",
    val daysLeft: Byte = 9,
    val hoursLeft: Byte = 23,
    val minutesLeft: Byte = 59,
)