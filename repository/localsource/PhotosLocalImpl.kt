package com.example.photos.repository.localsource

import android.content.Context
import android.content.SharedPreferences
import com.example.photos.repository.remotesource.model.Photo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

const val PREFS_NAME = "photos_prefs"
const val PHOTOS_KEY = "photos"

class PhotosLocalImpl(context: Context, private var gson: Gson): PhotosLocal {

    private var prefs: SharedPreferences = context.applicationContext
        .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    override suspend fun insertPhotos(photos: List<Photo>) {
        val editor = prefs.edit()

        editor.putString(PHOTOS_KEY, gson.toJson(photos))
        editor.apply()
    }

    override suspend fun fetchPhotos(): List<Photo> {
        val serialization = prefs.getString(PHOTOS_KEY, null)
        if (!serialization.isNullOrEmpty()) {
            val type: Type = object : TypeToken<List<Photo>>() {}.type
            return gson.fromJson(serialization, type)
        }
        return listOf()
    }

    override suspend fun clearPhotos() {
        val editor = prefs.edit()
        editor.clear()
        editor.apply()
    }
}