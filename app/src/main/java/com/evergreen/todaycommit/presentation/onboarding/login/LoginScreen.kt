package com.evergreen.todaycommit.presentation.onboarding.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.evergreen.todaycommit.R
import com.evergreen.todaycommit.presentation.onboarding.components.RoundCornerButton
import com.evergreen.todaycommit.presentation.theme.Background
import com.evergreen.todaycommit.presentation.theme.Green300


@Preview
@Composable
private fun LoginPreview() {
    LoginScreen{}
}

@Composable
internal fun LoginScreen(
    navigateToOnBoarding: () -> Unit
) {
    Column(
        modifier = Modifier
            .background(Background)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.big_logo), contentDescription = "logo"
        )
        Spacer(modifier = Modifier.height(300.dp))
        RoundCornerButton(
            Modifier
                .padding(start = 20.dp, end = 20.dp)
                .fillMaxWidth()
                .height(48.dp),
            onClick = { navigateToOnBoarding() },
            color = Green300
        ) {
            Text(
                text = stringResource(id = R.string.login),
            )
        }
        Spacer(modifier = Modifier.height(44.dp))
    }
}