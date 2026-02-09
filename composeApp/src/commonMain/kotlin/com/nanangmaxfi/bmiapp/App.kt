package com.nanangmaxfi.bmiapp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nanangmaxfi.bmiapp.screen.BMIScreen


@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        AppNavHost(navController = navController)
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: Screen = Screen.Home
){
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ){
        composable<Screen.Home> {
            BMIScreen()
        }
    }
}