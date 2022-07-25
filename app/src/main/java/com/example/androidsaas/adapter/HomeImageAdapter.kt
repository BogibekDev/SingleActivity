package com.example.androidsaas.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidsaas.databinding.ItemImageBinding
import com.example.androidsaas.model.ResponseHomeImages
import com.squareup.picasso.Picasso


class HomeImageAdapter(): RecyclerView.Adapter<HomeImageAdapter.HomeViewHolder>() {

    private var images: ArrayList<ResponseHomeImages> = ArrayList()

    inner class HomeViewHolder(private val binding: ItemImageBinding): RecyclerView.ViewHolder(binding.root) {
       fun bind(image: ResponseHomeImages) {
           Picasso.get().load(image.urls.thumb).into(binding.image)
       }
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val image = images[position]
        holder.bind(image)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    fun submitData(images: ArrayList<ResponseHomeImages>) {
        this.images.addAll(images)
        notifyDataSetChanged()
    }
}