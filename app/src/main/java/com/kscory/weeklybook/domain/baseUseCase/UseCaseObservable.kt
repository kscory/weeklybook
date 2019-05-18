package com.kscory.weeklybook.domain.baseUseCase

import com.kscory.weeklybook.presentation.common.rx.SchedulerProvider
import io.reactivex.Observable

abstract class UseCaseObservable<Type, in Params>(private val schedulerProvider: SchedulerProvider) {
    internal abstract fun buildUseCaseObservable(params: Params?): Observable<Type>

    fun execute(params: Params? = null): Observable<Type> =
        buildUseCaseObservable(params)
            .subscribeOn(schedulerProvider.io())
}