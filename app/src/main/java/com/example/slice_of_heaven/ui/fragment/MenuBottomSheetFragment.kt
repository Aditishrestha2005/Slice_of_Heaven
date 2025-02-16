package com.example.slice_of_heaven.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.slice_of_heaven.R
import com.example.slice_of_heaven.adapter.MenuAdapter
import com.example.slice_of_heaven.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MenuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentMenuBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View  {
        binding = FragmentMenuBottomSheetBinding.inflate(inflater, container, false)
        binding.backBtn.setOnClickListener {
            dismiss()
        }
        val menuitemName = listOf("Cheese Pizza", "Veggie Pizza", "Meat Lover Pizza", "Margherita Pizza", "BBQ Chicken Pizza", "Hawaiian Pizza", "Tandoori Pizza", "Paneer Pizza", "Bacon Pizza", "Pepperoni Pizza")
        val menufoodprice = listOf("Rs 650", "Rs 750", "Rs 1050", "Rs 750", "Rs 950", "Rs 750", "Rs 850", "Rs 850", "Rs 950", "Rs 950")
        val menuImage = listOf(
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

        val adapter = MenuAdapter(
            ArrayList(menuitemName),
            ArrayList(menufoodprice),
            ArrayList(menuImage),requireContext()
        )
        binding.menuRecylerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecylerView.adapter = adapter
        return binding.root
    }

    companion object {
        // Companion object content if needed
    }
}