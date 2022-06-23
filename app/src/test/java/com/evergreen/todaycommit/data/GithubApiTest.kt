package com.evergreen.todaycommit.data

import com.evergreen.todaycommit.data.remote.api.GithubApi
import com.evergreen.todaycommit.data.remote.repository.GithubRepositoryImpl
import com.evergreen.todaycommit.domain.model.GithubUser
import com.evergreen.todaycommit.domain.repository.GithubRepository
import com.evergreen.todaycommit.enqueueResponse
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.concurrent.TimeUnit


class GithubApiTest {
    private val mockWebServer = MockWebServer()

    private lateinit var repository: GithubRepository

    @BeforeEach
    fun init() {
        val client = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.SECONDS)
            .writeTimeout(1, TimeUnit.SECONDS)
            .build()

        val api = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .client(client)
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
            .create(GithubApi::class.java)

        repository = GithubRepositoryImpl(api)

    }

    @DisplayName("github api test")
    @Test
    fun `fetch github api data must be 20`() {
        mockWebServer.enqueueResponse("github_user.json", 200)
        runBlocking {
            val actual = repository.getUsers()
            val expected = GithubUser(
                21
            )
            Assertions.assertEquals(actual, expected)
        }


    }

    @AfterEach
    fun tearDown() {
        mockWebServer.shutdown()
    }
}