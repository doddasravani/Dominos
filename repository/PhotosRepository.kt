package com.example.photos.repository

interface PhotosRepository {

    suspend fun getPhotos(): Result
}