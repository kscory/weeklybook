package com.kscory.weeklybook.di.domain

import com.kscory.weeklybook.domain.gateway.BookGateway
import com.kscory.weeklybook.domain.interactor.GetBookRecommendedUseCase
import com.kscory.weeklybook.utils.rx.AppSchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class BookUseCaseModule {

    @Provides
    @Singleton
    fun provideGetBookRecommendedUseCase(schedulerProvider: AppSchedulerProvider,
                                         gateway: BookGateway): GetBookRecommendedUseCase =
            GetBookRecommendedUseCase(gateway, schedulerProvider)
}