package ru.nifontbus.lc4_design

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.nifontbus.lc4_design.navigation.BottomBar
import ru.nifontbus.lc4_design.navigation.Route
import ru.nifontbus.lc4_design.screen.classes.ClassesScreen
import ru.nifontbus.lc4_design.screen.home.HomeScreen
import ru.nifontbus.lc4_design.ui.theme.LC4_DesignTheme

@ExperimentalComposeUiApi
@ExperimentalMaterialApi

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LC4_DesignTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ConfigureBottomNavigate()
                }
            }
        }
    }

    @Composable
    private fun ConfigureBottomNavigate() {
        Surface(color = MaterialTheme.colors.background) {
            val navController = rememberNavController()
            Scaffold(
                bottomBar = { BottomBar(navController) }
            ) { paddingValues ->
                NavHost(
                    navController = navController,
                    startDestination = Route.HOME
                ) {

                    composable(Route.HOME) {
                        HomeScreen(paddingValues = paddingValues)
                    }
                    composable(Route.CLASSES) {
                        ClassesScreen(paddingValues = paddingValues)
                    }
                    composable(Route.GROUP) {

                    }
                    composable(Route.STAR) {

                    }
                }
            }
        }
    }
}