package com.example.photos.repository.remotesource

import com.example.photos.repository.remotesource.model.Photo
import com.example.photos.repository.remotesource.service.PhotosAPI
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PhotosRemoteImpl(private val photosAPI: PhotosAPI): PhotosRemote {

    companion object {
        fun create(url: String): PhotosRemote {
            val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val apiService = retrofit.create(PhotosAPI::class.java)
            return PhotosRemoteImpl(apiService)
        }
    }

    override suspend fun getPhotos(): Response<List<Photo>> =
        photosAPI.getPhotos()
}