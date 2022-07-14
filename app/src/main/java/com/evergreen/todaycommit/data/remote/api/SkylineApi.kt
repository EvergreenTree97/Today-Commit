package com.evergreen.todaycommit.data.remote.api

import com.evergreen.todaycommit.data.model.GithubSkylineUserData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SkylineApi {
    @GET("/{GITHUB_USER}/2022.json")
    suspend fun getUser(
        @Path("GITHUB_USER") userName: String,
    ): Response<GithubSkylineUserData>
}