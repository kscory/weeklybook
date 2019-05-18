package com.kscory.weeklybook.domain.baseUseCase

import com.kscory.weeklybook.presentation.common.rx.SchedulerProvider
import io.reactivex.Single

abstract class UseCaseSingle<Type, in Params>(private val schedulerProvider: SchedulerProvider) {
    internal abstract fun buildUseCaseSingle(params: Params?): Single<Type>

    fun execute(params: Params? = null): Single<Type> =
        buildUseCaseSingle(params)
            .subscribeOn(schedulerProvider.io())
}