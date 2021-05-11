package com.example.chat_message_app.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.chat_message_app.R

class AuthActivity : AppCompatActivity() {
    private val withEmailAndPassword = WithEmailAndPassword()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

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