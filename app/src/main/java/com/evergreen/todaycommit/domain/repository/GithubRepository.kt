package com.evergreen.todaycommit.domain.repository

import com.evergreen.todaycommit.domain.model.GithubUser

interface GithubRepository {
    suspend fun getUsers(userName: String): GithubUser
}