package com.evergreen.todaycommit.presentation.main.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.evergreen.todaycommit.R
import com.evergreen.todaycommit.presentation.theme.White

@Composable
internal fun RoundCornerBox(
    modifier: Modifier,
    alignment: Alignment = Alignment.CenterStart,
    content: @Composable BoxScope.() -> Unit
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

@Composable
fun AnimationRefresh(
    fetchUser: () -> Unit
) {
    val (isRefreshEnabled, setRefreshEnabled) = remember { mutableStateOf(true) }
    val (isRefreshRotated, setRefreshRotated) = remember { mutableStateOf(false) }
    val angle: Float by animateFloatAsState(
        targetValue = if (isRefreshRotated) 1080F else 0F,
        animationSpec = tween(
            durationMillis = 2000,
            easing = FastOutSlowInEasing
        ),
        finishedListener = {
            setRefreshEnabled(true)
        }
    )
    Image(
        modifier = Modifier
            .clickable(enabled = isRefreshEnabled) {
                fetchUser()
                setRefreshRotated(!isRefreshRotated)
                setRefreshEnabled(false)
            }
            .rotate(angle),
        painter = painterResource(id = R.drawable.refresh),
        contentDescription = "refresh"
    )
}