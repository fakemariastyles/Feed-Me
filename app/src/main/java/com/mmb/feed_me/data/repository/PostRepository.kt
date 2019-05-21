package com.mmb.feed_me.data.repository

import com.mmb.feed_me.data.entity.PostEntity
import com.mmb.feed_me.remote.datasource.PostDataSource
import com.mmb.feed_me.toPostEntity
import io.reactivex.Observable
import javax.inject.Inject

class PostRepository @Inject constructor(val postDataSource: PostDataSource) {
    fun getPosts(): Observable<List<PostEntity>?> {
        return postDataSource.getPosts().map { items ->
            items.map { postDto ->
                postDto.toPostEntity()
            }
        }
    }
}