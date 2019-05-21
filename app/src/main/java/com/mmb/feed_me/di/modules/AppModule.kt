package com.mmb.feed_me.di.modules

import com.mmb.feed_me.data.repository.PostRepository
import com.mmb.feed_me.remote.datasource.PostDataSource
import dagger.Module
import dagger.Provides

@Module
class AppModule{
    @Provides
    fun providePostRepository(postDataSource: PostDataSource)
    = PostRepository(postDataSource)
}