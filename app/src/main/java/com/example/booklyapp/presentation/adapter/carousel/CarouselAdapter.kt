package com.example.booklyapp.presentation.adapter.carousel

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.example.booklyapp.databinding.ItemViewPagerBinding
import com.example.booklyapp.domain.models.CarouselSellers

class CarouselAdapter : RecyclerView.Adapter<CarouselViewHolder>() {

    var list = emptyList<CarouselSellers>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemViewPagerBinding.inflate(layoutInflater, parent, false)
        return CarouselViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        val item = list[position]
        holder.binding.imageView.load(item.image) {
            crossfade(750)
            scale(Scale.FILL)
        }
    }

    override fun getItemCount() = list.size

}


