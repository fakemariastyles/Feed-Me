package com.mmb.feed_me

import com.mmb.feed_me.data.entity.PostEntity
import com.mmb.feed_me.remote.dto.PostDto

fun PostDto.toPostEntity() : PostEntity{
    return PostEntity(title = title , body = body , id = id , userId = userId)
}