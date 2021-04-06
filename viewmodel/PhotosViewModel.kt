package com.example.photos.viewmodel

import androidx.lifecycle.LiveData
import com.example.photos.repository.PhotosRepository

class PhotosViewModel(private val repository: PhotosRepository) {

    fun getPhotos() : LiveData<Result> =
        repository.getPhotos()
}

// create view model factory
