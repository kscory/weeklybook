package com.kscory.weeklybook.domain.baseUseCase

import com.kscory.weeklybook.presentation.common.rx.SchedulerProvider
import io.reactivex.Flowable

abstract class UseCaseFlowable<Type, in Params>(private val schedulerProvider: SchedulerProvider) {
    internal abstract fun buildUseCaseFlowable(params: Params?): Flowable<Type>

    fun excute(params: Params? = null): Flowable<Type> =
        buildUseCaseFlowable(params)
            .subscribeOn(schedulerProvider.io())
}