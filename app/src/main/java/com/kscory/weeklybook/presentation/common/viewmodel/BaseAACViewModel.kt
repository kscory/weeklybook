package com.kscory.weeklybook.presentation.common.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseAACViewModel: ViewModel() {
    abstract val layoutId: Int
}

abstract class BaseRxAACViewModel: BaseAACViewModel() {

    private val disposables = CompositeDisposable()

    fun Disposable.bindUtilDestroy() {
        if (!disposables.isDisposed) {
            disposables.add(this)
        } else {
            if (!isDisposed) {
                dispose()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}