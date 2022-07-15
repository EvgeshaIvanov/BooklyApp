package com.example.booklyapp.presentation.adapter.similar

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.example.booklyapp.databinding.ItemDetailBinding
import com.example.booklyapp.domain.models.SimilarBooks

class SimilarBooksAdapter : RecyclerView.Adapter<SimilarBooksViewHolder>() {

    var list = emptyList<SimilarBooks>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimilarBooksViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemDetailBinding.inflate(layoutInflater, parent, false)
        return SimilarBooksViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SimilarBooksViewHolder, position: Int) {
        val item = list[position]
        holder.binding.imageView.load(item.image) {
            scale(Scale.FILL)
        }
    }

    override fun getItemCount() = list.size
}


