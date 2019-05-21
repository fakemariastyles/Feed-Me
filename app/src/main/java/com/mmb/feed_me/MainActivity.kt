package com.mmb.feed_me

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mmb.feed_me.data.repository.PostRepository

class MainActivity : AppCompatActivity() {
    var postRepository: PostRepository? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FeedMeApplication.component.inject(this)
        println("got here")
        val result = postRepository?.getPosts()
            ?.subscribe({
                println(it)
            }, {
                println(it)
            })
    }
}
