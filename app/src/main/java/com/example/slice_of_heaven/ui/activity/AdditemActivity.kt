
package com.example.slice_of_heaven.ui.activity

import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.slice_of_heaven.R
import com.example.slice_of_heaven.databinding.ActivityAdditemBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AdditemActivity : AppCompatActivity() {


    private lateinit var  foodName:String
    private lateinit var  foodPrice:String
    private lateinit var  foodDescription:String
    private lateinit var  foodIngredient:String
    private  var  foodImageUri: Uri?=null

    //FIREBASE
    private lateinit var auth:FirebaseAuth
    private lateinit var database: FirebaseDatabase

    private val binding:ActivityAdditemBinding by lazy {
        ActivityAdditemBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)



        auth = FirebaseAuth.getInstance()
        database= FirebaseDatabase.getInstance()



        binding.AddItemBtn.setOnClickListener{
            foodName=binding.FoodName.text.toString().trim()
            foodPrice=binding.FoodPrice.text.toString().trim()
            foodDescription=binding.descriptions.text.toString().trim()
            foodIngredient=binding.ingredients.text.toString().trim()

            if (!(foodName.isBlank()||foodPrice.isBlank()||foodDescription.isBlank()||foodIngredient.isBlank())){
                uploadData()
                Toast.makeText(this,"Item Added Successfully",Toast.LENGTH_LONG).show()
                finish()

            }else{
                Toast.makeText(this,"Fill all the details",Toast.LENGTH_LONG).show()
                finish()

            }
        }
        binding.selectImage.setOnClickListener {
            pickImage.launch("image/*")
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

    private fun uploadData() {

        val menuRef: DatabaseReference=database.getReference("menu")

        val menuItemKey:String?=menuRef.push().key



    }


    private val pickImage=registerForActivityResult(ActivityResultContracts.GetContent()){uri ->
        if (uri != null)
        {
            binding.selectedImage.setImageURI(uri)
        }
    }
}