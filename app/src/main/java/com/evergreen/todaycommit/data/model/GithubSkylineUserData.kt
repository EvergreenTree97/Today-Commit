package com.evergreen.todaycommit.data.model

import com.fasterxml.jackson.annotation.JsonProperty

data class GithubSkylineUserData(
    @JsonProperty("username")
    val userName: String,
    @JsonProperty("year")
    val year: Int,
    @JsonProperty("min")
    val min: Int,
    @JsonProperty("max")
    val max: Int,
    @JsonProperty("median")
    val median: Int,
    @JsonProperty("p80")
    val p80: Int,
    @JsonProperty("p90")
    val p90: Int,
    @JsonProperty("p99")
    val p99: Int,
    @JsonProperty("contributions")
    val contributions: List<Contribution>
) {
    data class Contribution(
        @JsonProperty("week")
        val week: Int,
        @JsonProperty("days")
        val days: List<Day>
    ) {
        data class Day(
            @JsonProperty("count")
            val count: Int
        )
    }
}