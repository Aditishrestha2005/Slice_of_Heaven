package com.example.slice_of_heaven.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.slice_of_heaven.R
import com.example.slice_of_heaven.databinding.ActivityNavigationBinding
import com.example.slice_of_heaven.ui.fragment.CartFragment
import com.example.slice_of_heaven.ui.fragment.HomeFragment
import com.example.slice_of_heaven.ui.fragment.ProfileFragment
import com.example.slice_of_heaven.ui.fragment.SearchFragment

class NavigationActivity : AppCompatActivity() {
    lateinit var binding: ActivityNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        binding =ActivityNavigationBinding.inflate(layoutInflater)
        val view= binding.root
        setContentView(view)


        replaceFragment(HomeFragment())

        binding.btnNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeFragment-> replaceFragment(HomeFragment())
                R.id.searchFragment->replaceFragment(SearchFragment())
                R.id.cartFragment ->replaceFragment(CartFragment())
                R.id.profileFragment ->replaceFragment(ProfileFragment())
                else -> {}
            }

            true
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager =
            supportFragmentManager
        val fragmentTransaction: FragmentTransaction =
            fragmentManager.beginTransaction()
        fragmentTransaction.replace(
            binding.frameLayout.id,
            fragment
        )
        fragmentTransaction.commit()
    }


}



