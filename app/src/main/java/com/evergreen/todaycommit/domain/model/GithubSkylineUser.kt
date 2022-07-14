package com.evergreen.todaycommit.domain.model

import org.threeten.bp.LocalDate
import org.threeten.bp.temporal.WeekFields


data class GithubSkylineUser(
    val userName: String,
    val year: Int,
    val min: Int,
    val max: Int,
    val median: Int,
    val p80: Int,
    val p90: Int,
    val p99: Int,
    val contributions: List<Contribution>
) {
    data class Contribution(
        val week: Int,
        val days: List<Day>
    ) {
        data class Day(
            val count: Int
        )
    }
}

fun GithubSkylineUser.getTodayContribution(): Int {
    val localDate = LocalDate.now()
    val weekOfYear = localDate.get(WeekFields.ISO.weekOfYear())
    val orderDayOfWeek = localDate.dayOfWeek.value
    val dayContribution = this.contributions.first {
        it.week == weekOfYear
    }.days[orderDayOfWeek]
    return dayContribution.count

}