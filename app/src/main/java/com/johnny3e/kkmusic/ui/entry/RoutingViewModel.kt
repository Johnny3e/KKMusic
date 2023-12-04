package com.johnny3e.kkmusic.ui.entry

import androidx.lifecycle.ViewModel
import com.johnny3e.kkmusic.data.repo.KKRepo
import com.johnny3e.kkmusic.model.ui.LoginStatus
import kotlinx.coroutines.flow.Flow

class RoutingViewModel(
    private val kkRepo: KKRepo,
) : ViewModel() {

    val loginFlow: Flow<LoginStatus> = kkRepo.loginStatus
}