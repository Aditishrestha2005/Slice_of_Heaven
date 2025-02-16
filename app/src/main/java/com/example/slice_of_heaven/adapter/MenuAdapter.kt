package com.example.slice_of_heaven.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.slice_of_heaven.databinding.MenuItemBinding
import com.example.slice_of_heaven.ui.activity.DetailsActivity

class MenuAdapter (private val menuItemsName:MutableList<String>,private val menuItemPrice:MutableList<String>,private val MenuItemsImage:MutableList<Int>, private val requireContext: Context ):RecyclerView.Adapter<MenuAdapter.MenuViewHolder>(){


private val itemClickListener: OnClickListener ?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MenuViewHolder(binding)
    }




    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)

    }
    override fun getItemCount(): Int =menuItemsName.size

    inner class MenuViewHolder (private val binding: MenuItemBinding):RecyclerView.ViewHolder(binding.root){

    init {
        binding.root.setOnClickListener {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                itemClickListener?.onItemClick(position)

            }
            //setonclicklistener to open details
            val intent = Intent(requireContext, DetailsActivity::class.java)
            intent.putExtra("menufooditem",menuItemsName.get(position))
            intent.putExtra("menuImage",MenuItemsImage.get(position))
            requireContext.startActivity(intent)

        }
    }

        fun bind(position: Int) {
            binding.apply {
                menufooditem.text = menuItemsName[position]
                menuprice.text = menuItemPrice[position]
                menuImage.setImageResource(MenuItemsImage[position])



            }

        }

    }

    interface OnClickListener{
        fun onItemClick(position: Int)

    }
}


