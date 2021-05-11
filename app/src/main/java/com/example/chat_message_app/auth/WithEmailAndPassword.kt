package com.example.chat_message_app.auth

import android.util.Log
import com.google.firebase.auth.FirebaseAuth

class WithEmailAndPassword{

private val auth: FirebaseAuth = FirebaseAuth.getInstance()

fun signInWithEmailAndPassword(login: String, password: String){
    auth.signInWithEmailAndPassword(login, password)
        .addOnCompleteListener {
            if (it.isSuccessful) {
                Log.d("TAG", "signInWithEmail:success")
            }
            else Log.d("TAG", "signInWithEmail:error", it.exception)
        }
}

fun createUserWithEmailAndPassword(login: String, password: String) {
    auth.createUserWithEmailAndPassword(login, password)
        .addOnCompleteListener {
            if (it.isSuccessful) {
                Log.d("TAG", "regInWithEmail:success")
            } else Log.d("TAG", "regInWithEmail:error", it.exception)
        }
}
}