package com.evergreen.todaycommit.presentation.onboarding.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.evergreen.todaycommit.R
import com.evergreen.todaycommit.presentation.onboarding.components.RoundCornerButton
import com.evergreen.todaycommit.presentation.theme.Body12R
import com.evergreen.todaycommit.presentation.theme.Button14B
import com.evergreen.todaycommit.presentation.theme.Green100
import com.evergreen.todaycommit.presentation.theme.Green300
import com.evergreen.todaycommit.presentation.theme.Grey100
import com.evergreen.todaycommit.presentation.theme.White

@Composable
internal fun UserCheckDialog(
    userName: String,
    setShowDialog: (Boolean) -> Unit
) {
    Dialog(onDismissRequest = { setShowDialog(false) }) {
        Surface(
            modifier = Modifier
                .width(216.dp)
                .wrapContentHeight(),
            shape = RoundedCornerShape(20.dp),
            color = White
        ) {
            DialogContent(
                userName = userName,
                setShowDialog
            )
        }
    }

}

@Composable
private fun DialogContent(
    userName: String,
    setShowDialog: (Boolean) -> Unit
) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(24.dp))
        Image(
            painter = ColorPainter(Green100),
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
            contentDescription = stringResource(id = R.string.profile_content_description)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = userName,
            style = Body12R
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(id = R.string.is_account_correct),
            style = Button14B,
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .padding(start = 12.dp, end = 12.dp, bottom = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            RoundCornerButton(
                modifier = Modifier
                    .width(92.dp)
                    .height(48.dp)
                    .weight(1f),
                onClick = { setShowDialog(false) },
                color = Grey100
            ) {
                Text(
                    text = stringResource(id = R.string.rewrite),
                    style = Button14B
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            RoundCornerButton(
                modifier = Modifier
                    .width(92.dp)
                    .height(48.dp)
                    .weight(1f),
                onClick = { /*TODO*/ },
                color = Green300
            ) {
                Text(
                    text = stringResource(id = R.string.yes),
                    style = Button14B
                )
            }
        }
    }
}