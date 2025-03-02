package com.example.slice_of_heaven.viewmodel


    import com.example.slice_of_heaven.model.UserModel
    import com.example.slice_of_heaven.repository.UserRepository
    import com.google.firebase.auth.FirebaseUser

    class UserViewModel(var repo: UserRepository) {

        fun login(
            username: String, password: String,
            callback: (Boolean, String) -> Unit
        ) {
            repo.login(username, password, callback)
        }


        fun signup(
            username: String, password: String,
            callback: (Boolean, String, String) -> Unit
        ) {
            repo.signup(username, password, callback)
        }

        fun addUserToDatabase(
            userId: String, userModel: UserModel,
            callback: (Boolean, String) -> Unit
        ) {
            repo.addUserToDatabase(userId, userModel, callback)
        }

        fun forgetPassword(
            email: String,
            callback: (Boolean, String) -> Unit
        ) {
            repo.forgetPassword(email, callback)
        }
        fun getCurrentUser():FirebaseUser?{
            return repo.getCurretntUser()
        }

    }

