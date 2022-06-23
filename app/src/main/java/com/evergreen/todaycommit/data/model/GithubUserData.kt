package com.evergreen.todaycommit.data.model

import com.fasterxml.jackson.annotation.JsonProperty

data class GithubUserData(
    @field:JsonProperty("followers")
    val followers: Int = 21
)