package com.evergreen.todaycommit.presentation.onboarding.login

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.evergreen.todaycommit.R
import com.evergreen.todaycommit.presentation.onboarding.components.InputTextField
import com.evergreen.todaycommit.presentation.onboarding.components.RoundCornerButton
import com.evergreen.todaycommit.presentation.theme.Background
import com.evergreen.todaycommit.presentation.theme.Body12R
import com.evergreen.todaycommit.presentation.theme.Green100
import com.evergreen.todaycommit.presentation.theme.Green300
import com.evergreen.todaycommit.presentation.theme.Head20B

@Preview
@Composable
private fun UserNameInputPreview() {
    UserNameInputScreen()
}

@Composable
internal fun UserNameInputScreen() {
    val (userName, setUserName) = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        Spacer(
            modifier = Modifier.height(90.dp)
        )
        Text(
            modifier = Modifier.padding(start = 20.dp),
            text = stringResource(id = R.string.greeting_title),
            style = Head20B
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        Text(
            modifier = Modifier.padding(start = 20.dp),
            text = stringResource(id = R.string.greeting_sub),
            style = Body12R
        )

        InputTextField(
            modifier = Modifier
                .padding(start = 20.dp, top = 28.dp, end = 20.dp)
                .fillMaxWidth(),
            value = userName,
            onValueChange = setUserName
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 44.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RoundCornerButton(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                onClick = { /*TODO*/ },
                color = if (userName.isNotEmpty()) {
                    Green300
                } else {
                    Green100
                }
            ) {
                Text(
                    text = "로그인",
                )
            }
        }

    }
}
