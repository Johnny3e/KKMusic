package com.johnny3e.kkmusic

import android.content.Context
import com.johnny3e.kkmusic.data.repo.KKRepo
import com.johnny3e.kkmusic.data.src.local.PreferenceDataStore
import com.johnny3e.kkmusic.data.src.remote.AuthenticationApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class AppContainer(context: Context) {

    val viewModelFactory: AppViewModelFactory by lazy { AppViewModelFactory(kkRepo) }

    private val kkRepo by lazy { KKRepo(authenticationApi, pref, appScope) }
    private val authenticationApi by lazy { AuthenticationApi.create() }
    private val pref by lazy { PreferenceDataStore(context) }
    private val appScope = CoroutineScope(SupervisorJob())

}