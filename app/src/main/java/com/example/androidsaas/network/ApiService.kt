package com.example.androidsaas.network

import com.example.androidsaas.model.ResponseHomeImages
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("photos")
    fun getPhotos(@Query("page") page: Int, @Query("per_page") per_page: Int): Call<List<ResponseHomeImages>>
}