package com.example.photos.repository.localsource

import com.example.photos.repository.remotesource.model.Photo

interface PhotosLocal {

    suspend fun insertPhotos(photos: List<Photo>)

    suspend fun fetchPhotos(): List<Photo>

    suspend fun clearPhotos()
}