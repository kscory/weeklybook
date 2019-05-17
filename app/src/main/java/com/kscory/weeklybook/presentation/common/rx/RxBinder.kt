package com.kscory.weeklybook.presentation.common.rx

import androidx.lifecycle.Lifecycle
import com.trello.rxlifecycle3.android.ActivityEvent

interface RxBinder {
    fun bindUntil(event: ActivityEvent)
    fun apply(event: Lifecycle.Event)
}

class RxBinderImpl: RxBinder{
    override fun bindUntil(event: ActivityEvent) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun apply(event: Lifecycle.Event) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}