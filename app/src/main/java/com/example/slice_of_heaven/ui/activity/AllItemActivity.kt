package com.example.slice_of_heaven.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.slice_of_heaven.R
import com.example.slice_of_heaven.adapter.AdditemAdapter
import com.example.slice_of_heaven.databinding.ActivityAllItemBinding

class AllItemActivity : AppCompatActivity() {
    private val binding: ActivityAllItemBinding by lazy {
        ActivityAllItemBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        // Convert immutable lists to mutable lists
        val menuFoodName = mutableListOf("Cheese Pizza", "Veggie Pizza", "Meat Lover Pizza", "Margherita Pizza", "BBQ Chicken Pizza", "Hawaiian Pizza", "Tandoori Pizza", "Paneer Pizza", "Bacon Pizza", "Pepperoni Pizza")
        val menuFoodPrice = mutableListOf("Rs 650", "Rs 750", "Rs 1050", "Rs 750", "Rs 950", "Rs 750", "Rs 850", "Rs 850", "Rs950", "Rs950")
        val menuImage = mutableListOf(
            R.drawable.cheese,
            R.drawable.veggie,
            R.drawable.meatlover,
            R.drawable.margarita,
            R.drawable.bbqchicken,
            R.drawable.hawaiian,
            R.drawable.tandoori,
            R.drawable.paneer,
            R.drawable.bacon,
            R.drawable.pepperoni
        )
        binding.backButton.setOnClickListener {
            finish()
        }

        val adapter = AdditemAdapter(menuFoodName, menuFoodPrice, menuImage)

        binding.allmenuRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.allmenuRecyclerView.adapter = adapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}