package com.kscory.weeklybook.domain.gateway

import com.kscory.weeklybook.model.Recommendation
import io.reactivex.Single

interface BookGateway {
    fun getBookRecommended(): Single<Recommendation>
}