package com.example.slice_of_heaven.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.slice_of_heaven.R
import com.example.slice_of_heaven.databinding.ActivityNavigationBinding

class NavigationActivity : AppCompatActivity() {
    lateinit var binding: ActivityNavigationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
      binding=ActivityNavigationBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            val fragmentManager: FragmentManager =supportFragmentManager
            val fragmentTransaction: FragmentTransaction =fragmentManager.beginTransaction()
            val firstFragment=firstFragment()

            fragmentTransaction.replace(R.id.frameLayout,firstFragment)
            fragmentTransaction.commit()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}