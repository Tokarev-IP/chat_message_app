package com.example.chat_message_app.eventListener

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class EventListen: ValueEventListener {
    override fun onDataChange(snapshot: DataSnapshot) {
        Log.d("EVENT", snapshot.value.toString())
    }

    override fun onCancelled(error: DatabaseError) {
        Log.d("EVENT", error.toString())
    }
}