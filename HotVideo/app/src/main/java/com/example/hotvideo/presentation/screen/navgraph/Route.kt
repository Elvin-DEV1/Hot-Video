package com.example.hotvideo.presentation.screen.navgraph

sealed class Route(
    val route: String
) {
    object OnBoardingScreen: Route(route = "onBoardingScreen")
    object HomeScreen: Route(route = "homeScreen")
    object SearchScreen: Route(route = "searchScreen")
    object DetailScreen: Route(route = "detailScreen")
    object FavoriteScreen: Route(route = "favoriteScreen")
    object AppStartNavigation: Route(route = "appStartNavigation")
    object VideoNavigation: Route(route = "videoNavigation")
    object VideoNavigatorScreen: Route(route = "videoNavigatorScreen")
}