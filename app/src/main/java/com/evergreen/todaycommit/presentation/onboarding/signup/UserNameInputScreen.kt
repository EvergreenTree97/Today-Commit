package com.evergreen.todaycommit.presentation.onboarding.signup

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.evergreen.todaycommit.R
import com.evergreen.todaycommit.presentation.onboarding.components.InputTextField
import com.evergreen.todaycommit.presentation.onboarding.components.RoundCornerButton
import com.evergreen.todaycommit.presentation.theme.Background
import com.evergreen.todaycommit.presentation.theme.Body12R
import com.evergreen.todaycommit.presentation.theme.Green100
import com.evergreen.todaycommit.presentation.theme.Green300
import com.evergreen.todaycommit.presentation.theme.Head20B

@Composable
internal fun UserNameInputScreen(
    onBackPressed: () -> Boolean,
) {
    val (userName, setUserName) = remember { mutableStateOf("") }
    var isDialogOpen by remember { mutableStateOf(false) }
    if (isDialogOpen) {
        UserCheckDialog(userName = userName) {
            isDialogOpen = it
        }
    }
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
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .fillMaxWidth()
                    .height(48.dp),
                onClick = {
                    if (userName.isNotEmpty()) {
                        isDialogOpen = true
                    }
                },
                color = if (userName.isNotEmpty()) {
                    Green300
                } else {
                    Green100
                }
            ) {
                Text(
                    text = stringResource(id = R.string.next),
                )
            }
        }

    }
}
