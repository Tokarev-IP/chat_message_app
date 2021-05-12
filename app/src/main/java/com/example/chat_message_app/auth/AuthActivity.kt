package com.example.chat_message_app.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import com.example.chat_message_app.messages.MainActivity
import com.example.chat_message_app.R
import com.google.firebase.auth.FirebaseAuth

class AuthActivity : AppCompatActivity() {

    private val withEmailAndPassword = WithEmailAndPassword()
    private val hasSign = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val progressBar: ProgressBar = findViewById(R.id.progress_bar)
//        progressBar.visibility = View.VISIBLE

        if (hasSign.currentUser != null) {
            startActivity(Intent(this, MainActivity::class.java))
//            progressBar.visibility = View.INVISIBLE
        }

        val loginEdit: EditText = findViewById(R.id.login_edit_text)
        val passwordEdit: EditText = findViewById(R.id.password_edit_text)

        val regButton: Button = findViewById(R.id.reg_button)
        val loginButton: Button = findViewById(R.id.login_button)

        regButton.setOnClickListener {
            if (loginEdit.text != null && passwordEdit.text != null)
                withEmailAndPassword.createUserWithEmailAndPassword(loginEdit.text.toString(), passwordEdit.text.toString())
        }

        loginButton.setOnClickListener {
            if (loginEdit.text != null && passwordEdit.text != null)
                withEmailAndPassword.signInWithEmailAndPassword(loginEdit.text.toString(), passwordEdit.text.toString())
        }
    }
}