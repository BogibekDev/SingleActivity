package com.example.androidsaas.model

import com.example.pinterestappclone.model.User
import com.example.retrofitbestpractice.model.Urls
import java.io.Serializable

data class ResponseHomeImages(
    val id: String,
    val urls: Urls,
    val likes: Int,
    val views: Long,
    val downloads: Long,
    val color: String,
    val user: User
    ) : Serializable
