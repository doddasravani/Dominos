package com.example.photos.dagger

import android.app.Application
import android.os.Build
import com.example.photos.PhotosApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(modules = [PhotosModule::class, ActivityModule::class,
AndroidSupportInjectionModule::class])
@Singleton
interface PhotosComponent {

    fun inject(photosApplication: PhotosApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): PhotosComponent
    }
}