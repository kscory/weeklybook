package com.kscory.weeklybook.di.presentation

import com.kscory.weeklybook.di.presentation.main.MainActivityModule
import com.kscory.weeklybook.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBinder {
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    internal abstract fun contributeMainActivity(): MainActivity
}