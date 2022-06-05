package com.bhargav.clinicare.ui.screens.register

import androidx.lifecycle.ViewModel
import com.bhargav.clinicare.data.Repository
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.ExperimentalCoroutinesApi

class RegisterScreenViewModel : ViewModel() {
    private val repository: Repository = Repository.getInstance()

    fun createNewUser(
        email: String,
        password: String,
    ) = FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
        .addOnSuccessListener {
            Repository.getInstance().init()
            repository.setNewUser()
        }
}
