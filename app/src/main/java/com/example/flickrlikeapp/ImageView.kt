package com.example.flickrlikeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.flickrlikeapp.databinding.ActivityImageViewBinding

class ImageView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityImageViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("title")
        val imageLink = intent.getStringExtra("image")

        binding.tvSingleTitle.text = title

        Glide
            .with(this)
            .load(imageLink)
            .centerCrop()
            .into(binding.ivImageView)

        binding.btnBack.setOnClickListener {
            val intent = Intent(this@ImageView, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnFav.setOnClickListener {
            binding.btnFav.setBackgroundResource(R.drawable.heart2)
            val intent = Intent(this@ImageView, FavActivity::class.java)
            intent.putExtra("title", title)
            intent.putExtra("image", imageLink)
            startActivity(intent)
        }
    }
}