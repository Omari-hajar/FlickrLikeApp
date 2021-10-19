package com.example.flickrlikeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.flickrlikeapp.databinding.ActivityMainBinding
import com.example.flickrlikeapp.rv.RVadapter
import com.example.flickrlikeapp.rv.RvData
import com.example.flickrlikeapp.viewmodel.SharedViewModel

class MainActivity : AppCompatActivity() {
    val viewModel: SharedViewModel by lazy {
        //use viewModelProvider to fetch viewModel
        ViewModelProvider(this).get(SharedViewModel::class.java)
    }
    lateinit var list: ArrayList<RvData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list = arrayListOf()

        viewModel.refreshPhotosList("nature")

        binding.rvMain.layoutManager = GridLayoutManager(this, 2)
        val search = binding.svSearch
        search.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                list.clear()
                if (query != null) {
                    viewModel.refreshPhotosList(query)

                }else{
                    Toast.makeText(this@MainActivity,"Enter Something", Toast.LENGTH_LONG).show()
                }
                search.clearFocus()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })



       viewModel.photosLiveListData.observe(this){ response ->
           //check if response is null and return error message

           if (response == null ){
               Toast.makeText(this@MainActivity, "Unsuccessful network call!", Toast.LENGTH_LONG).show()
               return@observe
           }

           for (i in response.photos.photo){
               val owner = i.owner
               val secret = i.secret
               val farm = i.farm
               val id = i.id
               val title = i.title
               val server = i.server
               val imageLink =  "https://farm$farm.staticflickr.com/$server/${id}_$secret.jpg"
               list.add(RvData(i.title, "", imageLink))
           }
           binding.rvMain.adapter = RVadapter(this, list)
           binding.rvMain.adapter!!.notifyDataSetChanged()

       }

    }
}