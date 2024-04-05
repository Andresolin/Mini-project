package org.d3if3002.assessment1.navigation

sealed class Screen(val route : String) {
    data object Home: Screen("mainScreen")
    data object About: Screen("aboutScreen")
}