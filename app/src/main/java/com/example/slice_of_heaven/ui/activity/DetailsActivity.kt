package com.example.slice_of_heaven.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.slice_of_heaven.R
import com.example.slice_of_heaven.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity(){
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foodName = intent.getStringExtra("menufooditem")
        val foodImage = intent.getIntExtra("menuImage",0)


        binding.detailFoodName.text=foodName
        binding.DetailFoodImage.setImageResource(foodImage)

        binding.imageButton.setOnClickListener{
            finish()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}