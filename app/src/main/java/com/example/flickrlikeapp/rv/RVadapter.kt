package com.example.flickrlikeapp.rv

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flickrlikeapp.ImageView
import com.example.flickrlikeapp.databinding.PhotoBinding

class RVadapter(val context: Context, val list: ArrayList<RvData>): RecyclerView.Adapter<RVadapter.ViewHolder>() {
    class ViewHolder(val binding: PhotoBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = PhotoBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        val image = holder.binding.ivImage
        holder.binding.apply {
            tvTitle.text = item.title


        }
       Glide
            .with(context)
            .load(item.imageLink)
            .centerCrop()
            .into(image)

        holder.binding.root.setOnClickListener {
            val intent = Intent(context, ImageView::class.java)
            intent.putExtra("title", item.title)
            intent.putExtra("image",item.imageLink)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}