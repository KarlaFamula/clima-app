package com.example.climaapp.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.climaapp.ui.details.DetailsScreen
import com.example.climaapp.ui.favorites.FavoritesScreen
import com.example.climaapp.ui.search.SearchScreen

@Composable
fun ClimaNavHost(innerPadding: PaddingValues = PaddingValues()) {
    val navController = rememberNavController()
    
    NavHost(
        navController = navController,
        startDestination = Screen.Search.route
    ) {
        composable(Screen.Search.route) { SearchScreen() }
        composable(Screen.Favorites.route) { FavoritesScreen() }
        composable(Screen.Details.route) { DetailsScreen() }
    }
}
