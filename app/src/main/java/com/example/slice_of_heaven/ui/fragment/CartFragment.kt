package com.example.slice_of_heaven.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.slice_of_heaven.R
import com.example.slice_of_heaven.databinding.FragmentCartBinding

class CartFragment : Fragment() {
    private lateinit var binidng:FragmentCartBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binidng = FragmentCartBinding.inflate(inflater, container, false)



        val cartfoodname = listOf("Cheese Pizza", "Veggie Pizza", "Meat Lover Pizza","Hawaiian Pizza")
        val cartfoodprice = listOf("Rs 650","Rs 550","Rs 850","Rs 750")
        val cartImage = listOf(
            R.drawable.c

        )
        return binidng.root
    }

    companion object {

    }
}