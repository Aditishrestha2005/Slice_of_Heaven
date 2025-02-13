package com.example.slice_of_heaven.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.slice_of_heaven.R
import com.example.slice_of_heaven.adapter.MenuAdapter
import com.example.slice_of_heaven.databinding.FragmentClientSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding:FragmentClientSearchBinding
    private lateinit var  adapter : MenuAdapter
    private val originalmenuitemName = listOf("Cheese Pizza", "Veggie Pizza", "Meat Lover Pizza", "Margherita Pizza", "BBQ Chicken Pizza", "Hawaiian Pizza", "Tandoori Pizza", "Paneer Pizza", "Bacon Pizza", "Pepperoni Pizza")
    private val originalmenufoodprice = listOf("Rs 650", "Rs 750", "Rs 1050", "Rs 750", "Rs 950", "Rs 750", "Rs 850", "Rs 850", "Rs 950", "Rs 950")
    private val originalmenuImage = listOf(
        R.drawable.cheese,
        R.drawable.veggie,
        R.drawable.meatlover,
        R.drawable.margarita,
        R.drawable.bbqchicken,
        R.drawable.hawaiian,
        R.drawable.tandoori,
        R.drawable.paneer,
        R.drawable.bacon,
        R.drawable.pepperoni,
    )


    private val filteredmenuitemName = mutableListOf<String>()
    private val filteredmenufoodprice = mutableListOf<String>()
    private val filteredmenuImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentClientSearchBinding.inflate(inflater,container,false)
        adapter = MenuAdapter(filteredmenuitemName,filteredmenufoodprice,filteredmenuImage)
        binding.menuRecylerView.layoutManager=LinearLayoutManager(requireContext())
        binding.menuRecylerView.adapter=adapter

        // set up for search view

        setupSearchView()
        // show all menu items
        showAllMenu()

        return binding.root
    }

    private fun showAllMenu() {
        filteredmenuitemName.clear()
        filteredmenufoodprice.clear()
        filteredmenuImage.clear()


        filteredmenuitemName.addAll(originalmenuitemName)
        filteredmenufoodprice.addAll(originalmenufoodprice)
        filteredmenuImage.addAll(originalmenuImage)

        adapter.notifyDataSetChanged()


    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true

            }
        })
       
    }

    private fun filterMenuItems(query: String) {
        filteredmenuitemName.clear()
        filteredmenufoodprice.clear()
        filteredmenuImage.clear()

        originalmenuitemName.forEachIndexed { index, itemName ->
            if (itemName.contains(query.toString(),ignoreCase=true)){
                filteredmenuitemName.add(itemName)
                filteredmenufoodprice.add(originalmenufoodprice[index])
                filteredmenuImage.add(originalmenuImage[index])

            }
        }
        adapter.notifyDataSetChanged()
    }


}