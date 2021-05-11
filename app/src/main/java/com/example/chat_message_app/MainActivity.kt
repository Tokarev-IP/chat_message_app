package com.example.chat_message_app

import android.media.MediaCas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import com.example.chat_message_app.eventListener.ChildEventListen
import com.example.chat_message_app.eventListener.EventListen
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    private val firedatabase = FirebaseDatabase.getInstance()
    private val fireDB = firedatabase.getReference("message")
    private val eventListener = EventListen()
    private val childEventListener = ChildEventListen()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextMessage: EditText = findViewById(R.id.message_edit_text)
        val sendButton: ImageButton = findViewById(R.id.send_message_button)

        fireDB.addValueEventListener(eventListener)
        fireDB.addChildEventListener(childEventListener)

        sendButton.setOnClickListener {
            fireDB.push().setValue(editTextMessage.text.toString())
        }
    }
}