package com.example.photos.repository

import com.example.photos.repository.remotesource.model.Photo
import java.lang.Exception

sealed class Result {
    data class Success(val photos: List<Photo>?): Result()
    data class Error(val exception: PhotosException): Result()
}

data class PhotosException(
    val errorMessage: String
): Exception()