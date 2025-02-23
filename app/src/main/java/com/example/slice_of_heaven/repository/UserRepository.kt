package com.example.slice_of_heaven.repository

import com.example.slice_of_heaven.model.UserModel
import com.google.firebase.auth.FirebaseUser

interface UserRepository {
    fun login(username:String,password:String,callback:(Boolean,String)->Unit)
    fun signup(username:String,password:String,callback:(Boolean,String,String)->Unit)
    fun addUserToDatabase(userId:String,userModel: UserModel,callback: (Boolean, String) -> Unit)
    fun forgetPassword (username:String,callback: (Boolean, String) -> Unit)
    fun getCurretntUser(): FirebaseUser?

}
