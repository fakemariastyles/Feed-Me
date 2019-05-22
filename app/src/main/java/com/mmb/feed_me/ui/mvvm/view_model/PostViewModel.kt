package com.mmb.feed_me.ui.mvvm.view_model

import com.mmb.feed_me.base.BaseViewModel
import com.mmb.feed_me.data.entity.PostEntity
import com.mmb.feed_me.data.repository.PostRepository
import com.mmb.feed_me.toPost
import com.mmb.feed_me.ui.mvvm.model.Post
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.operators.single.SingleDoAfterSuccess
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostViewModel @Inject constructor(private val postRepository: PostRepository) :
    BaseViewModel() {
    var list : List<Post>? = null
    fun getPosts(success: (List<Post>?) -> Unit) {
        val result = postRepository.getPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                onPostFetchSuccess(it , success)
            }, {
                onPostFetchError(it)
            })
    }

    private fun onPostFetchSuccess(items: List<PostEntity>? , success: (List<Post>?) -> Unit) {
        list = items?.map { postEntity ->
            postEntity.toPost()
        }
        success(list)
    }

    private fun onPostFetchError(throwable: Throwable) {
        println(throwable)
    }
}