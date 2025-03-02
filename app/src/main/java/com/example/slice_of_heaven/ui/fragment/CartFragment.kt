package com.example.slice_of_heaven.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.slice_of_heaven.R
import com.example.slice_of_heaven.adapter.CartAdapter
import com.example.slice_of_heaven.databinding.FragmentCartBinding
import com.example.slice_of_heaven.ui.activity.PayOutActivity


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



        val cartfoodname = listOf("Cheese Pizza", "Veggie Pizza", "Meat Lover Pizza","Hawaiian Pizza"," BBQ Chicken Pizza","Tandoori Pizza",)
        val cartfoodprice = listOf("Rs 650","Rs 550","Rs 850","Rs 750","Rs 950","Rs 850")
        val cartImage = listOf(
            R.drawable.cheese,
            R.drawable.veggie,
            R.drawable.meatlover,
            R.drawable.paneer


        )

        val adapter= CartAdapter(ArrayList(cartfoodname),ArrayList(cartfoodprice),ArrayList(cartImage))
        binidng.cartRecyclerView.layoutManager=LinearLayoutManager(requireContext())
        binidng.cartRecyclerView.adapter=adapter
        binidng.proceedBtn.setOnClickListener{
            val intent=Intent(requireContext(),PayOutActivity::class.java)
            startActivity(intent)
        }





        return binidng.root

    }

    companion object {

    }
}