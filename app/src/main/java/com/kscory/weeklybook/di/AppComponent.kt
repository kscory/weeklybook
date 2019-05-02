package com.kscory.weeklybook.di

import android.app.Application
import com.kscory.weeklybook.BookApplication
import com.kscory.weeklybook.di.presentation.main.MainActivityBuilder
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    MainActivityBuilder::class
])
interface AppComponent : AppDependencies, AndroidInjector<BookApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}