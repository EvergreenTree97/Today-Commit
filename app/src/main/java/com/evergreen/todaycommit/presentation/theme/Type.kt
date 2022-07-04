package com.evergreen.todaycommit.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.evergreen.todaycommit.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

val suit = FontFamily(
    Font(R.font.suit_bold, FontWeight.Bold, FontStyle.Normal),
    Font(R.font.suit_regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.suit_semibold, FontWeight.SemiBold, FontStyle.Normal)
)