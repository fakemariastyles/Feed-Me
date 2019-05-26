package com.mmb.feed_me.ui.mvvm.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mmb.feed_me.R
import com.mmb.feed_me.ui.mvvm.model.Post

class PostViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
    private val userId = itemView.findViewById<TextView>(R.id.userId)
    private val title = itemView.findViewById<TextView>(R.id.title)
    private val body = itemView.findViewById<TextView>(R.id.body)
    fun bind(post: Post){
        userId.text = post.userId.toString()
        title.text = post.title
        body.text = post.body
    }

}