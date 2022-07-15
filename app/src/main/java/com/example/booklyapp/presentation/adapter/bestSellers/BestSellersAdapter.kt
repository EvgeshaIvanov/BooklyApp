package com.example.booklyapp.presentation.adapter.bestSellers

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.example.booklyapp.databinding.ItemBestSellerBinding
import com.example.booklyapp.domain.models.BestSellers

class BestSellersAdapter : RecyclerView.Adapter<BestSellersViewHolder>() {

    var clickOnBook: ((BestSellers) -> Unit)? = null

    var list = emptyList<BestSellers>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellersViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemBestSellerBinding.inflate(layoutInflater, parent, false)
        return BestSellersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BestSellersViewHolder, position: Int) {
        val item = list[position]
        with(holder.binding) {
            nameOfBookText.text = item.title
            imageView.load(item.image) {
                crossfade(750)
                scale(Scale.FILL)
            }
            authorNameText.text = item.author
            priceText.text = "${item.price} €"
            rateAmount.text = "(${item.rate.amount})"
            rateScoreText.text = item.rate.score.toString()
            itemBook.setOnClickListener {
                clickOnBook?.invoke(item)
            }
        }
    }

    override fun getItemCount() = list.size
}