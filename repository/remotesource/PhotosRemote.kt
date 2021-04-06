package com.example.photos.repository.remotesource

import com.example.photos.repository.remotesource.model.Photo
import retrofit2.Response

interface PhotosRemote {

    suspend fun getPhotos(): Response<List<Photo>>
}