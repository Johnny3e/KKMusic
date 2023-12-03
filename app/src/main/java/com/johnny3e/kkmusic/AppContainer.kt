package com.johnny3e.kkmusic

import android.content.Context
import com.johnny3e.kkmusic.data.repo.KKRepo
import com.johnny3e.kkmusic.data.src.remote.AuthenticationApi

class AppContainer(context: Context) {

    val viewModelFactory: AppViewModelFactory by lazy { AppViewModelFactory(kkRepo) }

    private val kkRepo by lazy { KKRepo(authenticationApi) }
    private val authenticationApi by lazy { AuthenticationApi.create() }

}