package com.evergreen.todaycommit.domain.usecase

import com.evergreen.todaycommit.domain.repository.SkylineRepository
import javax.inject.Inject

class GetGithubSkylineUserUseCase @Inject constructor(
    private val skylineRepository: SkylineRepository
) {
    suspend operator fun invoke(userName: String) = runCatching {
        skylineRepository.getUsers(userName)
    }

}