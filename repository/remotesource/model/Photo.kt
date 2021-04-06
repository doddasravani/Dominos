package com.example.photos.repository.remotesource.model

import com.google.gson.annotations.SerializedName

data class Photo (
    val id: Int,
    val author: String,
    @SerializedName("author_url")
    val authorUrl: String
)