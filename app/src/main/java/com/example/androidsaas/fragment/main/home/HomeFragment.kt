package com.example.androidsaas.fragment.main.home


import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.androidsaas.R
import com.example.androidsaas.adapter.HomeImageAdapter
import com.example.androidsaas.model.ResponseHomeImages
import com.example.androidsaas.network.ApiService
import com.example.pinterestclone.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val adapter by lazy { HomeImageAdapter() }

    private lateinit var apiService: ApiService


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        apiService = ApiClient.createServiceWithAuth(ApiService::class.java)

        view.findViewById<RecyclerView>(R.id.rv_home).adapter = adapter

        apiPhotosList(1)

    }

    private fun apiPhotosList(page:Int) {

        apiService.getPhotos(page, 20).enqueue(object : Callback<List<ResponseHomeImages>> {
            override fun onResponse(
                call: Call<List<ResponseHomeImages>>,
                response: Response<List<ResponseHomeImages>>,
            ) {
                Log.d("response", response.body().toString())
                adapter.submitData(response.body()!! as ArrayList<ResponseHomeImages>)

            }

            override fun onFailure(call: Call<List<ResponseHomeImages>>, t: Throwable) {
            }
        })

    }
}