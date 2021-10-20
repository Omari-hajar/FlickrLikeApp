package com.example.flickrlikeapp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.flickrlikeapp.data.Data
import com.example.flickrlikeapp.databinding.ActivityFavBinding
import com.example.flickrlikeapp.rv.FavRVadapter
import com.example.flickrlikeapp.rv.RvData

class FavActivity : AppCompatActivity() {
    lateinit var list: ArrayList<RvData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityFavBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list=  arrayListOf()

        val title = intent.getStringExtra("title").toString()
        val imageLink = intent.getStringExtra("image").toString()

        list.add(RvData(title ,imageLink))


        binding.rvFavMain.adapter = FavRVadapter(this,list)
        binding.rvFavMain.layoutManager = LinearLayoutManager(this)
       // binding.rvFavMain.layoutManager = StaggeredGridLayoutManager(2 , StaggeredGridLayoutManager.VERTICAL)



    }


}