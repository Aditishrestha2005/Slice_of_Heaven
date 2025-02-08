package com.example.slice_of_heaven.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.slice_of_heaven.databinding.PopularItemsBinding

class PopularAdapter (private val items:List<String>,private val price:List<String>,private val image:List<Int>) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
      return PopularViewHolder(PopularItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }


    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
      val item = items[position]
        val price=price[position]
        val images = image[position]
        holder.bind(item,price,images)
    }
    override fun getItemCount(): Int {
        return items.size
    }

    class PopularViewHolder (private val binding:PopularItemsBinding): RecyclerView.ViewHolder(binding.root){
        val imageView= binding.imageView5
        fun bind(item: String,price: String, images: Int) {
            binding.popularfooditem.text= item
            binding.pricepopular.text=price
            imageView.setImageResource(images)



        }

    }
}