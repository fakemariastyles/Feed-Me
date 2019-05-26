package com.mmb.feed_me.ui.mvvm.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mmb.feed_me.data.repository.PostRepository
import com.mmb.feed_me.toPost
import com.mmb.feed_me.ui.mvvm.model.Post
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostViewModel @Inject constructor(private val postRepository: PostRepository) : ViewModel() {
    private val _postList = MutableLiveData<List<Post>>()
    var postList: LiveData<List<Post>> = _postList
    fun onActivityCreated() {
        postRepository.getPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _postList.postValue(it?.map {
                    it.toPost()
                })
            }, {})
    }
}