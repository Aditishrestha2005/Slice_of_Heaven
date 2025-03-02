package com.example.slice_of_heaven.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.slice_of_heaven.R
import com.example.slice_of_heaven.databinding.ActivityLoginBinding
import com.example.slice_of_heaven.repository.UserRepositoryImpl
import com.example.slice_of_heaven.viewmodel.UserViewModel

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repo = UserRepositoryImpl()
        userViewModel = UserViewModel(repo)


        binding.btnlogin.setOnClickListener {
            val username = binding.editusername.text.toString()
            val password = binding.editpassword.text.toString()

            userViewModel.login(username, password) { success, message ->
                if (success) {
                    val selectedId = binding.radioGroup.checkedRadioButtonId

                    val intent = when (selectedId) {
                        R.id.UserRadio -> Intent(this@LoginActivity, NavigationActivity::class.java)
                        R.id.AdminRadio-> Intent(this@LoginActivity, AdminActivity::class.java)
                        else -> {
                            Toast.makeText(this@LoginActivity, "Please select User or Admin", Toast.LENGTH_LONG).show()
                            return@login
                        }
                    }
                    startActivity(intent)
                } else {
                    Toast.makeText(this@LoginActivity, message, Toast.LENGTH_LONG).show()
                }
            }
        }

        binding.btnSignUp.setOnClickListener {
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}