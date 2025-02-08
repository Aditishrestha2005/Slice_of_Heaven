package com.example.slice_of_heaven.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.slice_of_heaven.databinding.CartItemBinding

class CartAdapter (private val CartItems:MutableList<String>,private val CartItemPrice:MutableList<String>,private val CartImage:MutableList<Int>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private val itemQuantities = IntArray(CartItems.size) { 1 }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }


    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = CartItems.size

    inner class CartViewHolder(private val binding: CartItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity = itemQuantities[position]
                cartfoodname.text = CartItems[position]
                cartfoodprice.text = CartItemPrice[position]
                cartImage.setImageResource(CartImage[position])
                cartitemquantity.text = quantity.toString()


                minusBtn.setOnClickListener {
                    decreaseQuantity(position)


                }
                addBtn.setOnClickListener {
                    increaseQuantity(position)

                }
                deleteBtn.setOnClickListener {
                    val itemPosition= adapterPosition
                    if(itemPosition != RecyclerView.NO_POSITION){
                        deleteItem(itemPosition)
                    }


                }
            }
        }
        private fun increaseQuantity(position: Int) {
    if (itemQuantities[position] < 10) {
        itemQuantities[position]++
        binding.cartitemquantity.text = itemQuantities[position].toString()
    }

}
private fun decreaseQuantity(position: Int) {
    if (itemQuantities[position] > 1) {
        itemQuantities[position]--
        binding.cartitemquantity.text = itemQuantities[position].toString()

    }
}
    private fun deleteItem(position: Int) {
        CartItems.removeAt(position)
        CartImage.removeAt(position)
        CartItemPrice.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, CartItems.size)

    }
}

}