package com.evergreen.todaycommit.data


import com.evergreen.todaycommit.data.extension.toModel
import com.evergreen.todaycommit.data.mapper.toDomain
import com.evergreen.todaycommit.data.model.GithubUserData
import com.evergreen.todaycommit.domain.model.GithubUser
import com.evergreen.todaycommit.domain.repository.GithubRepository
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class GithubApiTest {

    @MockK
    private lateinit var githubRepository: GithubRepository

    @BeforeEach
    fun init() {
        coEvery {
            githubRepository.getUsers()
        } returns GithubApiResponseDummy
            .users
            .toModel<GithubUserData>()
            .toDomain()


    }

    @DisplayName("github api test")
    @Test
    fun `fetch github api data must be 20`() = runTest {
        val users = githubRepository.getUsers()
        assert(users.followers == 20)
    }
}
