package com.evergreen.todaycommit.presentation.onboarding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.evergreen.todaycommit.presentation.onboarding.login.UserNameInputScreen
import com.evergreen.todaycommit.presentation.theme.TodayCommitTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodayCommitTheme {
                LoginScreen()
            }
        }
    }
}