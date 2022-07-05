package com.evergreen.todaycommit.domain.GithubUser


import com.evergreen.todaycommit.domain.model.GithubUser
import com.evergreen.todaycommit.domain.usecase.GetGithubUserUseCase
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class GetGithubUserUseCaseTest {

    @MockK
    private lateinit var githubUserUseCase: GetGithubUserUseCase


    @BeforeEach
    fun setup() {
        coEvery {
            githubUserUseCase("name")
        } returns Result.success(
            GithubUser(
                "name", 2022,
                1, 2, 3, 4, 5, 6, emptyList()
            )
        )

    }

    @DisplayName("github use case test success")
    @Test
    fun `fetch github contribution is success`() = runTest {
        val result = githubUserUseCase("name")
        assert(result.isSuccess)
    }

    @DisplayName("github use case test failed")
    @Test
    fun `fetch github contribution is failed`() = runTest {
        val result = githubUserUseCase("name")
        assert(result.isFailure)
    }

}