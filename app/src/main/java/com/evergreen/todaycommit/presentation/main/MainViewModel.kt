package com.evergreen.todaycommit.presentation.main

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.evergreen.todaycommit.domain.model.GithubSkylineUser
import com.evergreen.todaycommit.domain.usecase.GetGithubSkylineUserUseCase
import com.evergreen.todaycommit.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val githubUserUseCase: GetGithubSkylineUserUseCase
) : BaseViewModel() {

    private val _githubUser = MutableStateFlow<GithubSkylineUser?>(null)
    val githubUser: StateFlow<GithubSkylineUser?>
        get() = _githubUser.asStateFlow()

    internal fun fetchUser() {
        viewModelScope.launch(Dispatchers.IO) {
            githubUserUseCase("evergreentree97").onSuccess {
                Log.d("성공", it.userName)
                _githubUser.emit(it)
            }.onFailure {
                Log.d("실패", it.localizedMessage)
                emitException(it)
            }
        }
    }
}