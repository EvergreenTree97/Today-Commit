package com.evergreen.todaycommit.presentation.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.evergreen.todaycommit.presentation.theme.White

@Composable
internal fun RoundCornerBox(
    modifier: Modifier,
    alignment: Alignment = Alignment.CenterStart,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(White),
        contentAlignment = alignment
    ) {
        content()
    }
}