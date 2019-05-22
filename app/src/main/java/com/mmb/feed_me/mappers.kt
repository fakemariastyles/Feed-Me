package com.mmb.feed_me

import com.mmb.feed_me.data.entity.PostEntity
import com.mmb.feed_me.remote.dto.PostDto
import com.mmb.feed_me.ui.mvvm.model.Post

fun PostDto.toPostEntity() : PostEntity{
    return PostEntity(title = title , body = body , id = id , userId = userId)
}

fun PostEntity.toPost() = Post(title = title, body = body, id = id, userId = userId)