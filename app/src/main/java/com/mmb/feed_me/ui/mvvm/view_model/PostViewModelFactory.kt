package com.mmb.feed_me.ui.mvvm.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mmb.feed_me.data.repository.PostRepository

class PostViewModelFactory (private val postRepository: PostRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PostViewModel(postRepository) as T
    }

}