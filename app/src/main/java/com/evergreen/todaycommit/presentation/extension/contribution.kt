package com.evergreen.todaycommit.presentation.extension

import com.evergreen.todaycommit.R

fun Int.getExplainString() = when (this) {
    in 0..1 -> Pair(
        R.string.grass1_head,
        R.string.grass1_body
    )
    in 2..4 -> Pair(
        R.string.grass2_head,
        R.string.grass2_body
    )
    in 4..6 -> Pair(
        R.string.grass3_head,
        R.string.grass3_body
    )
    in 7..9 -> Pair(
        R.string.grass4_head,
        R.string.grass4_body
    )
    else -> Pair(
        R.string.grass5_head,
        R.string.grass5_body
    )
}

fun Int.getGrassPainter() = when (this) {
    in 0..1 -> R.drawable.grass1
    in 2..4 -> R.drawable.grass2
    in 4..6 -> R.drawable.grass3
    in 7..9 -> R.drawable.grass4
    else -> R.drawable.grass5
}