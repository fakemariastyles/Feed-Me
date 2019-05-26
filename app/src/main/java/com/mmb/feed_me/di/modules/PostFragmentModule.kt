package com.mmb.feed_me.di.modules

import com.mmb.feed_me.data.repository.PostRepository
import com.mmb.feed_me.ui.mvvm.view_model.PostViewModel
import dagger.Module
import dagger.Provides

@Module
class PostFragmentModule {
    @Provides
    fun providePostViewModel(postRepository: PostRepository) : PostViewModel{
        return PostViewModel(postRepository)
    }
}