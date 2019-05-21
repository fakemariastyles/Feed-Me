package com.mmb.feed_me.di

import android.app.Application
import com.mmb.feed_me.FeedMeApplication
import com.mmb.feed_me.MainActivity
import com.mmb.feed_me.di.modules.AppModule
import com.mmb.feed_me.di.modules.NetworkModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class , NetworkModule::class])
interface ApplicationComponent {
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(app : Application):Builder
        fun build(): ApplicationComponent
    }
    fun inject(app: FeedMeApplication)
    fun inject(mainActivity: MainActivity)
}