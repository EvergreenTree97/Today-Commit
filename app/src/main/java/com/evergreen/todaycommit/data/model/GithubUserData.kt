package com.evergreen.todaycommit.data.model

import com.fasterxml.jackson.annotation.JsonProperty

data class GithubUserData(
    @JsonProperty("followers")
    val followers: Int
)