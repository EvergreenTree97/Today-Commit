package com.evergreen.todaycommit.data.mapper

import com.evergreen.todaycommit.data.model.GithubUserData
import com.evergreen.todaycommit.domain.model.GithubUser

internal fun GithubUserData.toDomain() = GithubUser(
    followers = followers
)