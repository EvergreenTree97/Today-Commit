package com.evergreen.todaycommit.data.mapper

import com.evergreen.todaycommit.data.model.GithubSkylineUserData
import com.evergreen.todaycommit.domain.model.GithubSkylineUser

fun GithubSkylineUserData.toDomain() = GithubSkylineUser(
    userName = userName,
    year = year,
    min = min,
    max = max,
    median = median,
    p80 = p80,
    p90 = p90,
    p99 = p99,
    contributions = contributions.map {
        it.toDomain()
    }.toList()
)

fun GithubSkylineUserData.Contribution.toDomain() = GithubSkylineUser.Contribution(
    week = week,
    days = days.map{
        it.toDomain()
    }.toList()
)

fun GithubSkylineUserData.Contribution.Day.toDomain() = GithubSkylineUser.Contribution.Day(
    count = count
)