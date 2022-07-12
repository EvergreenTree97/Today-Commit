package com.evergreen.todaycommit.presentation.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.evergreen.todaycommit.R
import com.evergreen.todaycommit.presentation.theme.Background
import com.evergreen.todaycommit.presentation.theme.Body12R
import com.evergreen.todaycommit.presentation.theme.Green300
import com.evergreen.todaycommit.presentation.theme.Transparent
import com.evergreen.todaycommit.presentation.theme.White

@Composable
internal fun RoundCornerButton(
    modifier: Modifier,
    onClick: () -> Unit,
    color: Color,
    shape: RoundedCornerShape = RoundedCornerShape(20.dp),
    contents: @Composable RowScope.() -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
        onClick = { onClick() },
        shape = shape,
        colors = ButtonDefaults.buttonColors(color)
    ) {
        contents()
    }
}

@Composable
internal fun InputTextField(
    modifier: Modifier,
    value: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier,
        value = value, onValueChange = onValueChange,
        textStyle = Body12R,
        shape = RoundedCornerShape(20.dp),
        placeholder = {
            Text(
                text = stringResource(id = R.string.username_placeholder),
                style = Body12R
            )
        },
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = White,
            focusedIndicatorColor = Green300,
            unfocusedIndicatorColor = Background
        )
    )
}