package com.example.slice_of_heaven.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.slice_of_heaven.R
import com.example.slice_of_heaven.databinding.ActivityAdminBinding

class AdminActivity : AppCompatActivity() {
    private val binding: ActivityAdminBinding  by lazy{
        ActivityAdminBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

//        binding.viewallitem.setOnClickListener{
//            val intent = Intent(this,AllItemActivity::class.java)
//            startActivity(intent)
//        }

        binding.Logout.setOnClickListener{
            val intent=Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
        binding.Profile.setOnClickListener{
            val intent=Intent(this,ProfileActivity::class.java)
            startActivity(intent)
        }

        binding.viewallitem.setOnClickListener{
            val intent=Intent(this,AllItemActivity::class.java)
            startActivity(intent)
        }
        binding.pendingorderTextView.setOnClickListener{
            val intent=Intent(
                this,PendingorderActivity::class.java
            )
            startActivity(intent)
        }










        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}