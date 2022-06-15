package com.evergreen.todaycommit.data.model

import com.fasterxml.jackson.annotation.JsonProperty

data class UserResponse(
    @field:JsonProperty("followers")
    val followers: Int
)