package com.mmb.feed_me.remote.datasource

import com.mmb.feed_me.remote.api.PostApi
import com.mmb.feed_me.remote.dto.PostDto
import io.reactivex.Observable
import javax.inject.Inject

class PostDataSource @Inject constructor(val postApi: PostApi) {
    fun getPosts(): Observable<List<PostDto>?> {
        return postApi.getPosts()
    }
}