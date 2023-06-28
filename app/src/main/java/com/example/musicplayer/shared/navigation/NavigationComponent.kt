package com.example.musicplayer.shared.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.musicplayer.nowplaying.NowPlayingRoute
import com.example.musicplayer.rooms.RoomRoute
import com.example.musicplayer.settings.SettingRoute

@ExperimentalFoundationApi
@Composable
fun MainNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = Feature.Rooms.route,
        modifier = modifier
    ) {
        composable(Feature.Rooms.route) {
            RoomRoute()
        }
        composable(Feature.NowPlaying.route) {
            NowPlayingRoute()
        }
        composable(Feature.Setting.route) {
            SettingRoute()
        }
    }
}

@Composable
fun BottomNavBar(
    allScreens: List<Feature>,
    onTabSelected: (Feature) -> Unit,
    currentRoute: String?
) {
    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp, 16.dp, 0.dp, 0.dp))
    ) {
        allScreens.forEach { screen ->
            NavigationBarItem(
                icon = {
                    Image(
                        painter = painterResource(screen.icon),
                        contentDescription = screen.route
                    )
                },
                label = { Text(text = screen.title, style = MaterialTheme.typography.labelSmall) },
                alwaysShowLabel = true,
                selected = currentRoute == screen.route,
                onClick = {
                    onTabSelected(screen)
                }
            )
        }
    }
}
