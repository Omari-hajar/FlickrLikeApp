package com.example.flickrlikeapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flickrlikeapp.data.Data
import kotlinx.coroutines.launch

class SharedViewModel: ViewModel() {

    private val repository = SharedRepository()


    //define _photo MutableLiveData = to modify data and only can be used within viewmodel

    private val _photosLiveData = MutableLiveData<Data?>()

    private val _photosLiveListData = MutableLiveData<Data>()

    //define photo LiveData = outward facing any layer that is using viewmodel would not be able to edit it
    // the users of viewmodel would only be able to use the info
    val photosLiveData: LiveData<Data?> = _photosLiveData

    val photosLiveListData: LiveData<Data> = _photosLiveListData

//
//    fun refreshPhotos(text: String){
//        //viewmodelscope is coroutine scope
//        viewModelScope.launch {
//
//            //get the info from the repository
//
//            val response = repository.getPhotos(text)
//
//            //add the response to mutablelivedata
//            _photosLiveData.postValue(response)
//        }
//    }

    fun refreshPhotosList(text: String){
        viewModelScope.launch {
            val response = repository.getPhotosList(text)

            _photosLiveListData.postValue(response.body())
        }
    }
}