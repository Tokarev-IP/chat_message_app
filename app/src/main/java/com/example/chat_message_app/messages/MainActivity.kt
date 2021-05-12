package com.example.chat_message_app.messages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chat_message_app.R
import com.example.chat_message_app.auth.AuthActivity
import com.example.chat_message_app.eventListener.ChildEventListen
import com.example.chat_message_app.eventListener.EventListen
import com.google.firebase.auth.FirebaseAuth
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

        val recyclerView = findViewById<RecyclerView>(R.id.message_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MessagesAdapter()

        fireDB.addValueEventListener(eventListener)
        fireDB.addChildEventListener(childEventListener)

        sendButton.setOnClickListener {
            fireDB.push().setValue(editTextMessage.text.toString().trim())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.exit_menu -> {
                FirebaseAuth.getInstance().signOut()
                startActivity(Intent(this, AuthActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}