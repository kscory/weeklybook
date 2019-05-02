package com.kscory.weeklybook.di

import android.app.Application
import android.content.Context
import com.kscory.weeklybook.presentation.common.resource.ResourceProvider
import com.kscory.weeklybook.presentation.common.resource.ResourceProviderImpl
import com.kscory.weeklybook.utils.rx.AppSchedulerProvider
import com.kscory.weeklybook.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Named("appContext")
    @Singleton
    fun provideContext(application: Application): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideSchedulerProvider(): SchedulerProvider = AppSchedulerProvider()

    @Provides
    @Singleton
    @Named("appResource")
    fun providesResourceProvider(@Named("appContext") context: Context): ResourceProvider =
        ResourceProviderImpl(context)
}