package com.evergreen.todaycommit.data.repository

import com.evergreen.todaycommit.data.extension.apiCall
import com.evergreen.todaycommit.data.mapper.toDomain
import com.evergreen.todaycommit.data.remote.api.SkylineApi
import com.evergreen.todaycommit.domain.model.GithubSkylineUser
import com.evergreen.todaycommit.domain.repository.SkylineRepository
import javax.inject.Inject

class SkylineRepositoryImpl @Inject constructor(
    private val skylineApi: SkylineApi
) : SkylineRepository {
    override suspend fun getUsers(userName: String): GithubSkylineUser
        = skylineApi.getUser(userName).apiCall().toDomain()
}