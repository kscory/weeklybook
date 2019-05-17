package com.kscory.weeklybook.di.domain

import com.kscory.weeklybook.domain.gateway.BookGateway
import com.kscory.weeklybook.domain.interactor.GetBookRecUseCase
import com.kscory.weeklybook.presentation.common.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class BookUseCaseModule {

    @Provides
    @Singleton
    fun provideGetBookRecommendedUseCase(schedulerProvider: SchedulerProvider,
                                         gateway: BookGateway): GetBookRecUseCase =
            GetBookRecUseCase(gateway, schedulerProvider)
}