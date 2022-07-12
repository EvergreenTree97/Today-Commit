package com.evergreen.todaycommit.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.evergreen.todaycommit.R

val suit = FontFamily(
    Font(R.font.suit_bold, FontWeight.Bold, FontStyle.Normal),
    Font(R.font.suit_regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.suit_semibold, FontWeight.SemiBold, FontStyle.Normal)
)

val Button14B = TextStyle(
    fontFamily = suit,
    fontSize = 14.sp,
    fontWeight = FontWeight.Bold,
    lineHeight = 20.sp,
    letterSpacing = (-0.07).sp
)
val Head20B = TextStyle(
    fontFamily = suit,
    fontSize = 20.sp,
    fontWeight = FontWeight.Bold,
    lineHeight = 28.sp,
    letterSpacing = (-0.1).sp
)
val Body12R = TextStyle(
    fontFamily = suit,
    fontSize = 12.sp,
    fontWeight = FontWeight.Normal,
    lineHeight = 18.sp,
    letterSpacing = (-0.06).sp
)
val Typography = Typography(
   labelLarge = Button14B
)



