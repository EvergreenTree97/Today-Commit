package com.evergreen.todaycommit.data

import com.evergreen.todaycommit.util.Utils

object GithubApiResponseDummy {
    val users = Utils.readResourceString("githubapi/users-response.json")
}