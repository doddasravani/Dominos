package com.example.photos.dagger

import com.example.photos.repository.localsource.PhotosLocal
import com.example.photos.repository.remotesource.PhotosRemote
import com.example.photos.repository.remotesource.PhotosRemoteImpl
import com.example.photos.repository.remotesource.model.Constants
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PhotosModule {

    @Provides
    @Singleton
    fun providesRemoteSource(): PhotosRemote =
        PhotosRemoteImpl.create(Constants.BASE_URL)


}