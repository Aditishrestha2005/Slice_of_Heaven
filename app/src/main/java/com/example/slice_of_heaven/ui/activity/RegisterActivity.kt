package com.example.slice_of_heaven.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.slice_of_heaven.R
import com.example.slice_of_heaven.databinding.ActivityRegisterBinding
import com.example.slice_of_heaven.model.UserModel
import com.example.slice_of_heaven.repository.UserRepositoryImpl
import com.example.slice_of_heaven.viewmodel.UserViewModel

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding

    lateinit var userViewModel:UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var repo = UserRepositoryImpl()
        userViewModel = UserViewModel(repo)

        binding.SignupBtn.setOnClickListener {

            var email = binding.registerEmail.text.toString()
            var password = binding.registerPassword.text.toString()
            var username = binding.registerusername.text.toString()
            var contact = binding.registerContact.text.toString()

            userViewModel.signup(email, password) { success, message, userId ->
                if (success) {
                    var userModel = UserModel(
                        userId,
                        username,
                        contact, email
                    )
                    userViewModel.addUserToDatabase(userId, userModel) { success, message ->
                        if (success) {
                            Toast.makeText(
                                this@RegisterActivity,
                                message, Toast.LENGTH_LONG
                            ).show()
                        } else {
                            Toast.makeText(
                                this@RegisterActivity,
                                message, Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                } else {
                    Toast.makeText(
                        this@RegisterActivity,
                        message, Toast.LENGTH_LONG
                    ).show()
                }
            }


            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }
}
