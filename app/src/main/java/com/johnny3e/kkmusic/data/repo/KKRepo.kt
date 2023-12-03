package com.johnny3e.kkmusic.data.repo

import com.johnny3e.kkmusic.data.src.remote.AuthenticationApi

class KKRepo(
    private val authApi: AuthenticationApi
) {

    private var accessToken: String = ""

    fun isLogin(): Boolean {
        TODO()
    }

    private fun isTokenExpire(): Boolean {
        TODO()
    }

    // https://docs-zhtw.kkbox.codes/#overview--oauth-20
    suspend fun authClientCredential(clientId: String, clientSecret: String): Boolean {
        accessToken = authApi.clientCredential("client_credentials", clientId, clientSecret).accessToken
        return true
    }

}