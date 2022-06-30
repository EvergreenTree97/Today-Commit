package com.evergreen.todaycommit.presentation.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.evergreen.todaycommit.domain.usecase.GetGithubUserUseCase
import com.evergreen.todaycommit.firebase.FirebaseMessagingServiceImpl
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val githubUserUseCase: GetGithubUserUseCase
) : ViewModel() {

    fun fetchUser(){
        viewModelScope.launch(Dispatchers.IO) {
            githubUserUseCase("EvergreenTree97").onSuccess {
                Log.d("성공", "fetchUser: ${it.userName}")
            }.onFailure {
                Log.d("실패", "fetchUser: ${it.localizedMessage} ")
            }
        }
    }
}