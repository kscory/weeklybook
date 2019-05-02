package com.kscory.weeklybook.domain.baseUseCase

import com.kscory.weeklybook.utils.rx.SchedulerProvider
import io.reactivex.Completable

abstract class UseCaseCompletable<in Params>(private val schedulerProvider: SchedulerProvider) {
    internal abstract fun buildUseCaseCompletable(params: Params?): Completable

    fun execute(params: Params?): Completable =
        buildUseCaseCompletable(params)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
}