package com.evergreen.todaycommit.domain.repository

import com.evergreen.todaycommit.domain.model.GithubSkylineUser


interface SkylineRepository {
    suspend fun getUsers(userName: String): GithubSkylineUser
}