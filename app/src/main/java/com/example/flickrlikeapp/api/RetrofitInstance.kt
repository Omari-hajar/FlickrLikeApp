package com.example.flickrlikeapp.api

import com.example.flickrlikeapp.api.Constants.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object RetrofitInstance {

    
    val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val apiInterface : ApiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }

    val apiClient = ApiClient(apiInterface)
}