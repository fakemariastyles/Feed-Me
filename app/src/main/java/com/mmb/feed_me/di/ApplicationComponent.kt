package com.mmb.feed_me.di

import android.app.Application
import com.mmb.feed_me.FeedMeApplication
import com.mmb.feed_me.ui.MainActivity
import com.mmb.feed_me.di.modules.AppModule
import com.mmb.feed_me.di.modules.NetworkModule
import com.mmb.feed_me.di.modules.PostFragmentModule
import com.mmb.feed_me.ui.mvvm.view.PostFragment
import com.mmb.feed_me.ui.mvvm.view_model.PostViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class , NetworkModule::class , PostFragmentModule::class])
interface ApplicationComponent {
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(app : Application):Builder
        fun build(): ApplicationComponent
    }
    fun inject(app: FeedMeApplication)
    fun inject(mainActivity: MainActivity)
    fun inject(postFragment: PostFragment)
}