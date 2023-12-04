package com.johnny3e.kkmusic.data.repo

import com.johnny3e.kkmusic.data.src.local.PreferenceDataStore
import com.johnny3e.kkmusic.data.src.remote.AuthenticationApi
import com.johnny3e.kkmusic.model.ui.LoginStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class KKRepo(
    private val authApi: AuthenticationApi,
    private val pref: PreferenceDataStore,
    val appScope: CoroutineScope
) {

    private val tokenFlow = pref.token.stateIn(appScope, SharingStarted.Eagerly, null)
    private val token get() = tokenFlow.value ?: ""
    val loginStatus: Flow<LoginStatus> = tokenFlow.filterNotNull()
        .map { if (it.isNotEmpty()) LoginStatus.LogIn else LoginStatus.LogOut }


    private fun isTokenExpire(): Boolean {
        TODO()
    }

    // https://docs-zhtw.kkbox.codes/#overview--oauth-20
    suspend fun authClientCredential(clientId: String, clientSecret: String): Boolean {
        val accessToken =
            authApi.clientCredential("client_credentials", clientId, clientSecret).accessToken
        pref.setToken(accessToken)
        return true
    }

}