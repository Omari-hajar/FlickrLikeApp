package com.example.flickrlikeapp

import com.example.flickrlikeapp.api.RetrofitInstance
import com.example.flickrlikeapp.data.Data

class SharedRepository {

    suspend fun getPhotos(): Data? {
        val request = RetrofitInstance.apiClient.getPhotos()

        if (request.isSuccessful){
            return request.body()!!
        }
        return null
    }

}
