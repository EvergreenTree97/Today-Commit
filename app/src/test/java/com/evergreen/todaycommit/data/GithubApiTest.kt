package com.evergreen.todaycommit.data

import com.evergreen.todaycommit.data.remote.api.GithubApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.concurrent.TimeUnit


class GithubApiTest {
    private val mockWebServer = MockWebServer()

    private val client = OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.SECONDS)
        .readTimeout(1, TimeUnit.SECONDS)
        .writeTimeout(1, TimeUnit.SECONDS)
        .build()

    private val api = Retrofit.Builder()
        .baseUrl(mockWebServer.url("/"))
        .client(client)
        .addConverterFactory(JacksonConverterFactory.create())
        .build()
        .create(GithubApi::class.java)

    @Test
    fun retrofitTest(){

        val result = runBlocking { api.getUser() }
        Assertions.assertEquals(result.followers,0)

    }
}