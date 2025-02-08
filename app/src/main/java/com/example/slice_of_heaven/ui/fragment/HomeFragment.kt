package com.example.slice_of_heaven.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.slice_of_heaven.R
import com.example.slice_of_heaven.adapter.PopularAdapter
import com.example.slice_of_heaven.databinding.FragmentClientHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding:FragmentClientHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentClientHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)



        val foodName = listOf("Meat Lover Pizza", "Hawaiian Pizza", " BBQ Chicken Pizza", "Tandoori Pizza")
        val foodPrice = listOf("Rs 850", "Rs 750", "Rs 950", "Rs 850")
        val popularFoodImage = listOf(
            R.drawable.meatlover,
            R.drawable.hawaiian,
            R.drawable.bbqchicken,
            R.drawable.tandoori
        )

        val adapter = PopularAdapter(foodName, foodPrice, popularFoodImage)
        binding.PopularReacylerView.layoutManager=LinearLayoutManager(requireContext())
        binding.PopularReacylerView.adapter=adapter

    }


    companion object {

    }
}