package com.evergreen.todaycommit.presentation.onboarding.navigation

sealed class StartScreens(val route: String){
    object LoginScreen : StartScreens("login_screen")
    object UserNameInputScreen : StartScreens("username_input_screen")
}
