package com.evergreen.todaycommit.domain.usecase

import com.evergreen.todaycommit.domain.repository.GithubRepository
import javax.inject.Inject

class GetGithubUserUseCase @Inject constructor(
    private val githubUserRepository: GithubRepository
) {
    suspend operator fun invoke(userName: String) = runCatching {
        githubUserRepository.getUsers(userName)
    }

}