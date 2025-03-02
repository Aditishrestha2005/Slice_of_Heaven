package com.example.slice_of_heaven.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.slice_of_heaven.databinding.ItemItemBinding
import com.example.slice_of_heaven.model.AllMenu

class MenutemAdapter(
    private val context:Context,
    private val menuList:MutableList<AllMenu>
) : RecyclerView.Adapter<MenutemAdapter.AdditemViewHolder>() {
    private val itemQuantities = IntArray(menuList.size) { 1 }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MenutemAdapter.AdditemViewHolder {
        val binding = ItemItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AdditemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenutemAdapter.AdditemViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = menuList.size

    inner class AdditemViewHolder(private val binding: ItemItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            binding.apply {
                val quantity = itemQuantities[position]
                val menuItem=menuList[position]
                val uriString=menuItem.foodImage
                val uri= Uri.parse(uriString)
                FoodName.text =menuItem.foodName
                FoodPrice.text =menuItem.foodPrice
//                FoodimageView.setImageResource(menuList[position])

                amount.text = quantity.toString()

                subtractBtn.setOnClickListener {
                    decreaseQuantity(position)
                }
                moreBtn.setOnClickListener {
                    increaseQuantity(position)
                }

                deleteButton.setOnClickListener {
                    deleteQuantity(position)
                }
            }
        }

        private fun increaseQuantity(position: Int) {
            if (itemQuantities[position] < 10) {
                itemQuantities[position]++
                binding.amount.text = itemQuantities[position].toString()
            }
        }

        private fun decreaseQuantity(position: Int) {
            if (itemQuantities[position] > 1) {
                itemQuantities[position]--
                binding.amount.text = itemQuantities[position].toString()
            }
        }

        private fun deleteQuantity(position: Int) {
            menuList.removeAt(position)
            menuList.removeAt(position)
            menuList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, menuList.size)
        }
    }
}