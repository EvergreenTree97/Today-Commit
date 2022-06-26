package com.evergreen.todaycommit.ui

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel()
){
    Button(onClick = { viewModel.fetchUser() }) {
        Text("test")
    }
}