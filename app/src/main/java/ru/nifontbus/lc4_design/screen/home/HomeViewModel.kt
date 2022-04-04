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
    val homework: List<Homework> = listOf(
        Homework(
            name = "Literature",
            daysLeft = 2,
            title = "Read scenes 1.1-1.12 of The Master and Margarita."
        ),
        Homework(
            name = "Physics",
            daysLeft = 5,
            title = "Learn of Newton's first law"
        ),
        Homework(
            name = "Mathematics",
            daysLeft = 7,
            title = "Learning the basics of trigonometry. Sines, cosines, tangents."
        )
    )
)

data class Homework(
    val name: String,
    val daysLeft: Int,
    val title: String,
)