package com.evergreen.todaycommit.presentation.onboarding.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.evergreen.todaycommit.presentation.onboarding.login.LoginScreen
import com.evergreen.todaycommit.presentation.onboarding.signup.UserNameInputScreen

@Composable
fun StartNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = StartScreens.LoginScreen.route
    ) {
        composable(route = StartScreens.LoginScreen.route) {
            LoginScreen {
                navController.navigate(StartScreens.UserNameInputScreen.route)
            }
        }
        composable(route = StartScreens.UserNameInputScreen.route) {
            UserNameInputScreen {
                navController.popBackStack()
            }
        }

    }
}
