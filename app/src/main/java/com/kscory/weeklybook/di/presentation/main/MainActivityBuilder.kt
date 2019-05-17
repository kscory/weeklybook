package com.kscory.weeklybook.di.presentation.main

import com.kscory.weeklybook.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
interface MainActivityBuilder {
    @ContributesAndroidInjector(modules = [
        MainActivityModule::class,
        HomeFragmentModule::class
    ])
    fun contributeMainActivity(): MainActivity
}