package com.kscory.weeklybook.domain.interactor

import com.kscory.weeklybook.domain.baseUseCase.UseCaseSingle
import com.kscory.weeklybook.domain.gateway.BookGateway
import com.kscory.weeklybook.model.Recommendation
import com.kscory.weeklybook.utils.rx.SchedulerProvider
import io.reactivex.Single

class GetBookRecommendedUseCase(
    private val gateway: BookGateway,
    schedulerProvider: SchedulerProvider
): UseCaseSingle<Recommendation, Void>(schedulerProvider) {

    override fun buildUseCaseSingle(params: Void?): Single<Recommendation> {
        return gateway.getBookRecommended()
    }

}