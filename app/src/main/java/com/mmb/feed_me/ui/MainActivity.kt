package com.mmb.feed_me.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mmb.feed_me.R
import com.mmb.feed_me.data.repository.PostRepository
import com.mmb.feed_me.ui.mvvm.view.PostFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject lateinit var postRepository: PostRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.content_view , PostFragment())
            .commit()
    }
}
