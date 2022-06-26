package com.evergreen.todaycommit.data.mapper

import com.evergreen.todaycommit.data.model.GithubUserData
import com.evergreen.todaycommit.domain.model.GithubUser

fun GithubUserData.toDomain() = GithubUser(
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

fun GithubUserData.Contribution.toDomain() = GithubUser.Contribution(
    week = week,
    days = days.map{
        it.toDomain()
    }.toList()
)

fun GithubUserData.Contribution.Day.toDomain() = GithubUser.Contribution.Day(
    count = count
)