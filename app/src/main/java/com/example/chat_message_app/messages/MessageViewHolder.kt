package com.example.chat_message_app.messages

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chat_message_app.R

class MessageViewHolder(view: View): RecyclerView.ViewHolder(view) {

    internal val messageText: TextView = view.findViewById(R.id.message_text)
    internal val nameText: TextView = view.findViewById(R.id.name_text)
}