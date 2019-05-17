package com.kscory.weeklybook.presentation.common.mapper

import androidx.annotation.CheckResult
import com.kscory.weeklybook.presentation.common.rx.SchedulerProvider
import com.kscory.weeklybook.presentation.UIResult
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single

@CheckResult
fun <T> Flowable<T>.toResult(schedulerProvider: SchedulerProvider):
        Flowable<UIResult<T>> {
    return compose { item ->
        item
            .map { UIResult.success(it) }
            .onErrorReturn { e -> UIResult.failure(e.message ?: "unknown", e) }
            .observeOn(schedulerProvider.ui())
            .startWith(UIResult.inProgress())
    }
}

@CheckResult
fun <T> Observable<T>.toResult(schedulerProvider: SchedulerProvider):
        Observable<UIResult<T>> {
    return compose { item ->
        item
            .map { UIResult.success(it) }
            .onErrorReturn { e -> UIResult.failure(e.message ?: "unknown", e) }
            .observeOn(schedulerProvider.ui())
            .startWith(UIResult.inProgress())
    }
}

@CheckResult
fun <T> Single<T>.toResult(schedulerProvider: SchedulerProvider):
        Observable<UIResult<T>> {
    return toObservable().toResult(schedulerProvider)
}

@CheckResult
fun <T> Completable.toResult(schedulerProvider: SchedulerProvider):
        Observable<UIResult<T>> {
    return toObservable<T>().toResult(schedulerProvider)
}