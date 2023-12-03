package com.johnny3e.kkmusic.data.src.remote

import com.johnny3e.kkmusic.BuildConfig
import com.johnny3e.kkmusic.model.http.AccessToken
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import timber.log.Timber

interface AuthenticationApi {

    @FormUrlEncoded
    @POST(ApiEndPoint.token)
    suspend fun clientCredential(
        @Field("grant_type") grantType: String,
        @Field("client_id") clientId: String,
        @Field("client_secret") clientSecret: String
    ): AccessToken

    companion object {

        fun create(): AuthenticationApi {

            val okHttpClient = OkHttpClient.Builder().apply {
                if (BuildConfig.DEBUG) {
                    val loggingInterceptor = HttpLoggingInterceptor {
                        Timber.tag("http").d(it)
                    }.setLevel(HttpLoggingInterceptor.Level.BODY)
                    addInterceptor(loggingInterceptor)
                }
            }.build()

            val retrofit = Retrofit.Builder()
                .baseUrl(ApiEndPoint.authBaseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(AuthenticationApi::class.java)
        }
    }
}