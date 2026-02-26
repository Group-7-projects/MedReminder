package com.example.mytherapy.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mytherapy.ui.screens.AddMedicationScreen
import com.example.mytherapy.ui.screens.DashboardScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "dashboard") {
        composable("dashboard") {
            DashboardScreen(
                onOpenSettings = {
                    // Navigate to settings or profile if needed
                }
            )
        }
        composable("add_medication") {
            AddMedicationScreen(navController = navController)
        }
    }
}
