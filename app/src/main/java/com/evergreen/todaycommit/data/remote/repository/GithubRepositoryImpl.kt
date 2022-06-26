package com.evergreen.todaycommit.data.remote.repository

import com.evergreen.todaycommit.data.extension.apiCall
import com.evergreen.todaycommit.data.mapper.toDomain
import com.evergreen.todaycommit.data.model.GithubUserData
import com.evergreen.todaycommit.data.remote.api.GithubApi
import com.evergreen.todaycommit.domain.model.GithubUser
import com.evergreen.todaycommit.domain.repository.GithubRepository
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(
    private val githubApi: GithubApi
) : GithubRepository {
    override suspend fun getUsers(userName: String): GithubUser
        = githubApi.getUser(userName).apiCall().toDomain()
}