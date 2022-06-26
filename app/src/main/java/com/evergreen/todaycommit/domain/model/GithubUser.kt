package com.evergreen.todaycommit.domain.model

import com.fasterxml.jackson.annotation.JsonProperty

data class GithubUser(
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