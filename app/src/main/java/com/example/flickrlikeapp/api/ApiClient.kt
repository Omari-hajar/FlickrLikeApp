package com.example.flickrlikeapp.api


import com.example.flickrlikeapp.data.Data
import retrofit2.Response

class ApiClient (private val apiInterface: ApiInterface){

//    suspend fun getPhotos(text: String): Response<Data>{
//        return apiInterface.getPhotos(text)
//    }

    suspend fun getPhotos(text: String): Response<Data>{
        return apiInterface.getPhotosList(text)
    }

}