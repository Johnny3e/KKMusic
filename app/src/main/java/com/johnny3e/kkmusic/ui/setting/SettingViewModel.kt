package com.johnny3e.kkmusic.ui.setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.johnny3e.kkmusic.data.repo.KKRepo
import kotlinx.coroutines.launch

class SettingViewModel(val kkRepo: KKRepo) : ViewModel() {

    fun logout() = viewModelScope.launch {
        kkRepo.logout()
    }
}