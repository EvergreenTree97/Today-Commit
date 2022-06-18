package com.evergreen.todaycommit.data.remote.api

import com.evergreen.todaycommit.data.model.GithubUserData
import retrofit2.http.GET

interface GithubApi {
    @GET("/user")
    fun getUser(): GithubUserData
}