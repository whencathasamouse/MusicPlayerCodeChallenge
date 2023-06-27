package com.example.musicplayer.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.musicplayer.navigation.BottomNavBar
import com.example.musicplayer.navigation.Feature
import com.example.musicplayer.navigation.MainNavHost

/**
 * The main screen of the app that hosts the bottom navigation bar and content.
 */
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            BottomNavBar(
                allScreens = listOf(
                    Feature.Rooms,
                    Feature.NowPlaying,
                    Feature.Setting
                ),
                onTabSelected = { screen ->
                    navController.navigate(screen.route)
                },
                currentRoute = currentRoute
            )
        }
    ) { innerPadding ->
        MainNavHost(navController, modifier = Modifier.padding(innerPadding))
    }
}