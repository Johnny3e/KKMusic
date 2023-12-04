package com.johnny3e.kkmusic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.johnny3e.kkmusic.data.repo.KKRepo
import com.johnny3e.kkmusic.ui.LoginViewModel
import com.johnny3e.kkmusic.ui.entry.RoutingViewModel
import com.johnny3e.kkmusic.ui.setting.SettingViewModel


class AppViewModelFactory(
    private val kkRepo: KKRepo,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return when (modelClass) {
            LoginViewModel::class.java -> LoginViewModel(kkRepo) as T
            RoutingViewModel::class.java -> RoutingViewModel(kkRepo) as T
            SettingViewModel::class.java -> SettingViewModel(kkRepo) as T
            else -> throw IllegalArgumentException("not support")
        }
    }
}