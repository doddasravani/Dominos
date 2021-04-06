package com.example.photos

import android.app.Activity
import android.app.Application
import com.example.photos.dagger.DaggerPhotosComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class PhotosApplication: Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()

        DaggerPhotosComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }
}