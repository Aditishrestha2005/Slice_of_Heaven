package com.example.slice_of_heaven.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.slice_of_heaven.databinding.ItemItemBinding

class AdditemAdapter(
    private val MenuItemName: MutableList<String>,
    private val MenuItemPrice: MutableList<String>,
    private val MenuItemImage: MutableList<Int>
) : RecyclerView.Adapter<AdditemAdapter.AdditemViewHolder>() {
    private val itemQuantities = IntArray(MenuItemName.size) { 1 }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdditemAdapter.AdditemViewHolder {
        val binding = ItemItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AdditemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdditemAdapter.AdditemViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = MenuItemName.size

    inner class AdditemViewHolder(private val binding: ItemItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            binding.apply {
                val quantity = itemQuantities[position]
                FoodName.text = MenuItemName[position]
                FoodPrice.text = MenuItemPrice[position]
                FoodimageView.setImageResource(MenuItemImage[position])

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
            MenuItemName.removeAt(position)
            MenuItemImage.removeAt(position)
            MenuItemPrice.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, MenuItemName.size)
        }
    }
}