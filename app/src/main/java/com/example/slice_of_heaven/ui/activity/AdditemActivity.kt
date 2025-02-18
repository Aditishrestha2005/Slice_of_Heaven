
package com.example.slice_of_heaven.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.slice_of_heaven.R
import com.example.slice_of_heaven.databinding.ActivityAdditemBinding

class AdditemActivity : AppCompatActivity() {
    private val binding:ActivityAdditemBinding by lazy {
        ActivityAdditemBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.selectImage.setOnClickListener{
            pickimage.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))

        }
        binding.backButton.setOnClickListener {
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    val pickimage=registerForActivityResult(ActivityResultContracts.PickVisualMedia()){uri ->
        if (uri != null)
        {
            binding.selectedImage.setImageURI(uri)
        }
    }
}