package com.kscory.weeklybook.domain.baseUseCase

import com.kscory.weeklybook.presentation.common.rx.SchedulerProvider
import io.reactivex.Maybe

abstract class UseCaseMaybe<Type, in Params>(private val schedulerProvider: SchedulerProvider) {
    internal abstract fun buildUseCaseMaybe(params: Params?): Maybe<Type>

    fun execute(params: Params? = null): Maybe<Type> =
        buildUseCaseMaybe(params)
            .subscribeOn(schedulerProvider.io())
}