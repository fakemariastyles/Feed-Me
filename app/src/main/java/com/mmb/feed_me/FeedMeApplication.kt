package com.mmb.feed_me

import android.app.Application
import com.mmb.feed_me.di.ApplicationComponent
import com.mmb.feed_me.di.DaggerApplicationComponent

class FeedMeApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        component = DaggerApplicationComponent
            .builder()
            .application(this)
            .build()
        component.inject(this)
    }
    companion object{
        lateinit var component :ApplicationComponent
    }

}