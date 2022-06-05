package com.bhargav.clinicare.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.bhargav.clinicare.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

const val USERS: String = "users"

private const val TAG = "Repository"

class Repository {
    companion object {
        private var repository: Repository? = null
        fun getInstance(): Repository {
            if (repository == null) {
                synchronized(Repository::class.java) {
                    if (repository == null) {
                        repository = Repository()
                    }
                }
            }
            return repository!!
        }
    }

    private val auth = FirebaseAuth.getInstance()
    var uid = auth.currentUser?.uid
    private val firestore = FirebaseFirestore.getInstance()
    var userRef: DocumentReference? = null

    val userData: MutableLiveData<User> = MutableLiveData()

    fun init() {
        uid = auth.currentUser?.uid
        userRef = firestore.collection(USERS).document(uid!!)
        getUserData()
    }

    private fun getUserData() {
        userRef?.addSnapshotListener { value, error ->
            if (error == null && value != null) {
                if (value.data == null) setNewUser()

                userData.value = if (value.data != null) value.toObject(User::class.java) else User(
                    email = auth.currentUser?.email!!,
                )
                Log.d(TAG, "getUserData: ${value.data}")
            }
        }
    }

    init {
        if (auth.currentUser != null) init()
    }

    fun setNewUser(user: User = User()) {
        firestore.collection(USERS).document(auth.currentUser?.uid!!).set(user)
    }
}
