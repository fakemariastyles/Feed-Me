package com.mmb.feed_me.base

import androidx.lifecycle.ViewModel
import com.mmb.feed_me.FeedMeApplication
import com.mmb.feed_me.ui.mvvm.view_model.PostViewModel

abstract class BaseViewModel : ViewModel() {
    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is PostViewModel -> FeedMeApplication.component.inject(this)
        }
    }
}