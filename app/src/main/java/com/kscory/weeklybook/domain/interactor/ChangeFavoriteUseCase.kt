package com.kscory.weeklybook.domain.interactor

import com.kscory.weeklybook.domain.baseUseCase.UseCaseSingle
import com.kscory.weeklybook.domain.exception.MissingUseCaseParameterException
import com.kscory.weeklybook.domain.gateway.BookGateway
import com.kscory.weeklybook.presentation.common.rx.SchedulerProvider
import io.reactivex.Single

class ChangeFavoriteUseCase(
    private val gateway: BookGateway,
    schedulerProvider: SchedulerProvider
): UseCaseSingle<Boolean, Pair<Int, Boolean>>(schedulerProvider) {

    override fun buildUseCaseSingle(params: Pair<Int, Boolean>?): Single<Boolean> {
        val (id, isFavorite) = params ?: throw MissingUseCaseParameterException(javaClass)

        return gateway.changeFavorite(id, isFavorite)
    }
}