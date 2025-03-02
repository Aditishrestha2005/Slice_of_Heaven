package com.example.slice_of_heaven.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.slice_of_heaven.R
import com.example.slice_of_heaven.adapter.PendingOrderAdapter
import com.example.slice_of_heaven.databinding.ActivityPendingorderBinding
import com.example.slice_of_heaven.databinding.PendingOrderItemsBinding

class PendingorderActivity : AppCompatActivity() {
    private lateinit var binding :ActivityPendingorderBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPendingorderBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.backBtn.setOnClickListener {
            finish()
        }
            val orderedcustomerName = arrayListOf(
                "John Doe",
                "Jane Smith",
                "Mike Johnson"
            )

            val orderedQuantity = arrayListOf(
                "9",
                "7",
                "6"
            )

            val orderedFoodImage = arrayListOf(R.drawable.cheese,R.drawable.veggie,R.drawable.paneer)

            val adapter = PendingOrderAdapter(orderedcustomerName, orderedQuantity,orderedFoodImage, this)
            binding.pendingorderRecylerView.adapter = adapter
            binding.pendingorderRecylerView.layoutManager = LinearLayoutManager(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}