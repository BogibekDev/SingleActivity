package com.example.pinterestappclone.model

data class User (
    val id: String,
    val updatedAt: String,
    val username: String,
    val name: String,
    val firstName: String,
    val lastName: String? = null,
    val twitterUsername: String? = null,
    val portfolioURL: String? = null,
    val bio: String? = null,
    val location: String? = null,
    val instagramUsername: String? = null,
    val totalCollections: Long,
    val totalLikes: Long,
    val totalPhotos: Long,
    val acceptedTos: Boolean,
    val forHire: Boolean,
)
