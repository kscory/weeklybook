package com.kscory.weeklybook

import android.content.Context
import com.kscory.weeklybook.di.AppComponent
import com.kscory.weeklybook.di.AppDependencies
import com.kscory.weeklybook.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class BookApplication: DaggerApplication() {

    private lateinit var component: AppComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        component = DaggerAppComponent
            .builder()
            .application(this)
            .build()

        return component
    }

    fun appDependencies() = component
}

fun Context.appDependencies(): AppDependencies {
    return if (this is BookApplication) {
        this.appDependencies()
    } else {
        (applicationContext as BookApplication).appDependencies()
    }
}