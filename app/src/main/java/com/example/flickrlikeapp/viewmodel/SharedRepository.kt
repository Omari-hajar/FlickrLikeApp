package com.example.flickrlikeapp.viewmodel

import com.example.flickrlikeapp.api.RetrofitInstance
import com.example.flickrlikeapp.data.Data
import retrofit2.Response

class SharedRepository {
//    suspend fun getPhotos(text: String): Data? {
//        val request = RetrofitInstance.apiClient.getPhotos(text)
//
//        if (request.isSuccessful){
//            return request.body()!!
//        }
//        return null
//    }

    suspend fun getPhotosList(text: String): Response<Data> {
        return RetrofitInstance.apiClient.getPhotos(text)

    }
}