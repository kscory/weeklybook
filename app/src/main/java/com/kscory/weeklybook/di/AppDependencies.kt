package com.kscory.weeklybook.di

import android.content.Context
import com.kscory.weeklybook.domain.gateway.BookGateway
import com.kscory.weeklybook.presentation.common.resource.ResourceProvider
import javax.inject.Named

interface AppDependencies {

    @Named("appContext")
    fun context(): Context

    fun resourceProvider(): ResourceProvider
}