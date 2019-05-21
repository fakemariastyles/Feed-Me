package com.mmb.feed_me.remote.api

import com.mmb.feed_me.remote.dto.PostDto
import io.reactivex.Observable
import retrofit2.http.GET

interface PostApi {
    @GET("/posts")
    fun getPosts(): Observable<List<PostDto>?>

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
    }
}