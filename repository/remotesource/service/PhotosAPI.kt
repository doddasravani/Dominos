package com.example.photos.repository.remotesource.service

import com.example.photos.repository.remotesource.model.Photo
import retrofit2.Response
import retrofit2.http.GET

interface PhotosAPI {

    @GET("list")
    suspend fun getPhotos(): Response<List<Photo>>
}