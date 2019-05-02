package com.kscory.weeklybook.di.data

import com.kscory.weeklybook.data.BookRepository
import com.kscory.weeklybook.domain.gateway.BookGateway
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideBookRepository(): BookGateway =
            BookRepository()
}