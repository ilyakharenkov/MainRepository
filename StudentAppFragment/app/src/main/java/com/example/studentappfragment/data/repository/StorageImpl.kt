package com.example.studentappfragment.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

private const val SETTINGS_KEY = "SETTINGS_KEY"

class StorageImpl(private val context: Context): Storage {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "student_app_fragment")

    override suspend fun save(name: String) {
        context.dataStore.edit {
            it[keyString()] = name
        }
    }

    override suspend fun read(): String? {
        return context.dataStore.data.first()[keyString()]
    }

    private fun keyString(): Preferences.Key<String> {
        return stringPreferencesKey(SETTINGS_KEY)
    }

}