package com.example.pinterestclone.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

object ApiClient {
    //var BASE_URL = "https://6221a8a8afd560ea69b618b5.mockapi.io/android/"
    var BASE_URL = "https://api.unsplash.com/"


    private val client = getClient()
    private val retrofit = getRetrofit(client)

    fun getRetrofit(client: OkHttpClient): Retrofit{
        val build = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(client)
            .build()
        return build
    }

    fun <T> createService(service: Class<T>): T {
        return retrofit.create(service)
    }

    fun getClient(): OkHttpClient = OkHttpClient.Builder()
    .connectTimeout(60, TimeUnit.SECONDS)
    .readTimeout(60, TimeUnit.SECONDS)
    .addInterceptor(HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    })
    .addInterceptor(Interceptor { chain ->
        val builder = chain.request().newBuilder()
        builder.header("Authorization", "Client-ID 5tjJB8-tWvty3Ob6IWJdQaiZyiufHkGS4JISDRVTSGw")
        chain.proceed(builder.build())
    })
    .build()

    fun <T> createServiceWithAuth(service: Class<T>?): T {
        val newClient =
            client.newBuilder().addInterceptor(object : Interceptor {
                @Throws(IOException::class)
                override fun intercept(chain: Interceptor.Chain): Response {
                    var request = chain.request()
                    val builder = request.newBuilder()
                    builder.addHeader("Authorization", "Client-ID 5tjJB8-tWvty3Ob6IWJdQaiZyiufHkGS4JISDRVTSGw")
                    request = builder.build()
                    return chain.proceed(request)
                }
            }).build()
        val newRetrofit = retrofit.newBuilder().client(newClient).build()
        return newRetrofit.create(service)
    }
}