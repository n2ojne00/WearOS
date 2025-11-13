package com.example.mykotlinwearos.presentation.navigation

import SimpleConfigTest
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.mykotlinwearos.presentation.screens.*

@Composable
fun AppNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = "main"
    ) {
        composable("main") { MainScreen(navController) }
        composable("themeTest") { ThemeTestScreen(navController) }
        composable("today") { TodayScreen(navController) }
        composable("configTest") { SimpleConfigTest(navController)}
    }
}
