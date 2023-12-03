package com.johnny3e.kkmusic.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.johnny3e.kkmusic.data.repo.KKRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


data class LoginUiState(
    val loginSuccess: Boolean = false
)

class LoginViewModel(val kkRepo: KKRepo): ViewModel() {

    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState())
    val uiState = _uiState.asStateFlow()

    fun loginWithClientCredential(id: String, secret: String) = viewModelScope.launch {
        kkRepo.authClientCredential(id, secret)
        _uiState.update {
            it.copy(true)
        }
    }

}