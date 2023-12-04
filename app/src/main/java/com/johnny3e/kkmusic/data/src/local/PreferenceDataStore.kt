package com.johnny3e.kkmusic.data.src.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map


private const val DATASTORE_FILE_NAME = "kkmusic_preference_data_store"

class PreferenceDataStore(private val context: Context) {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = DATASTORE_FILE_NAME)

    companion object {
        private val accessToken = stringPreferencesKey("token")
    }

    suspend fun setToken(tokenStr: String) {
        context.dataStore.edit { it[accessToken] = tokenStr }
    }

    val token: Flow<String> = context.dataStore.data.map { it[accessToken] ?: "" }.flowOn(Dispatchers.IO)

}