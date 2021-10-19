package com.example.flickrlikeapp.api

import com.example.flickrlikeapp.data.Data
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    //// https://api.flickr.com/services/rest/?method=flickr.photos.search&format=json&nojsoncallback=1&text=nature&api_key=88ed752d829d7392e0975984277076ce

    @GET("?method=flickr.photos.search&format=json&nojsoncallback=1&text=nature&api_key=88ed752d829d7392e0975984277076ce")

//    suspend fun getPhotos(
//        @Path("text") text: String
//    ): Response<Data>
    suspend fun getPhotosList(
        @Query("text") text: String
    ) : Response<Data>
}